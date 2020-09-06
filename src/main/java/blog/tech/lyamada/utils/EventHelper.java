package blog.tech.lyamada.utils;

import java.time.Instant;
import java.util.*;

import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Team;
import blog.tech.lyamada.domain.Map;
import blog.tech.lyamada.domain.Match;
import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.domain.RoundResult;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class EventHelper {
        private static Random random = new Random();

        public static List<Team> generateTeams(GameMode gameMode) {
                
                List<Team> teams = new ArrayList<Team>();
                
                if (gameMode.getGameModeId() != 3) {
                        int matchResult = random.nextInt(2);
                        int roundsPlayed = 0;
                        Boolean blueResult = null;
                        Boolean redResult = null;
                        int blueRoundsWon = 0;
                        int redRoundsWon = 0;

                        if (matchResult == 1) {
                                blueResult = true;
                                redResult = false;
                                if (gameMode.getGameModeId() == 1) {
                                        blueRoundsWon = 13;
                                        redRoundsWon = random.nextInt(12);
                                        roundsPlayed = blueRoundsWon + redRoundsWon;
                                } else {
                                        blueRoundsWon = 4;
                                        redRoundsWon = random.nextInt(3);
                                        roundsPlayed = blueRoundsWon + redRoundsWon;
                                }

                        } else {
                                blueResult = false;
                                redResult = true;
                                if (gameMode.getGameModeId() == 1) {
                                        redRoundsWon = 13;
                                        blueRoundsWon = random.nextInt(12);
                                        roundsPlayed = blueRoundsWon + redRoundsWon;
                                } else {
                                        redRoundsWon = 4;
                                        blueRoundsWon = random.nextInt(3);
                                        roundsPlayed = blueRoundsWon + redRoundsWon;
                                }
                        }

                        Team blueTeam = new Team("Blue",blueResult,roundsPlayed,blueRoundsWon,0);
                        Team redTeam = new Team("Red",redResult,roundsPlayed,redRoundsWon,0);

                        teams.add(blueTeam);
                        teams.add(redTeam);
                } else {
                        // TODO
                        // Deathmatch still needs improvements about the logic as the teams are the players themselves
                        int loopCounter = 1;
                        int wonPlayer = random.nextInt(10);
                        Boolean won = null;
                        while (loopCounter <= 10) {
                                if (loopCounter == wonPlayer) {
                                        won = true;
                                } else {
                                        won = false;
                                }
                                Team deathMatchPlayer = new Team(String.valueOf(random.nextInt(1000000)),won,3,1,0);
                                teams.add(deathMatchPlayer);

                                loopCounter++;
                        }
                }

                return teams;
        }

        public static Match generateMatchInfo(int startEventId, Map map, Long matchDuration, GameMode gameMode, Boolean isRanked) {
                return  new Match(
                        String.valueOf(startEventId),
                        map,
                        matchDuration,
                        0L,
                        true,
                        gameMode,
                        isRanked,
                        2,
                        Instant.now().minusMillis(matchDuration),
                        Instant.now()
                );
        }

        public static List<RoundResult> generateRoundResults(GameMode gameMode, List<Team> teams, List<Player> players, Match matchInfo) {
                List<RoundResult> roundResults = new ArrayList<RoundResult>();
                if (gameMode.getGameModeId() == 3) {
                        // TODO
                        // Deathmatch still needs improvements to generate correctly. So far we're using a static RoundResult
                        RoundResult roundResult = new RoundResult(1,"CLUTCH","Match Point","Red","Blue","Blue","1234","5678",100000,10050,"A","1");
                        roundResults.add(roundResult);
                } else {
                        roundResults.addAll(RoundResultHelper.generateRoundResults(teams, players, matchInfo));
                }

                return roundResults;
        }

}
