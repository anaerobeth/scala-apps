package example

import scala.concurrent._, duration._
import core.Weather

object WeatherApp extends App {
  val w = Await.result(Weather.weather, 10.seconds)
  val loc = Weather.loc
  val Array(condition, temp) = w.split("#")
  println(s"The weather in $loc is $condition. It is currently $temp F.")
  Weather.http.close()
}
