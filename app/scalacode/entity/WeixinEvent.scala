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

  override def toString():String={
    "ToUserName="+ToUserName+",FromUserName="+FromUserName+",CreateTime="+CreateTime+",MsgType="+MsgType+",Event="+Event
  }
}

@XStreamAlias("xml")
class SubscribeEvent extends WeixinEvent {
  @BeanProperty var EventKey: String = ""
  @BeanProperty var Ticket: String = ""

  override def toString(): String = {
    super.toString() + ",EventKey=" + EventKey + ",Ticket=" + Ticket
  }
}

  @XStreamAlias("xml")
  class ClickOrViewMenuEvent extends WeixinEvent{
    @BeanProperty var EventKey:String = ""
    override def toString(): String = {
      super.toString() + ",EventKey=" + EventKey
    }
  }

  @XStreamAlias("xml")
  class ReportPositionEvent extends WeixinEvent{
    @BeanProperty var Latitude:String = ""
    @BeanProperty var Longitude:String = ""
    @BeanProperty var Precision:String = ""

    override def toString(): String = {
      super.toString() + ",Latitude=" + Latitude+",Longitude="+Longitude+",Precision="+Precision
    }
  }
