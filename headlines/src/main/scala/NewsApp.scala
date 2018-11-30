import org.jsoup.Jsoup
import scala.collection.JavaConverters._

object NewsApp extends App {
  val bbc = Map("source" -> "BBC News", "url" -> "http://www.bbc.com/news", "selector" -> ".nw-c-most-read__items .gs-c-promo-heading__title", "base" -> "http://bbc.com/news")

  val nytimes = Map("source" -> "NYTimes", "url" -> "https://www.nytimes.com/section/us", "selector" -> "li h2 a", "base" -> "https://www.nytimes.com")

  val axios = Map("source" -> "Axios", "url" -> "https://www.axios.com", "selector" -> "h3", "base" -> "https://www.axios.com")

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

  def read = {
    print("Type the headline # you want to read, m for more, or 0 to exit): ")
    val headline = scala.io.StdIn.readLine()

    if (headline == "0") {
      keepGoing = false
      println("Goodbye")
    } else if (headline == "m") {
      try {
        val article = Jsoup.connect(links(currentHeadline)).get()
        println
        println(article.select("div p").text)
        println
      } catch {
        case e: Exception => print("Type the headline # you want to read, m for more, or 0 to exit): ")
      }
    } else {
      currentHeadline = headline
      val article = Jsoup.connect(links(headline.toString)).get()
      val gist = article.select("div p").text
      println
      println(gist.slice(0, 800) + "...")
      println
    }
  }

  fetch(bbc)
  fetch(nytimes)
  fetch(axios)

  var keepGoing = true
  while (keepGoing) {
    read
  }
}
