package scalatest.xstream

import java.io.FileInputStream
import javacode.util.xml.XStreamUtils

import scalacode.entity._

/**
 * Created by Administrator on 2016/2/22.
 */
object XStreamTest {

  def main(args: Array[String]) {
    val stream = new XStreamUtils(Array(classOf[WeixinConfig],classOf[WeixinAppInfo],classOf[TodoConfig],classOf[ProcessConfig],classOf[Process]))
    val configFile = "E:\\young\\scala\\young-weixin\\conf\\api-config.xml"
    val weixinConfig = stream.fromXmlStream(new FileInputStream(configFile),classOf[WeixinConfig])
    println(weixinConfig.getProcessConfig.process(0))
  }
}
