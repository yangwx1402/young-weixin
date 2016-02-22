package scalacode.entity

import com.thoughtworks.xstream.annotations.XStreamAlias

import scala.beans.BeanProperty

/**
 * Created by Administrator on 2016/2/20.
 */
@XStreamAlias("xml")
class WeixinEvent{
  @BeanProperty var ToUserName:String = ""
  @BeanProperty var FromUserName:String = ""
  @BeanProperty var CreateTime:String = ""
  @BeanProperty var MsgType:String = ""
  @BeanProperty var Event:String = ""
}

@XStreamAlias("xml")
class SubscribeEvent extends WeixinEvent{
  @BeanProperty var EventKey:String = ""
  @BeanProperty var Ticket:String = ""
}






