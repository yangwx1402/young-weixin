package scalatest.weixin.message

import javacode.util.http.{HttpMethod, HttpUtils}

import scalacode.entity.{TextMessage, SubscribeEvent}
import scalatest.weixin.event.SubscribeEventSender._

/**
 * Created by dell on 2016/2/29.
 */
object TextMessageSender {

  def main(args: Array[String]) {
    val message = new TextMessage
    message.CreateTime="createTime"
    message.FromUserName = "oGDhoxAIC7rBZiFr8YpF0gww6L0c"
    message.ToUserName = "toUserName"
    message.Content="test"
    message.MsgType = "text"
    val url = "http://localhost/weixin/message"
    val http = new HttpUtils
    val response = http.sendPostRequest(url,HttpMethod.POST,xml.toXml(message))
    println(response.getContent)
  }
}
