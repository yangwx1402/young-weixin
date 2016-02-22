package scalacode.service

import java.io.StringReader
import javacode.util.xml.JdomUtils

import scalacode.entity.WeixinConstants

/**
 * Created by Administrator on 2016/2/20.
 */
class WeixinService {

  val jdom = new JdomUtils

  def processWeixinMessage(xmlContent: String): Unit = {
    val root = jdom.getRootElement(new StringReader(xmlContent))
    val msgType = jdom.selectField(root, WeixinConstants.MSG_TYPE_NAME)
    if (WeixinConstants.MSG_TYPE_EVENT.equals(msgType)) {
      val eventType = jdom.selectField(root, WeixinConstants.MSG_EVENT_NAME)
      if (WeixinConstants.MSG_TYPE_EVENT_SUBSCRIBE.equals(eventType)) {

      } else if (WeixinConstants.MSG_TYPE_EVENT_UNSUBSCRIBE.equals(eventType)) {

      }
    } else if (WeixinConstants.MSG_TYPE_EVENT.equals(msgType)) {

    }
  }
}
