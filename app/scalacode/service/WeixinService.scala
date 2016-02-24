package scalacode.service

import java.io.StringReader
import javacode.util.xml.JdomUtils

import play.Logger

import scalacode.dao.EventProcessDao
import scalacode.entity._
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/20.
 */
class WeixinService extends BaseSerivce {

  def checkToken(checkDevelopMessage: CheckDevelopMessage): Boolean = {
    CheckUtils.checkSignature(WeixinConfigFactory.weixinConfig.appInfo.token, checkDevelopMessage)
  }

  /**
   * 处理用户关注和取消关注事件
   * @param subscribeEvent
   */
  private def processSubscribeEvent(subscribeEvent: SubscribeEvent): Unit = {
    Logger.info("user subscribe event = "+subscribeEvent)
    val flag = EventProcessDao.subscribeUserExist(subscribeEvent.FromUserName)
    if (flag) {
      EventProcessDao.updateSubscribeUser(subscribeEvent)
    } else {
      EventProcessDao.saveUserSubscribe(subscribeEvent)
    }
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
        processSubscribeEvent(event)
        //用户取消关注
      } else if (WeixinConstants.MSG_TYPE_EVENT_UNSUBSCRIBE.equals(eventType)) {
        val event = jdom.selectFields(root, classOf[SubscribeEvent])
        Logger.info("receive a user unsubscribe message = " + event)
        processSubscribeEvent(event)
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
