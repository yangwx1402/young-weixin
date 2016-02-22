package scalacode.api

import javacode.util.json.JsonUtils

import org.apache.commons.logging.LogFactory

import scalacode.entity.{ErrorMessage, WeixinResponse}
import scalacode.exception.WeixinException

/**
 * Created by dell on 2016/1/20.
 */
trait Api {

  var log = LogFactory.getLog(classOf[Api])
  @throws(classOf[WeixinException])
  def parserJson[T <: ErrorMessage](response: WeixinResponse, clazz: Class[T]): T = {
    if (response.getStateCode != 200) {
      throw new WeixinException("接口调用失败,cause:[" + response.getMessage + "]", null)
    }
    try {
      val t: T = JsonUtils.getObject(response.getContent, clazz)
      if (t.errcode != 0) {
        throw new WeixinException("接口返回错误,请检查参数,content:[" + t + "]", null)
      }
      t
    } catch {
      case e: Exception => throw new WeixinException("接口调用失败,content:[" + response.getContent + "]", e)
    }
  }
}
