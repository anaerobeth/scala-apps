A headline scraper build in Scala

News sources: [BBC](https://www.bbc.com/news), [NYTimes US section](http://www.nytimes.com/section/us), [Axios](http://www.axios.com)

Example:
```
sbt:headlines> run
[info] Running NewsApp
------------ BBC News ------------
1 - Airline 'sorry' for mocking girl's name
2 - Trump sides with Russia against FBI
3 - Cancun hotel sued in 'tainted drink' death
4 - Trump ex-lawyer admits lying to Congress
5 - MeToo now unrecognisable, founder says
6 - US woman jailed in 'candy floss mix-up'
------------ NYTimes ------------
7 - A Mall Shooting, a Black Man’s Death, and a Debate Over Race and Gun Rights
8 - The Charlottesville Murder Trial Is Beginning. Here’s What to Know.
9 - Three Weeks After Fire, Official Search for Dead is Completed
10 - Everyone Who’s Been Charged as a Result of the Mueller Investigation
11 - California Democratic Leader, Facing Sexual Misconduct Allegations, Steps Down
12 - Mother Whose Child Died After ICE Detention Sues for $60 Million
------------ Axios ------------
13 - Giants of the deep, blue whales are changing their tune
14 - Big tech and startups are hungry for defense contracts
15 - Sea-level rise: The ostrich approach to climate adaptation
16 - Italian official: Nothing will come from Brussels budget standoff
17 - For Amazon, success breeds enemies
18 - Axios Future: Amazon's success and enemies — Amazon's labor unrest — Seismic mystery
Type the headline # you want to read, m for more, or 0 to exit): 9

Supported by By Thomas Fuller SAN FRANCISCO — Search teams that rushed to Northern California after fire leveled entire towns have completed their work, having checked every burned building in the fire zone for human remains, the authorities said Thursday. But the search of nearly 18,000 fire-ravaged structures — everything from homes, churches, stores and garden sheds — has not resolved the question of why nearly 200 people remain on the list of the missing. It is possible that the death toll, which stands at 88, will rise, if some remains were overlooked or are found later in forests or other areas that were not searched. Sheriff Kory L. Honea of Butte County, who led the search, said Thursday that he was “very optimistic” that people currently listed as unaccounted for would be found al...
Type the headline # you want to read, m for more, or 0 to exit): 0
Goodbye
[success] Total time: 95 s, completed Nov 29, 2018, 9:55:16 PM
```
