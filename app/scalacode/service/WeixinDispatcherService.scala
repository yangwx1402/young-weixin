package scalacode.service

import java.io.StringReader
import javacode.util.xml.JdomUtils

import play.Logger

import scala.collection.mutable
import scalacode.dao.EventProcessDao
import scalacode.entity._
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/20.
 */
class WeixinDispatcherService extends BaseSerivce {

  val messageService = new WeixinMessageService

  val eventService = new WeixinEventService

  val apiConfig = WeixinConfigFactory.weixinConfig

  val dispatcherCache = new mutable.HashMap[String, mutable.HashMap[String, TodoConfig]]()

  private def initDispatcherCache(): Unit = {
    var key = ""
    for (process <- apiConfig.processConfig.process) {
      key = key + process.getMsgType
      val todos = process.todoConfig
      if (todos != null && todos.length > 0) {
        val tempMap = new mutable.HashMap[String, TodoConfig]();
        for (todo <- todos) {
          tempMap.put(todo.conditionValue, todo)
        }
        dispatcherCache.put(key, tempMap)
      }
    }
    Logger.info("dispatcherCache = " + dispatcherCache)
  }

  if (apiConfig.getProcessConfig != null && apiConfig.processConfig.process != null && apiConfig.processConfig.process.length > 0) {
    initDispatcherCache()
  }


  def dispatchMessage(xmlContent: String): Unit = {
    val root = jdom.getRootElement(new StringReader(xmlContent))

  }

  /**
   * 处理微信post到服务端的请求信息
   * @param xmlContent
   */
  def processWeixinMessage(xmlContent: String): Unit = {
    val root = jdom.getRootElement(new StringReader(xmlContent))
    val msgType = jdom.selectField(root, WeixinConstants.MSG_TYPE_NAME)
    Logger.info("processWeixinMessage msgType=" + msgType)

    /**
     * 处理接收到的事件请求
     */
    if (WeixinConstants.MSG_TYPE_EVENT.equals(msgType)) {
      val eventType = jdom.selectField(root, WeixinConstants.MSG_EVENT_NAME)
      Logger.info("processWeixinMessage eventType=" + eventType)
      //用户关注
      if (WeixinConstants.MSG_TYPE_EVENT_SUBSCRIBE.equals(eventType)) {
        val event = jdom.selectFields(root, classOf[SubscribeEvent])
        Logger.info("receive a user subscribe message = " + event)
        eventService.processSubscribeEvent(event)
        //用户取消关注
      } else if (WeixinConstants.MSG_TYPE_EVENT_UNSUBSCRIBE.equals(eventType)) {
        val event = jdom.selectFields(root, classOf[SubscribeEvent])
        Logger.info("receive a user unsubscribe message = " + event)
        eventService.processSubscribeEvent(event)
      }
      //接收文本消息
      /**
       * 处理接收到的文本消息
       */
    } else if (WeixinConstants.MSG_TYPE_TEXT.equals(msgType)) {
      val text = jdom.selectFields(root, classOf[TextMessage])
      Logger.info("receive a text message = " + text)
    }
  }
}
