package scalacode.entity

import com.thoughtworks.xstream.annotations.XStreamAlias

import scala.beans.BeanProperty

/**
 * Created by Administrator on 2016/1/20.
 */
/**
 * 用于接收微信服务端post过来的消息
 */
//@XStreamAlias("xml")
//class ReceiveNormalMessage{
//  @BeanProperty var ToUserName: String = ""
//  @BeanProperty var FromUserName: String = ""
//  @BeanProperty var CreateTime: Long = 0
//  @BeanProperty var MsgType: String = ""
//  @BeanProperty var MsgId: Long = 0
//
//  @BeanProperty var Content: String = ""
//
//  @BeanProperty var PicUrl: String = ""
//  @BeanProperty var MediaId: String = ""
//
//  @BeanProperty var Format: String = ""
//
//  @BeanProperty var ThumbMediaId: String = ""
//
//  @BeanProperty var Location_X: String = ""
//  @BeanProperty var Location_Y: String = ""
//  @BeanProperty var Scale: String = ""
//  @BeanProperty var Label: String = ""
//
//  @BeanProperty var Title:String =""
//  @BeanProperty var Description:String = ""
//  @BeanProperty var Url:String =""
//
//}

class NormalMessage {
  @BeanProperty var ToUserName: String = ""
  @BeanProperty var FromUserName: String = ""
  @BeanProperty var CreateTime: Long = 0
  @BeanProperty var MsgType: String = ""
  @BeanProperty var MsgId: Long = 0
}

/**
 * 文本消息
 */
class TextMessage extends NormalMessage {
  @BeanProperty var Content: String = ""

}

/**
 * 图片消息
 */
class ImageMessage extends NormalMessage {
  @BeanProperty var PicUrl: String = ""
  @BeanProperty var MediaId: String = ""
}

/**
 * 声音消息
 */
class VoiceMessage extends NormalMessage {
  @BeanProperty var MediaId: String = ""
  @BeanProperty var Format: String = ""
}

/**
 * 视频和短视频消息
 */
class VideoMessage extends NormalMessage {
  @BeanProperty var MediaId: String = ""
  @BeanProperty var ThumbMediaId: String = ""
}

/**
 * 位置信息消息
 */
class PositionMessage extends NormalMessage {
  @BeanProperty var Location_X: String = ""
  @BeanProperty var Location_Y: String = ""
  @BeanProperty var Scale: String = ""
  @BeanProperty var Label: String = ""
}

/**
 * 链接消息
 */
class LinkMessage extends NormalMessage{
  @BeanProperty var Title:String =""
  @BeanProperty var Description:String = ""
  @BeanProperty var Url:String =""
}