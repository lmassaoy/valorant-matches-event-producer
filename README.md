# valorant-matches-event-producer

An application built in Java using Quarkus as its core, to handle the production of events to Apache Kafka topics with high performance, about fake Valorant matches for future use in data pipelines.

[![CoverValorant](https://www.esquireme.com/public/styles/full_img/public/images/2020/06/02/valorant-live.jpg)](https://www.esquireme.com/public/styles/full_img/public/images/2020/06/02/valorant-live.jpg)

The project emulates the response body of Riot's API "[VAL-MATCH-V1](https://developer.riotgames.com/apis#val-match-v1)", trying to be as loyal as possible.

This API's responses contain data of a match such as:
- Match Info
- Players
- Teams
- Round Results

Comparing to the Riot's API, we're still missing some Dtos because of their complexity (the logic we need to emulate to represent the closest of a **real match**) d(T - T)b

These data are:
- Player Stats
    - Common attributes
    - Abilities Cast
- Player Round Stats
    - Common attributes
    - Kills
    - Damage
    - Economy
    - Abilities

There's also the intention of including more elements such as weapons, skins, sprays, etc. But first, we need to attempt the attribute above.

So far, we're already good-to-go to generate massive streaming of events with a lot of information. We ensure you we spent a real good time creating the algorithms to replicate a real Valorant match, respecting logic and probabilities. Although, we believe we'll still need to refine some logic to grant this application a reliable capability to emulate real matches at some point of the future.

![JettRunning.gif](https://66.media.tumblr.com/05722bb562580a4be1be732c6b2a94a8/3919c42ae463b51c-16/s500x750/6895639fd68c7f69d861fc3e189851b9f1adf93f.gif)


# Why Valorant?

## But first, WHAT is Valorant?

In Riot's words:

*"[VALORANT](https://playvalorant.com/en-us/) is your global competitive stage. It’s a 5v5 tac-shooter matchup to plant or defuse the Spike in a one-life-per-round, first to 13 series. More than guns and bullets, you’ll choose an Agent armed with adaptive, swift, and lethal abilities that create opportunities to let your gunplay shine."*

The e-Sport world already sees Valorant as a powerful game bringing players from everywhere to join embrace the FPS (First Person Shooter) game style.

The game is new (released in July, 2nd 2020), but already offers a ton of things to digest. At the current moment (September 2020) the game counts with 12 [agents](https://playvalorant.com/en-us/agents/) in 4 roles (DUELIST, SENTINEL, CONTROLLER, and INITIATOR), each agent ready to use 4 different abilities (1 of them is an **ultimate**). Also has 18 [weapons](https://playvalorant.com/en-us/arsenal/) (counting with the knife),  4 competitive [maps](https://playvalorant.com/en-us/maps/), 3 game modes (Standard, Spike Rush (quick game) and DeathMatch (quicker game)), and an amazing practice mode to sharpen your aim.

It's a very interesting game to play, even if you aren't experienced with FPS games. Do I have your attention? So check this amazing [videoclip](https://vimeo.com/423747596) of the game (made by a [very skilled Brazilian studio](https://estudiohisteria.com/) named as "Histeria"). 100% happiness granted after watching it. Believe in me.

If you have a Windows PC at your disposal, bring it on! **DEFY THE LIMITS**.

[![jett-vs-phoenix-2.gif](https://i.postimg.cc/x1hKtSLq/jett-vs-phoenix-2.gif)](https://postimg.cc/9DPRQK8j)

## OK, now the reason:

Riot offers us some [APIs](https://developer.riotgames.com/apis) related to its games.

[![Screen-Shot-2020-09-04-at-00-12-50.png](https://i.postimg.cc/YqX8hBc0/Screen-Shot-2020-09-04-at-00-12-50.png)](https://postimg.cc/hfdV5wtR)

But because of Valorant is so recent, its API has limited access, needing to be allowed by the game producer to consume the service.

As you might be thinking, we **didn't receive** a developer key to use the API :(

Still, I'm deeply in love with the game (playing almost every night for a couple of hours) and I want to build some analytics using Valorant as the theme.

While we still can't lay our hands over the official API, why not build an application to generate a lot of events related to Valoran't matches by ourselves?

I believe this may help a lot of another players'n'developers to evolve their projects using something they really enjoy :)

# Architecture

[![Modern-Data-Lake-Event-Producer-1.png](https://i.postimg.cc/7Y4DXNSy/Modern-Data-Lake-Event-Producer-1.png)](https://postimg.cc/t7BL4Wrr)

| Component | Status |
| ------ | ------ |
| Producer Application | QA - Tests being made |
| Kafka Broker | Done (Docker Compose Script) |
| Prometheus | TODO |
| Grafana | TODO |

*This application is a part of a complete **modern data lake | data warehouse project**, being extremely important because it's the source of the most part of the events we plan to handle in the data engineering and data science tasks. You can see the whole plan [here]()*

# Reading events from Kafka

```
$ docker exec -i -t <containder_id> /bin/bash
$ [kafka@8fc151320d79 kafka]$ bin/kafka-console-consumer.sh --topic matches --from-beginning --bootstrap-server localhost:9092
```

# Message sample

This is what you gonna see when you start the kafka-console-consumer.sh or consume the event with any application.

I'd like to suggest you to use some viewer tool like [JSON Editor Online](https://jsoneditoronline.org/) for a better experience :)

```
{ "eventId": 1552324990, "eventTimestamp": "2020-09-04T02:50:53.982785Z", "matchInfo": { "matchId": "80", "map": { "mapId": 1, "mapName": "Ascent", "bombSites": ["A","B"] }, "gameLengthMillis": 684120, "gameStartMillis": 0, "isCompleted": true, "gameMode": { "gameModeId": 2, "gameModeName": "Spike Rush" }, "isRanked": false, "seasonId": 2, "startTime": "2020-09-04T02:39:29.862723Z", "endTime": "2020-09-04T02:50:53.982727Z" }, "players": [{ "puuid": "102", "teamId": "Red", "partyId": "", "characterId": "GayWalter#2830", "agent": { "agentId": 9, "agentName": "Sage" }, "competitiveTier": 7 },{ "puuid": "60", "teamId": "Red", "partyId": "", "characterId": "TeddyAuer#8668", "agent": { "agentId": 6, "agentName": "Viper" }, "competitiveTier": 3 },{ "puuid": "27", "teamId": "Red", "partyId": "", "characterId": "MarcelinoSawayn#7352", "agent": { "agentId": 2, "agentName": "Raze" }, "competitiveTier": 2 },{ "puuid": "85", "teamId": "Red", "partyId": "", "characterId": "HongConroy#8079", "agent": { "agentId": 10, "agentName": "Reyna" }, "competitiveTier": 5 },{ "puuid": "152", "teamId": "Red", "partyId": "", "characterId": "HoseaBogisich#2580", "agent": { "agentId": 5, "agentName": "Killjoy" }, "competitiveTier": 11 },{ "puuid": "26", "teamId": "Blue", "partyId": "", "characterId": "HowardSteuber#9836", "agent": { "agentId": 5, "agentName": "Killjoy" }, "competitiveTier": 2 },{ "puuid": "2", "teamId": "Blue", "partyId": "", "characterId": "TheronLittel#4041", "agent": { "agentId": 8, "agentName": "Brimstone" }, "competitiveTier": 1 },{ "puuid": "173", "teamId": "Blue", "partyId": "", "characterId": "MargaritoHerman#8226", "agent": { "agentId": 11, "agentName": "Omen" }, "competitiveTier": 14 },{ "puuid": "95", "teamId": "Blue", "partyId": "", "characterId": "PameliaOrtiz#8772", "agent": { "agentId": 9, "agentName": "Sage" }, "competitiveTier": 6 },{ "puuid": "143", "teamId": "Blue", "partyId": "", "characterId": "SiuRomaguera#1378", "agent": { "agentId": 12, "agentName": "Jett" }, "competitiveTier": 10 }], "teams": [{ "teamId": "Blue", "won": false, "roundsPlayed": 6, "roundsWon": 2, "numPoints": 0 },{ "teamId": "Red", "won": true, "roundsPlayed": 6, "roundsWon": 4, "numPoints": 0 }], "roundResults": [{ "roundNum": 1, "roundResult": "Normal", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" },{ "roundNum": 2, "roundResult": "Normal", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Blue", "bombPlanter": "173", "bombDefuser": "", "plantRoundTime": 40, "defuseRoundTime": 0, "plantSite": "B", "roundResultCode": "6" },{ "roundNum": 3, "roundResult": "Flawless", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "1" },{ "roundNum": 4, "roundResult": "Clutch", "roundCeremony": "Switching Sides", "attackers": "Red", "defenders": "Blue", "winningTeam": "Blue", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "2" },{ "roundNum": 5, "roundResult": "Normal", "roundCeremony": "", "attackers": "Red", "defenders": "Blue", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" },{ "roundNum": 6, "roundResult": "Normal", "roundCeremony": "Match Point", "attackers": "Red", "defenders": "Blue", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" }] }
```