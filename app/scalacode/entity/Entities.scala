package scalacode.entity

import scala.beans.BeanProperty

/**
 * Created by Administrator on 2016/1/19.
 */


sealed trait Message

case class CheckDevelopMessage(signature: String, timestamp: String, nonce: String, echostr: String) extends Message

class ErrorMessage {
  @BeanProperty var errcode:Int = 0
  @BeanProperty var errmsg:String = ""
}

class AccessToken extends ErrorMessage{
  @BeanProperty var access_token: String = ""
  @BeanProperty var expires_in: Int = 0
}

class WeixinServer extends ErrorMessage{
  @BeanProperty var ip_list:Array[String] = Array[String]()
}



case class GetAccessTokenParam(grant_type: String, appid: String, secret: String)



