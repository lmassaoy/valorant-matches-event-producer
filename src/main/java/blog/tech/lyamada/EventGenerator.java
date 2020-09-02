package blog.tech.lyamada;

import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.GameMode;
import blog.tech.lyamada.domain.Match;
import blog.tech.lyamada.domain.Map;
import blog.tech.lyamada.utils.ConstantDimension;
import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.concurrent.TimeUnit;
import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;


@ApplicationScoped
public class EventGenerator {


        private Random random = new Random();

        private List<Agent> agents = ConstantDimension.getAgents();
        private List<Map> maps = ConstantDimension.getMaps();
        private List<GameMode> gameModes = ConstantDimension.getGameModes();

        @Outgoing("matches")
        public Flowable<KafkaRecord<Integer, String>> generateMatches() {
                return Flowable.interval(1000, TimeUnit.MILLISECONDS)    
                        .onBackpressureDrop()
                        .map(tick -> {
                                Map map = maps.get(random.nextInt(maps.size()));
                                GameMode gameMode = gameModes.get(random.nextInt(gameModes.size()));
                                boolean isRanked = false;
                                if (gameMode.getGameModeId() == 1) {
                                        isRanked = random.nextBoolean();
                                }

                                Match match = new Match(
                                        String.valueOf(random.nextInt(1000000)),
                                        map,
                                        Long.valueOf(String.valueOf(random.nextInt(1000000))),
                                        Long.valueOf(String.valueOf(random.nextInt(1000000))),
                                        true,
                                        gameMode,
                                        isRanked,
                                        2,
                                        Instant.now()
                                );

                                return KafkaRecord.of(match.hashCode(),match.toString());
                        });
        }
        

        // @Outgoing("matches_a")
        // public Flowable<KafkaRecord<Integer, String>> matchesGenerationA() {
        // List<KafkaRecord<Integer, String>> matchesAsJson = matches.stream()
        //         .map(s -> KafkaRecord.of(
        //                 s.getId(),
        //                 "{ \"id\" : " + s.getId() +
        //                 ", \"counter\" : \"" + s.getCountry() + "\" " +
        //                 ", \"type\" : \"" + s.getType() + "\" }"))
        //         .collect(Collectors.toList());

        // return Flowable.fromIterable(matchesAsJson);
        // };

        // @Outgoing("matches_b")                             
        // public Flowable<KafkaRecord<Integer, String>> killsGenerationB() {

        // return Flowable.interval(50, TimeUnit.MILLISECONDS)    
        //         .onBackpressureDrop()
        //         .map(tick -> {
        //                 Match match = matches.get(random.nextInt(matches.size()));
        //                 String killer = agents.get(random.nextInt(agents.size())).getName();
        //                 String killed = agents.get(random.nextInt(agents.size())).getName();

        //                 return KafkaRecord.of(match.getId(), Instant.now() + ";" + match.getId() + ";" + killer + ";" + killed);
        //         });
        // }

}
