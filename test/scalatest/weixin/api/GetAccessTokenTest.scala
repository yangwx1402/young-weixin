package scalatest.weixin.api

import scalacode.api.WeixinSenderApi
import scalacode.entity.GetAccessTokenParam

/**
 * Created by dell on 2016/1/20.
 */
object GetAccessTokenTest extends BaseTest{

  def main(args: Array[String]) {
    val api = new WeixinSenderApi()
    val param: GetAccessTokenParam = GetAccessTokenParam("client_credential", weixinConfig.appInfo.appID, weixinConfig.appInfo.appsecret)
    val token = api.getAccessToken(param)
    println(token.getAccess_token)
    val weixinServer = api.getWeixinServerList(token)
    weixinServer.ip_list.foreach(println _)
  }
}
