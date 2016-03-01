package scalacode.entity

import com.thoughtworks.xstream.annotations.{XStreamImplicit, XStreamAlias}

import scala.beans.BeanProperty

/**
 * Created by Administrator on 2016/3/1.
 */
@XStreamAlias("xml")
class ResponseMessage {
  @BeanProperty var ToUserName: String = ""
  @BeanProperty var FromUserName: String = ""
  @BeanProperty var CreateTime: String = ""
  @BeanProperty var MsgType: String = ""

  override def toString(): String = {
    "ToUserName=" + ToUserName + ",FromUserName=" + FromUserName + ",CreateTime=" + CreateTime + ",MsgType=" + MsgType
  }
}

@XStreamAlias("xml")
class TextResponseMessage extends ResponseMessage {
  @BeanProperty var Content: String = ""
}

@XStreamAlias("xml")
class ImageResponseMessage extends ResponseMessage {
  @BeanProperty var Image: ImageResponseMessageImage = null
}

@XStreamAlias("Image")
class ImageResponseMessageImage {
  @BeanProperty var MediaId: String = ""
}

@XStreamAlias("xml")
class VoiceResponseMessage extends ResponseMessage {
  @BeanProperty var Voice: VoiceResponseMessageVoice = null
}

@XStreamAlias("Voice")
class VoiceResponseMessageVoice {
  @BeanProperty var MediaId: String = ""
}

@XStreamAlias("xml")
class VideoResponseMessage extends ResponseMessage {
  @BeanProperty var Video: VideoResponseMessageVideo = null
}

@XStreamAlias("Video")
class VideoResponseMessageVideo {
  @BeanProperty var Video: String = ""
  @BeanProperty var Title: String = ""
  @BeanProperty var Description: String = ""
}

@XStreamAlias("xml")
class MusicResponseMessage extends ResponseMessage {
  @BeanProperty var Music: MusicResponseMessageMusic = null
}

@XStreamAlias("Music")
class MusicResponseMessageMusic {
  @BeanProperty var Title: String = ""
  @BeanProperty var Description: String = ""
  @BeanProperty var MusicUrl: String = ""
  @BeanProperty var HQMusicUrl: String = ""
  @BeanProperty var ThumbMediaId: String = ""
}

@XStreamAlias("xml")
class ImageContentResponseMessage extends ResponseMessage {
  @BeanProperty var ArticleCount: String = ""
  @XStreamImplicit(itemFieldName = "item")
  @BeanProperty var Articles: Array[ImageContentResponseMessageArticleItem] = Array[ImageContentResponseMessageArticleItem]()
}

@XStreamAlias("item")
class ImageContentResponseMessageArticleItem {
  @BeanProperty var Title: String = ""
  @BeanProperty var Description: String = ""
  @BeanProperty var PicUrl: String = ""
  @BeanProperty var Url: String = ""
}