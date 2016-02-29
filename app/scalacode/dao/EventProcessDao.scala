package scalacode.dao

import java.util.Date
import javacode.util.date.DateUtils

import play.Logger
import play.api.db.DB
import play.api.Play.current
import scalacode.entity.SubscribeEvent

/**
 * Created by Administrator on 2016/2/23.
 */
object EventProcessDao extends BaseDao{

  def saveUserSubscribe(subscribeEvent: SubscribeEvent): Unit = {
    DB.withConnection { connection =>
      val sql = "insert into weixin_subscribe_info(username,status,createtime,updatetime) values (?,?,?,?)"
      Logger.info("sql --["+sql+"]")
      val ps = connection.prepareStatement(sql)
      ps.setString(1, subscribeEvent.FromUserName)
      ps.setString(2, subscribeEvent.Event)
      ps.setString(3, DateUtils.getDateString(defaultDateFormat, new Date()))
      ps.setString(4, DateUtils.getDateString(defaultDateFormat, new Date()))
      ps.executeUpdate()
      ps.close()
    }
  }

  def subscribeUserExist(username: String): Boolean = {
    DB.withConnection { connection =>
      val sql = "select * from weixin_subscribe_info where username = ?"
      Logger.info("sql --["+sql+"]")
      val ps = connection.prepareStatement(sql)
      ps.setString(1, username)
      val rs = ps.executeQuery()
      if (rs.next()) true else false
    }
  }

  def updateSubscribeUser(subscribeEvent: SubscribeEvent): Unit = {
    DB.withConnection {
      connection =>
        val sql = "update weixin_subscribe_info set status=? , updatetime=? where username =?"
        Logger.info("sql --["+sql+"]")
        val ps = connection.prepareStatement(sql)
        ps.setString(1, subscribeEvent.Event)
        ps.setString(2, DateUtils.getDateString(defaultDateFormat, new Date()))
        ps.setString(3, subscribeEvent.FromUserName)
        ps.executeUpdate()
        ps.close()
    }
  }

}
