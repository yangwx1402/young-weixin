package scalacode.entity

import com.thoughtworks.xstream.annotations.XStreamAlias

import scala.beans.BeanProperty

/**
 * Created by dell on 2016/1/20.
 */
@XStreamAlias("weixin")
class WeixinConfig {
  @BeanProperty var appInfo:WeixinAppInfo = null;
}

@XStreamAlias("appInfo")
class WeixinAppInfo {
  @BeanProperty var appID: String = ""
  @BeanProperty var appsecret: String = ""
}
