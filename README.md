# valorant-matches-event-producer

An application built in Java using Quarkus as its core, to handle the production of events to Apache Kafka topics with high performance, about fake Valorant matches for future use in data pipelines.

[![CoverValorant.png](https://cdn1.dotesports.com/wp-content/uploads/2020/05/04064300/valorant1-1-1.jpg)](https://cdn1.dotesports.com/wp-content/uploads/2020/05/04064300/valorant1-1-1.jpg)

We emulate the response body of Riot's API "[VAL-MATCH-V1](https://developer.riotgames.com/apis#val-match-v1)", trying to be as loyal as possible.

[![Screen-Shot-2020-09-04-at-00-12-50.png](https://i.postimg.cc/YqX8hBc0/Screen-Shot-2020-09-04-at-00-12-50.png)](https://postimg.cc/hfdV5wtR)

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

## architecture

[![Modern-Data-Lake-Event-Producer-1.png](https://i.postimg.cc/7Y4DXNSy/Modern-Data-Lake-Event-Producer-1.png)](https://postimg.cc/t7BL4Wrr)

| Component | Status |
| ------ | ------ |
| Producer Application | Under Construction |
| Kafka Broker | Done (Docker Compose Script) |
| Prometheus | TODO |
| Grafana | TODO |

*This application is a part of a complete **modern data lake | data warehouse project**, being extremely important because it's the source of the most part of the events we plan to handle in the data engineering and data science tasks. You can see the whole plan [here]()*

## reading events from Kafka

```
$ docker exec -i -t <containder_id> /bin/bash
$ [kafka@8fc151320d79 kafka]$ bin/kafka-console-consumer.sh --topic matches --from-beginning --bootstrap-server localhost:9092
```

## message sample

This is what you gonna see when you start the kafka-console-consumer.sh or consume the event with any application.

I'd like to suggest you to use some viewer tool like [JSON Editor Online](https://jsoneditoronline.org/) for a better experience :)

```
{ "eventId": 1552324990, "eventTimestamp": "2020-09-04T02:50:53.982785Z", "matchInfo": { "matchId": "80", "map": { "mapId": 1, "mapName": "Ascent", "bombSites": ["A","B"] }, "gameLengthMillis": 684120, "gameStartMillis": 0, "isCompleted": true, "gameMode": { "gameModeId": 2, "gameModeName": "Spike Rush" }, "isRanked": false, "seasonId": 2, "startTime": "2020-09-04T02:39:29.862723Z", "endTime": "2020-09-04T02:50:53.982727Z" }, "players": [{ "puuid": "102", "teamId": "Red", "partyId": "", "characterId": "GayWalter#2830", "agent": { "agentId": 9, "agentName": "Sage" }, "competitiveTier": 7 },{ "puuid": "60", "teamId": "Red", "partyId": "", "characterId": "TeddyAuer#8668", "agent": { "agentId": 6, "agentName": "Viper" }, "competitiveTier": 3 },{ "puuid": "27", "teamId": "Red", "partyId": "", "characterId": "MarcelinoSawayn#7352", "agent": { "agentId": 2, "agentName": "Raze" }, "competitiveTier": 2 },{ "puuid": "85", "teamId": "Red", "partyId": "", "characterId": "HongConroy#8079", "agent": { "agentId": 10, "agentName": "Reyna" }, "competitiveTier": 5 },{ "puuid": "152", "teamId": "Red", "partyId": "", "characterId": "HoseaBogisich#2580", "agent": { "agentId": 5, "agentName": "Killjoy" }, "competitiveTier": 11 },{ "puuid": "26", "teamId": "Blue", "partyId": "", "characterId": "HowardSteuber#9836", "agent": { "agentId": 5, "agentName": "Killjoy" }, "competitiveTier": 2 },{ "puuid": "2", "teamId": "Blue", "partyId": "", "characterId": "TheronLittel#4041", "agent": { "agentId": 8, "agentName": "Brimstone" }, "competitiveTier": 1 },{ "puuid": "173", "teamId": "Blue", "partyId": "", "characterId": "MargaritoHerman#8226", "agent": { "agentId": 11, "agentName": "Omen" }, "competitiveTier": 14 },{ "puuid": "95", "teamId": "Blue", "partyId": "", "characterId": "PameliaOrtiz#8772", "agent": { "agentId": 9, "agentName": "Sage" }, "competitiveTier": 6 },{ "puuid": "143", "teamId": "Blue", "partyId": "", "characterId": "SiuRomaguera#1378", "agent": { "agentId": 12, "agentName": "Jett" }, "competitiveTier": 10 }], "teams": [{ "teamId": "Blue", "won": false, "roundsPlayed": 6, "roundsWon": 2, "numPoints": 0 },{ "teamId": "Red", "won": true, "roundsPlayed": 6, "roundsWon": 4, "numPoints": 0 }], "roundResults": [{ "roundNum": 1, "roundResult": "Normal", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" },{ "roundNum": 2, "roundResult": "Normal", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Blue", "bombPlanter": "173", "bombDefuser": "", "plantRoundTime": 40, "defuseRoundTime": 0, "plantSite": "B", "roundResultCode": "6" },{ "roundNum": 3, "roundResult": "Flawless", "roundCeremony": "", "attackers": "Blue", "defenders": "Red", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "1" },{ "roundNum": 4, "roundResult": "Clutch", "roundCeremony": "Switching Sides", "attackers": "Red", "defenders": "Blue", "winningTeam": "Blue", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "2" },{ "roundNum": 5, "roundResult": "Normal", "roundCeremony": "", "attackers": "Red", "defenders": "Blue", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" },{ "roundNum": 6, "roundResult": "Normal", "roundCeremony": "Match Point", "attackers": "Red", "defenders": "Blue", "winningTeam": "Red", "bombPlanter": "", "bombDefuser": "", "plantRoundTime": 0, "defuseRoundTime": 0, "plantSite": "", "roundResultCode": "6" }] }
```