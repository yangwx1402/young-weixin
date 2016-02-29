package scalatest.weixin.api

import java.io.FileInputStream
import javacode.util.xml.XStreamUtils

import scalacode.entity._

/**
 * Created by dell on 2016/1/20.
 */
trait BaseTest {

  val xml = new XStreamUtils(Array(classOf[WeixinConfig], classOf[WeixinAppInfo], classOf[TodoConfig], classOf[ProcessConfig], classOf[Process]))

  val configFile = "/api-config.xml"

  val weixinConfig = xml.fromXmlStream(this.getClass.getResourceAsStream(configFile),classOf[WeixinConfig])
}
