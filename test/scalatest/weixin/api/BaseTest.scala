package scalatest.weixin.api

import java.io.FileInputStream
import javacode.util.xml.XStreamUtils

import scalacode.entity.{WeixinAppInfo, WeixinConfig}

/**
 * Created by dell on 2016/1/20.
 */
trait BaseTest {

  val xml = new XStreamUtils(Array(classOf[WeixinConfig],classOf[WeixinAppInfo]))

  val configFile = "E:\\young\\scala\\young-weixin\\conf\\api-config.xml"

  val weixinConfig = xml.fromXmlStream(new FileInputStream(configFile),classOf[WeixinConfig])
}
