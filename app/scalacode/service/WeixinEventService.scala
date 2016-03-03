package scalacode.service

import javacode.util.xml.XStreamFactory

import play.Logger

import scalacode.dao.EventProcessDao
import scalacode.entity.{WeixinConstants, ImageContentResponseMessage, ImageContentResponseMessageArticleItem, SubscribeEvent}

/**
 * Created by Administrator on 2016/2/24.
 */
class WeixinEventService {
  /**
   * 处理用户关注和取消关注事件
   * @param subscribeEvent
   */
  def processSubscribeEvent(subscribeEvent: SubscribeEvent): String = {
    Logger.info("user subscribe event = " + subscribeEvent)
    val flag = EventProcessDao.subscribeUserExist(subscribeEvent.FromUserName)
    if (flag) {
      EventProcessDao.updateSubscribeUser(subscribeEvent)
    } else {
      EventProcessDao.saveUserSubscribe(subscribeEvent)
    }
    if (WeixinConstants.MSG_TYPE_EVENT_SUBSCRIBE.equals(subscribeEvent.Event)) {
      val stream = XStreamFactory.getInstance(Array(classOf[ImageContentResponseMessage], classOf[ImageContentResponseMessageArticleItem]))
      val responseMessage = stream.fromXmlStream(this.getClass.getResourceAsStream("/subscribe-response.xml"), classOf[ImageContentResponseMessage])
      responseMessage.FromUserName = subscribeEvent.ToUserName
      responseMessage.ToUserName = subscribeEvent.FromUserName
      responseMessage.CreateTime = System.currentTimeMillis() + ""
      stream.toXml(responseMessage)
    } else {
      WeixinConstants.MSG_NO_CONTENT
    }
  }
}
