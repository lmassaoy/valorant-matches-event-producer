package blog.tech.lyamada.domain;

import java.time.Instant;
import java.util.Objects;

public class Match {
    private String matchId;
    private Map map;
    private Long gameLengthMillis;
    private Long gameStartMillis;
    private boolean isCompleted;
    private GameMode gameMode;
    private boolean isRanked;
    private int seasonId;
    private Instant startTime;
    private Instant endTime;



    public Match() {
    }

    public Match(String matchId, Map map, Long gameLengthMillis, Long gameStartMillis, boolean isCompleted, GameMode gameMode, boolean isRanked, int seasonId, Instant startTime) {
        this.matchId = matchId;
        this.map = map;
        this.gameLengthMillis = gameLengthMillis;
        this.gameStartMillis = gameStartMillis;
        this.isCompleted = isCompleted;
        this.gameMode = gameMode;
        this.isRanked = isRanked;
        this.seasonId = seasonId;
        this.startTime = startTime;
    }

    public Match(String matchId, Map map, Long gameLengthMillis, Long gameStartMillis, boolean isCompleted, GameMode gameMode, boolean isRanked, int seasonId, Instant startTime, Instant endTime) {
        this.matchId = matchId;
        this.map = map;
        this.gameLengthMillis = gameLengthMillis;
        this.gameStartMillis = gameStartMillis;
        this.isCompleted = isCompleted;
        this.gameMode = gameMode;
        this.isRanked = isRanked;
        this.seasonId = seasonId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Map getMap() {
        return this.map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Long getGameLengthMillis() {
        return this.gameLengthMillis;
    }

    public void setGameLengthMillis(Long gameLengthMillis) {
        this.gameLengthMillis = gameLengthMillis;
    }

    public Long getGameStartMillis() {
        return this.gameStartMillis;
    }

    public void setGameStartMillis(Long gameStartMillis) {
        this.gameStartMillis = gameStartMillis;
    }

    public boolean isIsCompleted() {
        return this.isCompleted;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public GameMode getGameMode() {
        return this.gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public boolean isIsRanked() {
        return this.isRanked;
    }

    public boolean getIsRanked() {
        return this.isRanked;
    }

    public void setIsRanked(boolean isRanked) {
        this.isRanked = isRanked;
    }

    public int getSeasonId() {
        return this.seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public Instant getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Match matchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public Match map(Map map) {
        this.map = map;
        return this;
    }

    public Match gameLengthMillis(Long gameLengthMillis) {
        this.gameLengthMillis = gameLengthMillis;
        return this;
    }

    public Match gameStartMillis(Long gameStartMillis) {
        this.gameStartMillis = gameStartMillis;
        return this;
    }

    public Match isCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public Match gameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public Match isRanked(boolean isRanked) {
        this.isRanked = isRanked;
        return this;
    }

    public Match seasonId(int seasonId) {
        this.seasonId = seasonId;
        return this;
    }

    public Match startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public Match endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Match)) {
            return false;
        }
        Match match = (Match) o;
        return Objects.equals(matchId, match.matchId) && Objects.equals(map, match.map) && Objects.equals(gameLengthMillis, match.gameLengthMillis) && Objects.equals(gameStartMillis, match.gameStartMillis) && isCompleted == match.isCompleted && Objects.equals(gameMode, match.gameMode) && isRanked == match.isRanked && seasonId == match.seasonId && Objects.equals(startTime, match.startTime) && Objects.equals(endTime, match.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, map, gameLengthMillis, gameStartMillis, isCompleted, gameMode, isRanked, seasonId, startTime, endTime);
    }

    @Override
    public String toString() {
        return "{" +
            " matchId='" + getMatchId() + "'" +
            ", map='" + getMap() + "'" +
            ", gameLengthMillis='" + getGameLengthMillis() + "'" +
            ", gameStartMillis='" + getGameStartMillis() + "'" +
            ", isCompleted='" + isIsCompleted() + "'" +
            ", gameMode='" + getGameMode() + "'" +
            ", isRanked='" + isIsRanked() + "'" +
            ", seasonId='" + getSeasonId() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }
    

    public String toJson() {
        return "{" +
        " \"matchId\": \"" + getMatchId() + "\"," +
        " \"mapId\": " + getMap().getMapId() + "," +
        " \"gameLengthMillis\": " + String.valueOf(getGameLengthMillis()) + "," +
        " \"gameStartMillis\": " + String.valueOf(getGameStartMillis()) + "," +
        " \"isCompleted\": " + isIsCompleted() + "," +
        " \"gameModeId\": " + getGameMode().getGameModeId() + "," +
        " \"isRanked\": " + isIsRanked() + "," +
        " \"seasonId\": " + getSeasonId() + "," +
        " \"startTime\": \"" + getStartTime() + "\"," +
        " \"endTime\": \"" + getEndTime() + "\"" +
        " }";
    }

    public String toJsonDetailed() {
        return "{" +
        " \"matchId\": \"" + getMatchId() + "\"," +
        " \"map\": " + getMap().toJson() + "," +
        " \"gameLengthMillis\": " + String.valueOf(getGameLengthMillis()) + "," +
        " \"gameStartMillis\": " + String.valueOf(getGameStartMillis()) + "," +
        " \"isCompleted\": " + isIsCompleted() + "," +
        " \"gameMode\": " + getGameMode().toJson() + "," +
        " \"isRanked\": " + isIsRanked() + "," +
        " \"seasonId\": " + getSeasonId() + "," +
        " \"startTime\": \"" + getStartTime() + "\"," +
        " \"endTime\": \"" + getEndTime() + "\"" +
        " }";
    }

}
