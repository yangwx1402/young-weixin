package scalacode.service

import java.io.StringReader
import javacode.util.xml.JdomUtils

import scalacode.entity.{WeixinConfigFactory, CheckDevelopMessage, WeixinConstants}
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/20.
 */
class WeixinService extends BaseSerivce{

  val jdom = new JdomUtils

  def checkToken(checkDevelopMessage: CheckDevelopMessage): Boolean ={
    CheckUtils.checkSignature(WeixinConfigFactory.weixinConfig.appInfo.token,checkDevelopMessage)
  }

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
