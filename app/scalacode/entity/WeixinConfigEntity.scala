package scalacode.entity

import com.thoughtworks.xstream.annotations.{XStreamImplicit, XStreamAsAttribute, XStreamAlias}

import scala.beans.BeanProperty

/**
 * Created by dell on 2016/1/20.
 */
@XStreamAlias("weixin")
class WeixinConfig {
  @BeanProperty var appInfo: WeixinAppInfo = null
  @BeanProperty var processConfig: ProcessConfig = null
}

@XStreamAlias("appInfo")
class WeixinAppInfo {
  @BeanProperty var appID: String = ""
  @BeanProperty var appsecret: String = ""
  @BeanProperty var token: String = ""
}

@XStreamAlias("condition")
class Condition {
  @BeanProperty var name: String = ""
  @BeanProperty var value: String = ""
}

@XStreamAlias("todoConfig")
class TodoConfig {
  @BeanProperty var xmlClass: String = ""
}

@XStreamAlias("process")
class Process {
  @BeanProperty
  @XStreamAsAttribute var msgType: String = ""
  @BeanProperty
  @XStreamAsAttribute var desc: String = ""

  @BeanProperty var conditions: Array[Condition] = Array[Condition]()
  @BeanProperty var todoConfig: TodoConfig = null
}

@XStreamAlias("processConfig")
class ProcessConfig {
  @BeanProperty
  @XStreamImplicit(itemFieldName = "process") var process: Array[Process] = Array[Process]()
}
