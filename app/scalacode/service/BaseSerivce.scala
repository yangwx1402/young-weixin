package scalacode.service

import javacode.util.xml.{XStreamUtils, JdomUtils}

import scalacode.entity.{TextMessage, WeixinConfigFactory, CheckDevelopMessage}
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/22.
 */
trait BaseSerivce {
  val jdom = new JdomUtils


  def checkToken(checkDevelopMessage: CheckDevelopMessage): Boolean = {
    CheckUtils.checkSignature(WeixinConfigFactory.weixinConfig.appInfo.token, checkDevelopMessage)
  }
}
