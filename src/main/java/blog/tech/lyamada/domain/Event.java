package blog.tech.lyamada.domain;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Event {
    private Match matchInfo;
    private List<Team> teams;
    private List<Player> players;
    private List<RoundResult> roundResults;


    public Event() {
    }

    public Event(Match matchInfo, List<Team> teams, List<Player> players, List<RoundResult> roundResults) {
        this.matchInfo = matchInfo;
        this.teams = teams;
        this.players = players;
        this.roundResults = roundResults;
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

    public List<RoundResult> getRoundResults() {
        return this.roundResults;
    }

    public void setRoundResults(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
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

    public Event roundResults(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
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
        return Objects.equals(matchInfo, event.matchInfo) && Objects.equals(teams, event.teams) && Objects.equals(players, event.players) && Objects.equals(roundResults, event.roundResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchInfo, teams, players, roundResults);
    }

    @Override
    public String toString() {
        return "{" +
            " matchInfo='" + getMatchInfo() + "'" +
            ", teams='" + getTeams() + "'" +
            ", players='" + getPlayers() + "'" +
            ", roundResults='" + getRoundResults() + "'" +
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

    public String roundResultsToString() {
        int listSize = getRoundResults().size();
        int loopCounter = 0;

        String roundResults = "";
        roundResults = roundResults + "[";

        while (loopCounter < listSize) {
            String roundResult = getRoundResults().get(loopCounter).toJson();
            roundResults = roundResults + roundResult;
            if (loopCounter+1 < listSize) {
                roundResults = roundResults + ",";
            }
            loopCounter++;
        }

        roundResults = roundResults + "]";
        return roundResults;
    }

    public String toJson() {
        return "{" +
            " \"eventId\": " + hashCode() + "," +
            " \"eventTimestamp\": \"" + Instant.now() + "\"," +
            " \"matchInfo\": " + getMatchInfo().toJsonDetailed() + "," +
            " \"players\": " + playersToString() + "," +
            " \"teams\": " + teamsToString() + "," +
            " \"roundResults\": " + roundResultsToString() +
            " }";
    }

}
