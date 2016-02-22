package scalacode.api

import javacode.util.http.HttpUtils

/**
 * Created by dell on 2016/1/20.
 */
abstract class BaseApi extends Api{

  val http = new HttpUtils()

}
