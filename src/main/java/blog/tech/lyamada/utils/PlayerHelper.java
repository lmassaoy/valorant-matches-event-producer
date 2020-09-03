package blog.tech.lyamada.utils;

import java.util.ArrayList;
import java.util.List;
// import java.util.Random;

import com.github.javafaker.Faker;

import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.domain.calculation.PercentageTier;

public class PlayerHelper {
    // private static Random random = new Random();

    public static Player generateRawPlayer(int puuid, int numberOfPlayers, List<PercentageTier> percentageTable) {
        Faker faker = new Faker();

        String characterId = faker.name().firstName() + faker.name().lastName();
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
}
