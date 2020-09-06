package blog.tech.lyamada.utils;

import java.util.Random;
import java.util.List;

import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.RoundResultType;
import blog.tech.lyamada.domain.PercentageTier;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class CalculationHelper {
    public static Random random = new Random();

    public static Long calculateMatchTime(int roundsPlayed) {
        Double rangeMin = 1.845789116;
        Double rangeMax = 2.14532353;
        Double averageRoundTime = rangeMin + (rangeMax - rangeMin) * random.nextDouble(); // in minutes
        Double matchTimeMillis = roundsPlayed * averageRoundTime * 60 * 1000; // in milllis (float)
        
        return Math.round(matchTimeMillis); // in millls (long)
    }

    public static int calculateGameMode() {
        int randomGameModeProbability = random.nextInt(100);
        int gameModeProbability = 0;
        if (randomGameModeProbability <= 40) {
                gameModeProbability = 0;
        } 
        if (randomGameModeProbability > 46 & randomGameModeProbability <= 90) {
                gameModeProbability = 1;
        }
        if (randomGameModeProbability > 90) {
            gameModeProbability = 2;
    }
        return gameModeProbability;
    }

    public static Boolean calculateRanked(GameMode gameMode) {
        Boolean isRanked = false;
        if (gameMode.getGameModeId() == 1) {
            isRanked = random.nextBoolean();
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

    public static int calculateRoundResultType(int gameMode, List<RoundResultType> roundResultTypes) {
        Double randomResultTypePercentage = 0.0 + (100.00 - 0.00) * random.nextDouble();
        int resultTypeIndex = 1;
        
        // already bypass Thrifty because 'Normal' mode range includes 'Thrifty' range
        for (int index=0; index < roundResultTypes.size(); index++) {   
            Double typeMin = roundResultTypes.get(index).getMinPercent();
            Double typeMax = roundResultTypes.get(index).getMaxPercent();

            if (randomResultTypePercentage > typeMin & randomResultTypePercentage <= typeMax) {
                resultTypeIndex = index;
            }
        }

        if (gameMode == 1 & resultTypeIndex==6) {
            randomResultTypePercentage = 0.0 + (100.00 - 0.00) * random.nextDouble();
            Double thriftyMin = roundResultTypes.get(2).getMinPercent();
            Double thriftyMax = roundResultTypes.get(2).getMaxPercent();

            if (randomResultTypePercentage > thriftyMin & randomResultTypePercentage <= thriftyMax) {
                resultTypeIndex = 2;
            }
        }

        return resultTypeIndex;
    }
    
}
