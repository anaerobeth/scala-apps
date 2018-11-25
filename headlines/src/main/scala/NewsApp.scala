import org.jsoup.Jsoup
import scala.collection.JavaConverters._
object NewsApp extends App {
  val source = "BBC News"
  val url = "http://www.bbc.com/news"
  val headlineSelector = ".nw-c-most-read__items .gs-c-promo-heading__title"
  val doc = Jsoup.connect(url).get()
  val newsHeadlines = doc.select(headlineSelector)
  println(f"The most read headlines on $source today:")
  newsHeadlines.asScala.map(_.text()).foreach(println)
}
