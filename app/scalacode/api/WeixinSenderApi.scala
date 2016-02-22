package scalacode.api

import javacode.util.http.HttpMethod

import scalacode.entity.{AccessToken, GetAccessTokenParam, WeixinServer}
import scalacode.exception.WeixinException

/**
 * Created by Administrator on 2016/1/19.
 */
class WeixinSenderApi extends BaseApi {

  /**
   * 获取AcessToken
   * @param getAccessTokenParam
   * @throws com.young.scala.weixin.exception.WeixinException
   * @return
   */
  @throws(classOf[WeixinException])
  def getAccessToken(getAccessTokenParam: GetAccessTokenParam): AccessToken = {
    val url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + getAccessTokenParam.grant_type + "&appid=" + getAccessTokenParam.appid + "&secret=" + getAccessTokenParam.secret
    val response = http.sendRequest(url, HttpMethod.GET, null)
    parserJson(response, classOf[AccessToken])
  }

  /**
   * 獲取微信服務器列表
   * @param accessToken
   * @throws com.young.scala.weixin.exception.WeixinException
   * @return
   */
  @throws(classOf[WeixinException])
  def getWeixinServerList(accessToken: AccessToken): WeixinServer = {
    val url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=" + accessToken.access_token
    val response = http.sendRequest(url, HttpMethod.GET, null)
    parserJson(response, classOf[WeixinServer])
  }
}
