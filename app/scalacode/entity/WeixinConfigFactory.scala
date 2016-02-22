package scalacode.entity

import javacode.util.xml.XStreamUtils

import org.apache.commons.io.IOUtils
import play.Logger

/**
 * Created by Administrator on 2016/2/22.
 */
object WeixinConfigFactory {

  private val stream = new XStreamUtils(Array(classOf[WeixinConfig], classOf[WeixinAppInfo], classOf[TodoConfig], classOf[ProcessConfig], classOf[Process], classOf[Condition]))

  Logger.info(IOUtils.toString(this.getClass.getResourceAsStream("/api-config.xml")))

  val weixinConfig = stream.fromXmlStream(this.getClass.getResourceAsStream("/api-config.xml"), classOf[WeixinConfig])

}
