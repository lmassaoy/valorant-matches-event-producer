package blog.tech.lyamada;

import blog.tech.lyamada.domain.Agent;
import blog.tech.lyamada.domain.Match;

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

        private List<Match> matches = Collections.unmodifiableList(
            Arrays.asList(
            new Match(1, "Japan", "unrated"),
            new Match(2, "US", "unrated"),
            new Match(3, "Brazil", "unrated"),
            new Match(4, "Brazil", "competitive"),
            new Match(5, "Brazil", "spike-rush"),
            new Match(6, "US", "unrated"),
            new Match(7, "Korea", "spike-rush"),
            new Match(8, "Korea", "spike-rush"),
            new Match(9, "Mexico", "spike-rush")
            )
        );

        private List<Agent> agents = Collections.unmodifiableList(
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

        @Outgoing("matches_a")
        public Flowable<KafkaRecord<Integer, String>> matchesGenerationA() {
        List<KafkaRecord<Integer, String>> matchesAsJson = matches.stream()
                .map(s -> KafkaRecord.of(
                        s.getId(),
                        "{ \"id\" : " + s.getId() +
                        ", \"counter\" : \"" + s.getCountry() + "\" " +
                        ", \"type\" : \"" + s.getType() + "\" }"))
                .collect(Collectors.toList());

        return Flowable.fromIterable(matchesAsJson);
        };

        @Outgoing("matches_b")                             
        public Flowable<KafkaRecord<Integer, String>> killsGenerationB() {

        return Flowable.interval(50, TimeUnit.MILLISECONDS)    
                .onBackpressureDrop()
                .map(tick -> {
                        Match match = matches.get(random.nextInt(matches.size()));
                        String killer = agents.get(random.nextInt(agents.size())).getName();
                        String killed = agents.get(random.nextInt(agents.size())).getName();

                        return KafkaRecord.of(match.getId(), Instant.now() + ";" + match.getId() + ";" + killer + ";" + killed);
                });
        }

}
