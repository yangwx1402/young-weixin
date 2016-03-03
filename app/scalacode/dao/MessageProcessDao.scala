package scalacode.dao

import java.util.Date
import javacode.util.date.DateUtils

import play.Logger
import play.api.db.DB

import scalacode.entity.TextMessage

/**
 * Created by Administrator on 2016/2/23.
 */
object MessageProcessDao extends BaseDao {

  import play.api.Play.current

  def saveTextMessage(textMessage: TextMessage): Unit = {
    DB.withConnection {
      connection =>
        val sql = "insert into  weixin_receive_message_text(username,text,createtime,updatetime) values(?,?,?,?)"
        Logger.info("sql --["+sql+"]")
        val ps = connection.prepareStatement(sql)
        ps.setString(1, textMessage.FromUserName)
        ps.setString(2, textMessage.Content)
        ps.setString(3, DateUtils.getDateString(defaultDateFormat, new Date()))
        ps.setString(4, DateUtils.getDateString(defaultDateFormat, new Date()))
        ps.executeUpdate()
    }
  }
}
