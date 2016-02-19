package controllers

import models.user.User
import play.api.libs.json.Json
import play.api.mvc._

object Application extends Controller {


  implicit val myEncodeChartset = Codec.javaSupported("utf-8")

  implicit val personFormat = Json.format[User]

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  /**
   * 必须写上implict request=> 这样下面才能使用session
   * @param id
   * @return
   */
  def getUser(id: Int) = Action { implicit request =>
    val user = User(id, "yangyong", "杨勇")
    //Ok(Json.toJson(user))
    //因为Session是利用cookie跟踪实现的,所以每次比如把所有的session都写进cookie中,最大能写4k
    Ok(Json.toJson(user) + "|" + request.session.get("name" + (id - 1))).withSession(request.session + ("name" + id -> id.toString)).as(JSON)
  }

  def getName(name: String) = Action {
    Ok(name)
  }

  def getVersion(version: String) = Action {
    Ok(version)
  }

  /**
   * play支持Session(会话,采用cookie跟踪实现)和Flash(类似于java里的Request,只能将数据传递给下一个request请求)
   * 但是Seesion不能作为缓存来使用,play内部提供了缓存的实现,默认情况下Seesion没有超时,当用户关掉浏览器的时候才
   * 过期,当然也可以设置一个时间戳来设置超时,application.conf maxAge
   */

  def getSession(name: String) = Action { implicit request =>
    //将name报存在session中
    // Ok("i receive name ="+name).withSession("sessionName"->name)
    //增加一个sesssion的值
    //Ok("add a session value =" + name).withSession(request.session + ("name1" -> name))
    //读取session值
    println(request.session.get("name"))
    //去掉一个session的值
    //Ok("remove a session value = " + name).withSession(request.session - ("name1"))
    Ok("remove all session").withNewSession

  }

  /**
   * Flash范围只能用于传输success/fail消息简单的非ajax应用程序
   * @param name
   * @return
   */
  def getFlash(name: String) = Action { implicit request =>
    Ok("sdfsdf").flashing(("key" -> "value"))
  }

  def bodyParser() = Action {
    request =>
      val body: AnyContent = request.body
      val textBody: Option[String] = body.asText

      // Expecting text body
      textBody.map { text =>
        Ok("Got: " + text)
      }.getOrElse {
        BadRequest("Expecting text/plain request body")
      }
  }
}