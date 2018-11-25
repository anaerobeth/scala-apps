package example.core

import gigahorse._, support.okhttp.Gigahorse
import scala.concurrent._
import play.api.libs.json._

object Weather {
  lazy val http = Gigahorse.http(Gigahorse.config)
  var loc: String = ""
  def location: String  = {
    print("Type the city and state here: ")
    loc = scala.io.StdIn.readLine()
    return loc
  }

  def weather: Future[String] = {
    val loc = location
    val qs = s"select item.condition from weather.forecast where woeid in (select woeid from geo.places(1) where text='$loc') and u='c'"
    val r = Gigahorse.url("https://query.yahooapis.com/v1/public/yql").get.
      addQueryString(
        "q" -> qs,
        "format" -> "json"
      )

    import ExecutionContext.Implicits._
    for {
      f <- http.run(r, Gigahorse.asString)
      x <- parse(f, "text")
      y <- parse(f, "temp")
    } yield x.toLowerCase + "#" + y
  }

  def parse(rawJson: String, field: String): Future[String] = {
    val js = Json.parse(rawJson)
    (js \\ field).headOption match {
      case Some(JsString(x)) => Future.successful(x)
      case _                 => Future.failed(sys.error(rawJson))
    }
  }
}
