import org.jsoup.Jsoup
import scala.collection.JavaConverters._
object NewsApp extends App {
  val bbc = Map("source" -> "BBC News", "url" -> "http://www.bbc.com/news", "selector" -> ".nw-c-most-read__items .gs-c-promo-heading__title")

  val nytimes = Map("source" -> "NYTimes", "url" -> "https://www.nytimes.com/section/us", "selector" -> "li h2 a")

  val axios = Map("source" -> "Axios", "url" -> "https://www.axios.com", "selector" -> "h3")

  def fetch(site: Map[String, String]) = {
    val doc = Jsoup.connect(site("url")).get()
    val newsHeadlines = doc.select(site("selector"))
    val source = site("source")
    println(f"------------ $source ------------")
    newsHeadlines.asScala.map(_.text()).take(6).foreach(println)
  }

  fetch(bbc)
  fetch(nytimes)
  fetch(axios)
}
