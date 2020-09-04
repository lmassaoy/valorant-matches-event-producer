package blog.tech.lyamada.utils;

import java.util.Random;
import java.util.List;
// import java.util.ArrayList;

import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.calculation.PercentageTier;

public class CalculationHelper {
    public static Random r = new Random();

    public static Long calculateMatchTime(int roundsPlayed) {
        Double rangeMin = 1.845789116;
        Double rangeMax = 2.14532353;
        Double averageRoundTime = rangeMin + (rangeMax - rangeMin) * r.nextDouble(); // in minutes
        Double matchTimeMillis = roundsPlayed * averageRoundTime * 60 * 1000; // in milllis (float)
        
        return Math.round(matchTimeMillis); // in millls (long)
    }

    public static int calculateGameMode() {
        int randomGameModeProbability = r.nextInt(100);
        int gameModeProbability = 0;
        if (randomGameModeProbability <= 40) {
                gameModeProbability = 0;
        } 
        if (randomGameModeProbability > 46 & randomGameModeProbability <= 85) {
                gameModeProbability = 1;
        }
        if (randomGameModeProbability > 86) {
            gameModeProbability = 2;
    }
        return gameModeProbability;
    }

    public static Boolean calculateRanked(GameMode gameMode) {
        Boolean isRanked = false;
        if (gameMode.getGameModeId() == 1) {
            isRanked = r.nextBoolean();
        }
        return isRanked;
    }
    
    public static int calculateCompetitiveTier(int position,int sampleSize, List<PercentageTier> percentageTable) {
        Double percentageByPosition = Double.valueOf(String.valueOf(position)) / Double.valueOf(String.valueOf(sampleSize)) * 100;
        int tierCalculated = 1;
        
        for (PercentageTier tier : percentageTable) {        
            if (percentageByPosition > tier.getMinPercent() & percentageByPosition <= tier.getMaxPercent()) {
                tierCalculated = tier.getTier();
            }
        }

        return tierCalculated;
    }
    
}
