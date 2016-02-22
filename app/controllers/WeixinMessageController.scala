package controllers

import play.api.mvc.{Action, Controller}

import scalacode.service.WeixinService

/**
 * Created by Administrator on 2016/2/20.
 */
object WeixinMessageController extends Controller {

  val weixinService = new WeixinService

  def processUserSubscribe = Action { request =>
    val xmlContent = request.body.asText.get
    weixinService.processWeixinMessage(xmlContent)
    Ok("")
  }
}
