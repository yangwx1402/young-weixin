package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}

import scalacode.entity.CheckDevelopMessage
import scalacode.service.WeixinService
import scalacode.util.CheckUtils

/**
 * Created by Administrator on 2016/2/20.
 */
object WeixinMessageController extends Controller {

  val weixinService = new WeixinService

  def checkToken(signature: String, timestamp: String, nonce: String, echostr: String) = Action {
    Logger.info("receive weixin server pamameter signature=" + signature + ",timestamp=" + timestamp + ",nonce=" + nonce + ",echostr=" + echostr)
    if (weixinService.checkToken(CheckDevelopMessage(signature, timestamp, nonce, echostr))) {
      Ok(echostr)
    } else {
      Ok("check error")
    }
  }

  def processWeixinMessage = Action(parse.tolerantText) { request =>
    val xmlContent = if(request.body.isEmpty) "" else request.body
    Logger.info("receive weixin Server content=[  " + xmlContent + "   ]")
    weixinService.processWeixinMessage(xmlContent)
    Ok("")
  }
}
