package scalacode.service

import scalacode.dao.MessageProcessDao
import scalacode.entity._

/**
 * Created by Administrator on 2016/2/24.
 */
class WeixinMessageService {

  def processTextMessage(textMessage: TextMessage): Unit ={
      MessageProcessDao.saveTextMessage(textMessage)
  }

  def processVideoMessage(videoMessage: VideoMessage): Unit ={

  }

  def processImageMessage(imageMessage: ImageMessage): Unit ={

  }

  def processLinkMessage(linkMessage: LinkMessage): Unit ={

  }

  def processPositionMessage(positionMessage: PositionMessage): Unit ={

  }

  def processVoiceMessage(voiceMessage: VoiceMessage): Unit ={

  }
}
