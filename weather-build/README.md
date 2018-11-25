A simple weather app built in Scala

Dependencies: gigahorse-okhttp, scalatest, play-json

Basic implementation: https://www.scala-sbt.org/1.x/docs/sbt-by-example.html.

Enhancements: Prompt user for a city and return its weather forecast

Example:
```
sbt:Weather App> run
[info] Running example.WeatherApp
Type the city and state here: Boston, MA
The weather in Boston, MA is mostly cloudy. It is currently 7 F.
[success] Total time: 5 s, completed Nov 25, 2018, 2:41:23 PM
```

Running the packaged app:
```
$ unzip -o -d /tmp weather-app-0.1.0-SNAPSHOT.zip
$ cd /tmp
$ ./weather-app-0.1.0-SNAPSHOT/bin/weather-app
Type the city and state here: Los Angeles, CA
The weather in Los Angeles, CA is clear.
```
