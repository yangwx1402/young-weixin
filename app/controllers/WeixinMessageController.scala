package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}

import scalacode.entity.CheckDevelopMessage
import scalacode.service.WeixinDispatcherService

/**
 * Created by Administrator on 2016/2/20.
 */
object WeixinMessageController extends Controller {

  override val ACCEPT_CHARSET = "utf-8"

  val weixinService = new WeixinDispatcherService

  def checkToken(signature: String, timestamp: String, nonce: String, echostr: String) = Action {
    Logger.info("receive weixin server pamameter signature=" + signature + ",timestamp=" + timestamp + ",nonce=" + nonce + ",echostr=" + echostr)
    if (weixinService.checkToken(CheckDevelopMessage(signature, timestamp, nonce, echostr))) {
      Ok(echostr)
    } else {
      Ok("check error")
    }
  }

  def processWeixinMessage = Action(parse.tolerantText) { request =>
    Logger.info("request charset is -[" + (if (request.charset == None) request.charset else request.charset.get) + "]")
    val xmlContent = if (request.body.isEmpty) "" else request.body
    Logger.info("receive weixin Server content=[  " + xmlContent + "   ]")
    val response = weixinService.dispatchMessage(xmlContent)
    Logger.info("response weixin Server content=[" + response + "]")
    Ok(response)
  }
}
