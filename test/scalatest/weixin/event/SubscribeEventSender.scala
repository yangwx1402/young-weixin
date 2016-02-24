package scalatest.weixin.event

import javacode.util.http.{HttpMethod, HttpUtils}

import scalacode.entity.SubscribeEvent
import scalatest.weixin.api.BaseTest

/**
 * Created by dell on 2016/2/23.
 */
object SubscribeEventSender extends BaseTest{

  def main(args: Array[String]) {
    val event = new SubscribeEvent()
    event.CreateTime="createTime"
    event.EventKey = "eventKey"
    event.Event = "unsubscribe"
    event.Ticket = "ticket"
    event.FromUserName = "oGDhoxAIC7rBZiFr8YpF0gww6L0c"
    event.ToUserName = "toUserName"
    event.MsgType = "event"
    val url = "http://localhost/weixin/message"
    val http = new HttpUtils
    http.sendPostRequest(url,HttpMethod.POST,xml.toXml(event))
  }
}
