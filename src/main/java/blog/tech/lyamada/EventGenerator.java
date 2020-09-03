package blog.tech.lyamada;

import blog.tech.lyamada.domain.Event;
// import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Match;
import blog.tech.lyamada.domain.Team;
import blog.tech.lyamada.domain.calculation.PercentageTier;
import blog.tech.lyamada.domain.Map;
import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.utils.CalculationHelper;
import blog.tech.lyamada.utils.ConstantDimension;
import blog.tech.lyamada.utils.EventHelper;
import blog.tech.lyamada.utils.PlayerHelper;
import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
// import java.util.stream.Collectors;


@ApplicationScoped
public class EventGenerator {

        private int startEventId = 1;
        private Random random = new Random();

        // private List<Agent> agents = ConstantDimension.getAgents();
        private List<Map> maps = ConstantDimension.getMaps();
        private List<GameMode> gameModes = ConstantDimension.getGameModes();
        private List<PercentageTier> percentageTable = ConstantDimension.getCompetitiveTiers();
        private List<Player> rawPlayers = PlayerHelper.generateRawPlayersList(77,percentageTable);
        
        @Outgoing("matches")
        public Flowable<KafkaRecord<Integer, String>> generateMatches() {
                return Flowable.interval(10000, TimeUnit.MILLISECONDS)    
                        .onBackpressureDrop()
                        .map(tick -> {
                                for (Player player : rawPlayers) {
                                        System.out.println(player.toJson());
                                }

                                Map map = maps.get(random.nextInt(maps.size()));

                                GameMode gameMode = gameModes.get(CalculationHelper.calculateGameMode());

                                List<Team> teams = EventHelper.generateTeams(gameMode);

                                List<Player> players = new ArrayList<Player>();

                                Boolean isRanked = CalculationHelper.calculateRanked(gameMode);

                                Long matchDuration = CalculationHelper.calculateMatchTime(teams.get(0).getRoundsPlayed());

                                Match matchInfo = EventHelper.generateMatchInfo(startEventId,map,matchDuration,gameMode,isRanked);

                                Event event = new Event(matchInfo,teams,players);

                                startEventId++;

                                return KafkaRecord.of(event.hashCode(),event.toJson());
                        });
        }
        

}
