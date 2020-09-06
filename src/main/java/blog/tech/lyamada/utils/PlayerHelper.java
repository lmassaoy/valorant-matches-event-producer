package blog.tech.lyamada.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.domain.PercentageTier;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PlayerHelper {
    private static Random random = new Random();
    private static Faker faker = new Faker();

    public static Player generateRawPlayer(int puuid, int numberOfPlayers, List<PercentageTier> percentageTable) {
        String characterId = faker.name().firstName() + faker.name().lastName()
                                + "#" + String.format("%04d",random.nextInt(9999));
        int competitiveTier = CalculationHelper.calculateCompetitiveTier(puuid, numberOfPlayers, percentageTable);

        Player player = new Player(String.valueOf(puuid),"","",characterId,competitiveTier);
        return player;
    }

    public static List<Player> generateRawPlayersList(int numberOfPlayers, List<PercentageTier> percentageTable) {
        List<Player> rawPlayers = new ArrayList<Player>();
        int loopCounter = 1;

        while (loopCounter <= numberOfPlayers) {
            Player player = PlayerHelper.generateRawPlayer(loopCounter,numberOfPlayers,percentageTable);

            rawPlayers.add(player);
            loopCounter++;
        }

        return rawPlayers;
    }

    public static List<Player> generateMatchPlayers(List<Player> rawPlayers) {
        // TODO
        // Logic to put players of similar competitionTier in the teams

        List<Player> players = new ArrayList<Player>();
        List<Player> playersPool = new ArrayList<Player>();
        List<Player> redPlayers = new ArrayList<Player>();
        List<Player> bluePlayers = new ArrayList<Player>();

        List<Agent> agents = ConstantDimension.getAgents();
        List<Agent> redAgents = new ArrayList<Agent>();
        List<Agent> blueAgents = new ArrayList<Agent>();

        playersPool.addAll(rawPlayers);
        redAgents.addAll(agents);
        blueAgents.addAll(agents);

        for (int i = 0; i < 5; i++) {
            int randomIndexPlayer = random.nextInt(playersPool.size());
            int randomIndexAgent = random.nextInt(redAgents.size());
            Player randomPlayer = playersPool.get(randomIndexPlayer);
            Agent randomAgent = redAgents.get(randomIndexAgent);

            randomPlayer.setTeamId("Red");
            randomPlayer.setAgent(randomAgent);
            redPlayers.add(randomPlayer);

            playersPool.remove(randomIndexPlayer);
            redAgents.remove(randomIndexAgent);
        }
        for (int i = 0; i < 5; i++) {
            int randomIndexPlayer = random.nextInt(playersPool.size());
            int randomIndexAgent = random.nextInt(blueAgents.size());
            Player randomPlayer = playersPool.get(randomIndexPlayer);
            Agent randomAgent = blueAgents.get(randomIndexAgent);

            randomPlayer.setTeamId("Blue");
            randomPlayer.setAgent(randomAgent);
            bluePlayers.add(randomPlayer);
                
            playersPool.remove(randomIndexPlayer);
            blueAgents.remove(randomIndexAgent);
        }

        players.addAll(redPlayers);
        players.addAll(bluePlayers);

        return players;
    }

}
