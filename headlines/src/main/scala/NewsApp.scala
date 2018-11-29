import org.jsoup.Jsoup
import scala.collection.JavaConverters._
object NewsApp extends App {
  val bbc = Map("source" -> "BBC News", "url" -> "http://www.bbc.com/news", "selector" -> ".nw-c-most-read__items .gs-c-promo-heading__title")

  val nytimes = Map("source" -> "NYTimes", "url" -> "https://www.nytimes.com/section/us", "selector" -> "li h2 a")
  val nytimes = Map("source" -> "NYTimes", "url" -> "https://www.nytimes.com/section/us", "selector" -> "li h2", "ref" -> "a[href]")

  val axios = Map("source" -> "Axios", "url" -> "https://www.axios.com", "selector" -> "h3")
  var index = 1

  var index = 1
  var links = scala.collection.mutable.Map[String,String]()
  var currentHeadline = ""

  def fetch(site: Map[String, String]) = {
    val doc = Jsoup.connect(site("url")).get()
    val newsHeadlines = doc.select(site("selector"))
    val source = site("source")
    println(f"------------ $source ------------")
    newsHeadlines.asScala.take(6).foreach { h =>
      var href = site("base") + h.attr("href").toString()
      links(index.toString) = href
      print(f"$index - ")
      println(h.text())
      index += 1
    }
  }

  }

  fetch(bbc)
  fetch(nytimes)
  fetch(axios)
}
