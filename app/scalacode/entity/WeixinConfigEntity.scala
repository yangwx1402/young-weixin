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

  override def toString(): String = {
    "name=" + name
  }
}

@XStreamAlias("todoConfig")
class TodoConfig {
  @BeanProperty var conditionValue: String = ""
  @BeanProperty var entityClass: String = ""
  @BeanProperty var processClass: String = ""
  @BeanProperty var processMethod: String = ""

  override def toString(): String = {
    "conditionValue=" + conditionValue + "entityClass=" + entityClass + ",processClass=" + processClass + ",processMethod=" + processMethod
  }
}

@XStreamAlias("process")
class Process {
  @BeanProperty
  @XStreamAsAttribute var msgType: String = ""
  @BeanProperty
  @XStreamAsAttribute var desc: String = ""

  @BeanProperty var condition: Condition = null
  @XStreamImplicit(itemFieldName = "todoConfig")
  @BeanProperty var todoConfig: Array[TodoConfig] = Array[TodoConfig]()

  override def toString(): String = {
    "msgType=" + msgType + ",desc=" + desc + ",condition=" + condition + ",todoConfig=" + todoConfig
  }
}

@XStreamAlias("processConfig")
class ProcessConfig {
  @BeanProperty
  @XStreamImplicit(itemFieldName = "process") var process: Array[Process] = Array[Process]()
}
