package code.http

import net.liftweb.http.rest.RestHelper
import net.liftweb.json.JsonAST.{JField, JString}
import wvlet.log.LogSupport

/**
  * Created by ryoco on 2016/09/13.
  */
object JsonHelper extends RestHelper with LogSupport {
  serve {
    case JsonPost("project" :: "json" :: Nil, json) =>
      logger.debug(json._1.toString)
      val i = for {
        JField("m", JString(message)) <- json._1
      } yield message
      logger.info(i.toString)

      json._1
  }

}
