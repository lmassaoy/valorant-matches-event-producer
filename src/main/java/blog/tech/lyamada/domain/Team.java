package blog.tech.lyamada.domain;

import java.util.Objects;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Team {
    private String teamId; // 	This is an arbitrary string. Red and Blue in bomb modes.
    private boolean won;
    private int roundsPlayed;
    private int roundsWon;
    private int numPoints; //   Team points scored. Number of kills in deathmatch.


    public Team() {
    }

    public Team(String teamId, boolean won, int roundsPlayed, int roundsWon, int numPoints) {
        this.teamId = teamId;
        this.won = won;
        this.roundsPlayed = roundsPlayed;
        this.roundsWon = roundsWon;
        this.numPoints = numPoints;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public boolean isWon() {
        return this.won;
    }

    public boolean getWon() {
        return this.won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public int getRoundsPlayed() {
        return this.roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public int getRoundsWon() {
        return this.roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public int getNumPoints() {
        return this.numPoints;
    }

    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    public Team teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public Team won(boolean won) {
        this.won = won;
        return this;
    }

    public Team roundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
        return this;
    }

    public Team roundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
        return this;
    }

    public Team numPoints(int numPoints) {
        this.numPoints = numPoints;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Team)) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId) && won == team.won && roundsPlayed == team.roundsPlayed && roundsWon == team.roundsWon && numPoints == team.numPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, won, roundsPlayed, roundsWon, numPoints);
    }

    @Override
    public String toString() {
        return "{" +
            " teamId='" + getTeamId() + "'" +
            ", won='" + isWon() + "'" +
            ", roundsPlayed='" + getRoundsPlayed() + "'" +
            ", roundsWon='" + getRoundsWon() + "'" +
            ", numPoints='" + getNumPoints() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"teamId\": \"" + getTeamId() + "\"," +
            " \"won\": " + isWon() + "," +
            " \"roundsPlayed\": " + getRoundsPlayed() + "," +
            " \"roundsWon\": " + getRoundsWon() + "," +
            " \"numPoints\": " + getNumPoints() +
            " }";
    }

}
