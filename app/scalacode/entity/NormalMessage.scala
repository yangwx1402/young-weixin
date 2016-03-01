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
/**
 * 微信消息基类
 */
@XStreamAlias("xml")
class NormalMessage {
  @BeanProperty var ToUserName: String = ""
  @BeanProperty var FromUserName: String = ""
  @BeanProperty var CreateTime: String = ""
  @BeanProperty var MsgType: String = ""
  @BeanProperty var MsgId: String = ""

  override def toString():String={
    "ToUserName="+ToUserName+",FromUserName="+FromUserName+",CreateTime="+CreateTime+",MsgType="+MsgType+",MsgId="+MsgId
  }
}

/**
 * 文本消息
 */
@XStreamAlias("xml")
class TextMessage extends NormalMessage {
  @BeanProperty var Content: String = ""

  override def toString():String = {
    super.toString()+",Content="+Content
  }
}

/**
 * 图片消息
 */
@XStreamAlias("xml")
class ImageMessage extends NormalMessage {
  @BeanProperty var PicUrl: String = ""
  @BeanProperty var MediaId: String = ""
  override def toString():String = {
    super.toString()+",PicUrl="+PicUrl+",MediaId="+MediaId
  }
}

/**
 * 声音消息
 */
@XStreamAlias("xml")
class VoiceMessage extends NormalMessage {
  @BeanProperty var MediaId: String = ""
  @BeanProperty var Format: String = ""
  override def toString():String = {
    super.toString()+",MediaId="+MediaId+",Format="+Format
  }
}

/**
 * 视频和短视频消息
 */
@XStreamAlias("xml")
class VideoMessage extends NormalMessage {
  @BeanProperty var MediaId: String = ""
  @BeanProperty var ThumbMediaId: String = ""
  override def toString():String = {
    super.toString()+",MediaId="+MediaId+",ThumbMediaId="+ThumbMediaId
  }
}

/**
 * 位置信息消息
 */
@XStreamAlias("xml")
class PositionMessage extends NormalMessage {
  @BeanProperty var Location_X: String = ""
  @BeanProperty var Location_Y: String = ""
  @BeanProperty var Scale: String = ""
  @BeanProperty var Label: String = ""

  override def toString():String = {
    super.toString()+",Location_X="+Location_X+",Location_Y="+Location_Y+",Scale="+Scale+",Label="+Label
  }
}

/**
 * 链接消息
 */
@XStreamAlias("xml")
class LinkMessage extends NormalMessage{
  @BeanProperty var Title:String =""
  @BeanProperty var Description:String = ""
  @BeanProperty var Url:String =""

  override def toString():String = {
    super.toString()+",Title="+Title+",Description="+Description+",Url="+Url
  }
}