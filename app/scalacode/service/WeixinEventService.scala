package scalacode.service

import play.Logger

import scalacode.dao.EventProcessDao
import scalacode.entity.SubscribeEvent

/**
 * Created by Administrator on 2016/2/24.
 */
class WeixinEventService {

  /**
   * 处理用户关注和取消关注事件
   * @param subscribeEvent
   */
  def processSubscribeEvent(subscribeEvent: SubscribeEvent): Unit = {
    Logger.info("user subscribe event = "+subscribeEvent)
    val flag = EventProcessDao.subscribeUserExist(subscribeEvent.FromUserName)
    if (flag) {
      EventProcessDao.updateSubscribeUser(subscribeEvent)
    } else {
      EventProcessDao.saveUserSubscribe(subscribeEvent)
    }
  }
}
