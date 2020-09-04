package blog.tech.lyamada;

import blog.tech.lyamada.domain.Event;
import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Match;
import blog.tech.lyamada.domain.Team;
import blog.tech.lyamada.domain.Map;
import blog.tech.lyamada.domain.Player;
import blog.tech.lyamada.domain.RoundResult;
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


@ApplicationScoped
public class EventGenerator {

        private int startEventId = 1;
        private Random random = new Random();
        private List<Map> maps = ConstantDimension.getMaps();
        private List<GameMode> gameModes = ConstantDimension.getGameModes();
        private List<Player> rawPlayers = PlayerHelper.generateRawPlayersList(200,ConstantDimension.getCompetitiveTiers());
        
        @Outgoing("matches")
        public Flowable<KafkaRecord<Integer, String>> generateMatches() {
                return Flowable.interval(100, TimeUnit.MILLISECONDS)    
                        .onBackpressureDrop()
                        .map(tick -> {
                                Map map = maps.get(random.nextInt(maps.size()));

                                GameMode gameMode = gameModes.get(CalculationHelper.calculateGameMode());

                                List<Team> teams = EventHelper.generateTeams(gameMode);

                                List<Player> players = PlayerHelper.generateMatchPlayers(rawPlayers);

                                Boolean isRanked = CalculationHelper.calculateRanked(gameMode);

                                Long matchDuration = CalculationHelper.calculateMatchTime(teams.get(0).getRoundsPlayed());

                                Match matchInfo = EventHelper.generateMatchInfo(startEventId,map,matchDuration,gameMode,isRanked);

                                List<RoundResult> roundResults = EventHelper.generateRoundResults(gameMode, teams, players, matchInfo);

                                Event event = new Event(matchInfo,teams,players,roundResults);

                                startEventId++;

                                return KafkaRecord.of(event.hashCode(),event.toJson());
                        });
        }
        

}
