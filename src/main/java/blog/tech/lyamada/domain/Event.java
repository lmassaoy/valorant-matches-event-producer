package blog.tech.lyamada.domain;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Event {
    private Match matchInfo;
    private List<Team> teams;
    private List<Player> players;


    public Event() {
    }

    public Event(Match matchInfo, List<Team> teams, List<Player> players) {
        this.matchInfo = matchInfo;
        this.teams = teams;
        this.players = players;
    }

    public Match getMatchInfo() {
        return this.matchInfo;
    }

    public void setMatchInfo(Match matchInfo) {
        this.matchInfo = matchInfo;
    }

    public List<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Event matchInfo(Match matchInfo) {
        this.matchInfo = matchInfo;
        return this;
    }

    public Event teams(List<Team> teams) {
        this.teams = teams;
        return this;
    }

    public Event players(List<Player> players) {
        this.players = players;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(matchInfo, event.matchInfo) && Objects.equals(teams, event.teams) && Objects.equals(players, event.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchInfo, teams, players);
    }

    @Override
    public String toString() {
        return "{" +
            " matchInfo='" + getMatchInfo() + "'" +
            ", teams='" + getTeams() + "'" +
            ", players='" + getPlayers() + "'" +
            "}";
    }

    public String teamsToString() {
        int listSize = getTeams().size();
        int loopCounter = 0;
        
        String teams = "";
        teams = teams + "[";

        while (loopCounter < listSize) {
            String team = getTeams().get(loopCounter).toJson();
            teams = teams + team;
            if (loopCounter+1 < listSize) {
                teams = teams + ",";
            }
            loopCounter++;
        }

        teams = teams + "]";
        return teams;
    }

    public String playersToString() {
        int listSize = getPlayers().size();
        int loopCounter = 0;

        String players = "";
        players = players + "[";

        while (loopCounter < listSize) {
            String player = getPlayers().get(loopCounter).toJson();
            players = players + player;
            if (loopCounter+1 < listSize) {
                players = players + ",";
            }
            loopCounter++;
        }

        players = players + "]";
        return players;
    }

    public String toJson() {
        return "{" +
            " \"eventId\": " + hashCode() + "," +
            " \"eventTimestamp\": \"" + Instant.now() + "\"," +
            " \"matchInfo\": " + getMatchInfo().toJsonDetailed() + "," +
            " \"players\": " + playersToString() + "," +
            " \"teams\": " + teamsToString() +
            " }";
    }

}
