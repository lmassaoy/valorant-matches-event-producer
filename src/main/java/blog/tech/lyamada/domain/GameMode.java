package blog.tech.lyamada.domain;

import java.util.Objects;

public class GameMode {
    private int gameModeId;
    private String gameModeName;


    public GameMode() {
    }

    public GameMode(int gameModeId, String gameModeName) {
        this.gameModeId = gameModeId;
        this.gameModeName = gameModeName;
    }

    public int getGameModeId() {
        return this.gameModeId;
    }

    public void setGameModeId(int gameModeId) {
        this.gameModeId = gameModeId;
    }

    public String getGameModeName() {
        return this.gameModeName;
    }

    public void setGameModeName(String gameModeName) {
        this.gameModeName = gameModeName;
    }

    public GameMode gameModeId(int gameModeId) {
        this.gameModeId = gameModeId;
        return this;
    }

    public GameMode gameModeName(String gameModeName) {
        this.gameModeName = gameModeName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameMode)) {
            return false;
        }
        GameMode gameMode = (GameMode) o;
        return gameModeId == gameMode.gameModeId && Objects.equals(gameModeName, gameMode.gameModeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameModeId, gameModeName);
    }

    @Override
    public String toString() {
        return "{" +
            " gameModeId='" + getGameModeId() + "'" +
            ", gameModeName='" + getGameModeName() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"gameModeId\": " + getGameModeId() + "," +
            " \"gameModeName\": \"" + getGameModeName() + "\"" +
            " }";
    }
    
}
