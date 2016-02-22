package scalacode.entity

import scala.beans.BeanProperty

/**
 * Created by dell on 2016/1/20.
 */
class WeixinResponse {
  @BeanProperty
  var content: String = "";
  @BeanProperty
  var stateCode: Int = 0;
  @BeanProperty
  var message: String = ""

  def this(content: String, stateCode: Int) {
    this()
    this.content = content;
    this.stateCode = stateCode
  }
}
