A simple weather app built in Scala

Dependencies: gigahorse-okhttp, scalatest, play-json
Basic implementation: https://www.scala-sbt.org/1.x/docs/sbt-by-example.html.
Enhancements: Prompt user for a city and return its weather forecast

Example:
```
sbt:Weather App> run
[info] Running example.WeatherApp
Type the city and state here: Tampa, Florida
The weather in Tampa, Florida is cloudy.
[success] Total time: 14 s, completed Nov 24, 2018, 10:50:14 PM
sbt:Weather App> run
[info] Running example.WeatherApp
Type the city and state here: Boston, MA
The weather in Boston, MA is cloudy.
[success] Total time: 8 s, completed Nov 24, 2018, 10:52:40 PM
```
