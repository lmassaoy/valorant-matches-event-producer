package blog.tech.lyamada.utils;

import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Map;
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
                new GameMode(2, "Deathmatch"),
                new GameMode(3, "Spike Rush")
            )
        );
    }
}
