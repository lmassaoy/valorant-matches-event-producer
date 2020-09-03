package blog.tech.lyamada.utils;

import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Map;
import blog.tech.lyamada.domain.calculation.PercentageTier;

import java.util.*;

public class ConstantDimension {
    
    public static List<Agent> getAgents(){
        return Collections.unmodifiableList(
            Arrays.asList(
                new Agent(1, "Breach"),
                new Agent(2, "Raze"),
                new Agent(3, "Cypher"),
                new Agent(4, "Sova"),
                new Agent(5, "Killjoy"),
                new Agent(6, "Viper"),
                new Agent(7, "Phoenix"),
                new Agent(8, "Brimstone"),
                new Agent(9, "Sage"),
                new Agent(10, "Reyna"),
                new Agent(11, "Omen"),
                new Agent(12, "Jett")
            )
        );
    }

	public static List<Map> getMaps() {
        return Collections.unmodifiableList(
            Arrays.asList(
                new Map(1, "Ascent"),
                new Map(2, "Split"),
                new Map(3, "Bind"),
                new Map(4, "Haven")
            )
        );
    }

	public static List<GameMode> getGameModes() {
        return Collections.unmodifiableList(
            Arrays.asList(
                new GameMode(1, "Standard"),
                new GameMode(2, "Spike Rush"),
                new GameMode(3, "Deathmatch")
            )
        );
    }

    public static List<PercentageTier> getCompetitiveTiers() {
        return Collections.unmodifiableList(
            Arrays.asList(
                new PercentageTier(0.0,11.0,1,"Iron_3"),
                new PercentageTier(11.0,21.0,2,"Iron_2"),
                new PercentageTier(21.0,30.0,3,"Iron_1"),
                new PercentageTier(30.0,37.0,4,"Bronze_3"),
                new PercentageTier(37.0,44.0,5,"Bronze_2"),
                new PercentageTier(44.0,50.0,6,"Bronze_1"),
                new PercentageTier(50.0,56.0,7,"Silver_3"),
                new PercentageTier(56.0,62.0,8,"Silver_2"),
                new PercentageTier(62.0,67.0,9,"Silver_1"),
                new PercentageTier(67.0,72.0,10,"Gold_3"),
                new PercentageTier(72.0,77.0,11,"Gold_2"),
                new PercentageTier(77.0,81.0,12,"Gold_1"),
                new PercentageTier(81.0,84.0,13,"Platinum_3"),
                new PercentageTier(84.0,87.0,14,"Platinum_2"),
                new PercentageTier(87.0,90.0,15,"Platinum_1"),
                new PercentageTier(90.0,92.0,16,"Diamond_3"),
                new PercentageTier(92.0,94.0,17,"Diamond_2"),
                new PercentageTier(94.0,96.0,18,"Diamond_1"),
                new PercentageTier(96.0,97.0,19,"Immortal_3"),
                new PercentageTier(97.0,98.0,20,"Immortal_2"),
                new PercentageTier(98.0,99.0,21,"Immortal_1"),
                new PercentageTier(99.0,100.0,22,"Valorant")
            )
        );
    }

}
