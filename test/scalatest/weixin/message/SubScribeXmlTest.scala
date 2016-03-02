package scalatest.weixin.message

import javacode.util.xml.XStreamUtils

import scalacode.entity.{ImageContentResponseMessage, ImageContentResponseMessageArticleItem}

/**
 * Created by Administrator on 2016/3/2.
 */
object SubScribeXmlTest {

  def main(args: Array[String]) {
    val xml = new XStreamUtils(Array(classOf[ImageContentResponseMessage],classOf[ImageContentResponseMessageArticleItem]))
    val obj = xml.fromXmlStream(SubScribeXmlTest.getClass.getResourceAsStream("/subscribe-response.xml"),classOf[ImageContentResponseMessage])
    println(obj)
  }
}
