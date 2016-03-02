package scalacode.entity

import javacode.util.xml.XStreamFactory

import org.apache.commons.io.IOUtils
import play.Logger

/**
 * Created by Administrator on 2016/2/22.
 */
object WeixinConfigFactory {

  private val stream = XStreamFactory.getInstance(Array(classOf[WeixinConfig], classOf[WeixinAppInfo], classOf[TodoConfig], classOf[ProcessConfig], classOf[Process]))

  Logger.info(IOUtils.toString(this.getClass.getResourceAsStream("/api-config.xml")))

  lazy val weixinConfig = stream.fromXmlStream(this.getClass.getResourceAsStream("/api-config.xml"), classOf[WeixinConfig])

}
