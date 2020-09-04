package blog.tech.lyamada.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import blog.tech.lyamada.domain.Match;
import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.domain.RoundResult;
import blog.tech.lyamada.domain.RoundResultType;
import blog.tech.lyamada.domain.Team;

public class RoundResultHelper {
    private static Random random = new Random();

    public static RoundResultType generateRoundResultType (int gameMode, List<RoundResultType> roundResultTypes) {
        return roundResultTypes.get(CalculationHelper.calculateRoundResultType(gameMode,roundResultTypes));
    }

    public static RoundResult generateSingleRoundResult(int roundNum,
                                                    String roundCerimony,
                                                    String winningTeam,
                                                    String attackers,
                                                    String defenders,
                                                    RoundResultType roundResultType,
                                                    List<Team> teams,
                                                    List<Player> players,
                                                    Match matchInfo) {
        RoundResult roundResult = new RoundResult();
        String bombPlanter = "";
        String bombDefuser = "";
        Double bombPlantedChance = 50.0;
        Double sucessPlanting = 0.0 + (100.00 - 0.00) * random.nextDouble();
        String plantSite = "";
        List<String> mapPlantSites = matchInfo.getMap().getBombSites();

        List<Player> attackerTeam = new ArrayList<Player>();
        List<Player> defenderTeam = new ArrayList<Player>();

        for (Player player : players) {
            if (player.getTeamId() == attackers) {
                attackerTeam.add(player);
            } else {
                defenderTeam.add(player);
            }
        }

        if (roundResultType.getRoundResultCode() == 2 /* Clutch */ ||
            roundResultType.getRoundResultCode() == 3 /* Thrifty */ ||
            roundResultType.getRoundResultCode() == 6 /* Normal */ )  {
            if (sucessPlanting >= bombPlantedChance) {
                bombPlanter = attackerTeam.get(random.nextInt(5)).getPuuid();
                plantSite =  mapPlantSites.get(random.nextInt(mapPlantSites.size()));
                if (winningTeam == defenders) {
                    bombDefuser = defenderTeam.get(random.nextInt(5)).getPuuid();
                }
            }
        }
        if (roundResultType.getRoundResultCode() == 1) /* Flawless */ {
            if (winningTeam == attackers) {
                if (sucessPlanting >= bombPlantedChance) {
                    bombPlanter = attackerTeam.get(random.nextInt(5)).getPuuid();
                    plantSite =  mapPlantSites.get(random.nextInt(mapPlantSites.size()));
                }
            } else {
                if (sucessPlanting >= bombPlantedChance+40.0) /* 10% chance */ {
                    bombPlanter = attackerTeam.get(random.nextInt(5)).getPuuid();
                    plantSite =  mapPlantSites.get(random.nextInt(mapPlantSites.size()));
                    bombDefuser = defenderTeam.get(random.nextInt(5)).getPuuid();
                }
            }
        }
        if (roundResultType.getRoundResultCode() == 4 /* Ace */ ||
            roundResultType.getRoundResultCode() == 5) /* Team Ace */ {
            if (winningTeam == attackers) {
                if (sucessPlanting >= bombPlantedChance) {
                    bombPlanter = attackerTeam.get(random.nextInt(5)).getPuuid();
                    plantSite =  mapPlantSites.get(random.nextInt(mapPlantSites.size()));
                }
            } else {
                if (sucessPlanting >= bombPlantedChance+48.0) /* 2% chance */ {
                    bombPlanter = attackerTeam.get(random.nextInt(5)).getPuuid();
                    plantSite =  mapPlantSites.get(random.nextInt(mapPlantSites.size()));
                    bombDefuser = defenderTeam.get(random.nextInt(5)).getPuuid();
                }
            }
        }

        int plantRoundTime = 0;
        int defuseRoundTime = 0;

        if (bombPlanter != "") {
            plantRoundTime = random.nextInt(59)+40;
            if (bombDefuser != "") {
                int timeUntilDefuse = random.nextInt(40);
                if (timeUntilDefuse < 9) {
                    timeUntilDefuse = 9;
                }
                defuseRoundTime = timeUntilDefuse+plantRoundTime;
            }
        }

        roundResult.setRoundNum(roundNum);
        roundResult.setRoundResultCode(String.valueOf(roundResultType.getRoundResultCode()));
        roundResult.setRoundResult(roundResultType.getRoundResult());
        roundResult.setRoundCeremony(roundCerimony);
        roundResult.setAttackers(attackers);
        roundResult.setDefenders(defenders);
        roundResult.setWinningTeam(winningTeam);
        roundResult.setBombPlanter(bombPlanter);
        roundResult.setPlantRoundTime(plantRoundTime); // ignoring for now
        roundResult.setBombDefuser(bombDefuser);
        roundResult.setDefuseRoundTime(defuseRoundTime); // ignoring for now
        roundResult.setPlantSite(plantSite);

        return roundResult;
    }

    public static List<RoundResult> generateRoundResults (List<Team> teams, List<Player> players, Match matchInfo) {
        List<RoundResult> roundResults = new ArrayList<RoundResult>();
        List<RoundResultType> roundResultTypes = ConstantDimension.getRoundResultTypes();
        int gameMode = matchInfo.getGameMode().getGameModeId();

        int roundsWonByRed = 0;
        int roundsWonByBlue = 0;
        int roundsWonByRedSoFar = 0;
        int roundsWonByBlueSoFar = 0;
        int matchPoint = 0;
        String winnerTeam = "";

        if (teams.size() == 2) {
            for (Team team : teams) {
                if (team.getTeamId() == "Red") {
                    roundsWonByRed = team.getRoundsWon();
                } else {
                    roundsWonByBlue = team.getRoundsWon();
                }

                if (team.isWon() == true) {
                    winnerTeam = team.getTeamId();
                }
            }
        }
        
        int totalRoundsPlayed = roundsWonByRed + roundsWonByBlue;

        int roundsPlayedToSwitchSides = 0;

        if (gameMode == 1) {
            roundsPlayedToSwitchSides = 7;
            matchPoint = 12;
        }
        if (gameMode == 2) {
            roundsPlayedToSwitchSides = 4;
            matchPoint = 3;
        } else {

        }

        String attackers = "";
        String defenders = "";

        int atkIndex = random.nextInt(2);

        if (atkIndex == 1) {
            attackers = "Red";
            defenders = "Blue";
        } else {
            attackers = "Blue";
            defenders = "Red";
        }


        for (int counter = 1; counter <= totalRoundsPlayed; counter++) {
            String roundCerimony = "";

            // Switching Sides
            if (counter == roundsPlayedToSwitchSides) {
                roundCerimony = "Switching Sides";
                if (atkIndex == 1) {
                    attackers = "Blue";
                    defenders = "Red";
                } else {
                    attackers = "Red";
                    defenders = "Blue";
                }
            }

            // Match Point & Sudden Death
            if (gameMode == 1) {
                if (roundsWonByRedSoFar == matchPoint || roundsWonByBlueSoFar == matchPoint) {
                    roundCerimony = "Match Point";
                }
                if (roundsWonByRedSoFar == matchPoint & roundsWonByBlueSoFar == matchPoint) {
                    roundCerimony = "Sudden Death";
                }
            }
            if (gameMode == 2) {
                if (roundsWonByRedSoFar == matchPoint || roundsWonByBlueSoFar == matchPoint) {
                    if (roundCerimony == "Switching Sides") {
                        roundCerimony = "Switching Sides + Match Point";
                    } else {
                        roundCerimony = "Match Point";
                    }
                }
                if (roundsWonByRedSoFar == matchPoint & roundsWonByBlueSoFar == matchPoint) {
                    roundCerimony = "Sudden Death";
                }
            } else {
    
            }

            int randomWinner = random.nextInt(2);
            String winningTeam = "";

            // Making sure the winner team won the last round (new logic) + Randomizing round winner
            if (winnerTeam == "Red" & roundsWonByRedSoFar == matchPoint-1 || winnerTeam == "Blue" & roundsWonByBlueSoFar == matchPoint-1) {
                if (winnerTeam == "Red" & roundsWonByRedSoFar == matchPoint-1) {
                    if (roundsWonByBlue > 0) {
                        roundsWonByBlue--;
                        roundsWonByBlueSoFar++;
                        winningTeam = "Blue";
                    } else {
                        roundsWonByRed--;
                        roundsWonByRedSoFar++;
                        winningTeam = "Red";
                    }
                } else {
                    if (roundsWonByRed > 0) {
                        roundsWonByRed--;
                        roundsWonByRedSoFar++;
                        winningTeam = "Red";
                    } else {
                        roundsWonByBlue--;
                        roundsWonByBlueSoFar++;
                        winningTeam = "Blue";
                    }
                }
            } else {
                if (randomWinner == 1) /* RED */ {
                    if (roundsWonByRed > 0) {
                        roundsWonByRed--;
                        roundsWonByRedSoFar++;
                        winningTeam = "Red";
                    } else {
                        roundsWonByBlue--;
                        roundsWonByBlueSoFar++;
                        winningTeam = "Blue";
                    }
                } else /* BLUE */ {
                    if (roundsWonByBlue > 0) {
                        roundsWonByBlue--;
                        roundsWonByBlueSoFar++;
                        winningTeam = "Blue";
                    } else {
                        roundsWonByRed--;
                        roundsWonByRedSoFar++;
                        winningTeam = "Red";
                    }
                }
            }


            RoundResult roundResult = generateSingleRoundResult(
                                        counter,
                                        roundCerimony,
                                        winningTeam,
                                        attackers,
                                        defenders,
                                        generateRoundResultType(gameMode,roundResultTypes),
                                        teams,
                                        players,
                                        matchInfo
                                        );
            roundResults.add(roundResult);
        }


        return roundResults;
    }
}
