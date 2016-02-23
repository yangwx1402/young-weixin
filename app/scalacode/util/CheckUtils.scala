package scalacode.util

import java.util
import javacode.util.codec.CodecUtils

import org.apache.commons.lang3.ArrayUtils
import play.api.Logger

import scala.util.Sorting
import scalacode.entity.CheckDevelopMessage

/**
 * Created by Administrator on 2016/1/19.
 */
object CheckUtils {

  def checkSignature(token:String,checkDevelopMessage: CheckDevelopMessage): Boolean = {
    Logger.info("checkSignature ----"+checkDevelopMessage)
    val array = Array[String](token,checkDevelopMessage.timestamp,checkDevelopMessage.nonce)
    Logger.info("order before ="+array.mkString)
    Sorting.quickSort(array)
    Logger.info("order after = "+array.mkString)
    val sha1Code = CodecUtils.SHA1Encode(array(0)+array(1)+array(2))
    checkDevelopMessage.signature.equals(sha1Code)
  }
}
