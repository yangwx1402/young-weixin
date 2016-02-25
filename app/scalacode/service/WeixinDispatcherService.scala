package scalacode.service

import java.io.StringReader
import javacode.util.clazz.ClassUtils
import javacode.util.xml.JdomUtils

import org.jdom2.Element
import play.Logger

import scala.collection.mutable
import scalacode.dao.EventProcessDao
import scalacode.entity._
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/20.
 */
class WeixinDispatcherService extends BaseSerivce {

  private val apiConfig = WeixinConfigFactory.weixinConfig

  private val dispatcherCache = new mutable.HashMap[String, mutable.HashMap[String, TodoConfig]]()

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


  private def findTodo(root: Element, todoMap: mutable.HashMap[String, TodoConfig]): TodoConfig = {
    val todo = todoMap.find(p => p._1.equals(jdom.selectField(root, p._2.getConditionField)))
    if (todo != None)
      todo.get._2
    else
      null
  }


  private def matchTodoConfig(root: Element, msgType: String): TodoConfig = {
    if (dispatcherCache.contains(msgType)) {
      val todoMap = dispatcherCache.get(msgType).get
      findTodo(root, todoMap)
    } else {
      null
    }
  }

  private def processTodo(root: Element, todoConfig: TodoConfig) = {
    Logger.info("processTodo ----todoConfig = "+todoConfig)
    if (todoConfig != null) {
      val className = todoConfig.getEntityClass
      val entity = jdom.selectFields(root, Class.forName(className))
      Logger.info("parser entity is ="+entity)
      val clazz = Class.forName(todoConfig.getProcessClass)
      val method = ClassUtils.getMethod(todoConfig.getProcessMethod, clazz, Class.forName(className))
      method.invoke(clazz.newInstance(), entity)
    }
  }

  def dispatchMessage(xmlContent: String): Unit = {
    val root = jdom.getRootElement(new StringReader(xmlContent))
    val msgType = jdom.selectField(root, WeixinConstants.MSG_TYPE_NAME)
    Logger.info("processWeixinMessage msgType=" + msgType)
    val todoConfig = matchTodoConfig(root, msgType)
    if (todoConfig != null) {
      processTodo(root, todoConfig)
    }
  }

  //  def processWeixinMessage(xmlContent: String): Unit = {
  //    val root = jdom.getRootElement(new StringReader(xmlContent))
  //    val msgType = jdom.selectField(root, WeixinConstants.MSG_TYPE_NAME)
  //    Logger.info("processWeixinMessage msgType=" + msgType)
  //
  //    /**
  //     * 处理接收到的事件请求
  //     */
  //    if (WeixinConstants.MSG_TYPE_EVENT.equals(msgType)) {
  //      val eventType = jdom.selectField(root, WeixinConstants.MSG_EVENT_NAME)
  //      Logger.info("processWeixinMessage eventType=" + eventType)
  //      //用户关注
  //      if (WeixinConstants.MSG_TYPE_EVENT_SUBSCRIBE.equals(eventType)) {
  //        val event = jdom.selectFields(root, classOf[SubscribeEvent])
  //        Logger.info("receive a user subscribe message = " + event)
  //        eventService.processSubscribeEvent(event)
  //        //用户取消关注
  //      } else if (WeixinConstants.MSG_TYPE_EVENT_UNSUBSCRIBE.equals(eventType)) {
  //        val event = jdom.selectFields(root, classOf[SubscribeEvent])
  //        Logger.info("receive a user unsubscribe message = " + event)
  //        eventService.processSubscribeEvent(event)
  //      }
  //      //接收文本消息
  //      /**
  //       * 处理接收到的文本消息
  //       */
  //    } else if (WeixinConstants.MSG_TYPE_TEXT.equals(msgType)) {
  //      val text = jdom.selectFields(root, classOf[TextMessage])
  //      Logger.info("receive a text message = " + text)
  //    }
  //  }
}
