package blog.tech.lyamada.domain;

import java.util.Objects;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Player {
    private String puuid;
    private String teamId;
    private String partyId;
    private String characterId;
    private Agent agent;
    // private PlayerStats stats;
    private int competitiveTier;
    // private String playerCard;
    // private String playerTitle;


    public Player() {
    }

    public Player(String puuid, String teamId, String partyId, String characterId, Agent agent, int competitiveTier) {
        this.puuid = puuid;
        this.teamId = teamId;
        this.partyId = partyId;
        this.characterId = characterId;
        this.agent = agent;
        this.competitiveTier = competitiveTier;
    }

    public Player(String puuid, String teamId, String partyId, String characterId, int competitiveTier) {
        this.puuid = puuid;
        this.teamId = teamId;
        this.partyId = partyId;
        this.characterId = characterId;
        this.competitiveTier = competitiveTier;
    }

    public String getPuuid() {
        return this.puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getCharacterId() {
        return this.characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getCompetitiveTier() {
        return this.competitiveTier;
    }

    public void setCompetitiveTier(int competitiveTier) {
        this.competitiveTier = competitiveTier;
    }

    public Player puuid(String puuid) {
        this.puuid = puuid;
        return this;
    }

    public Player teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    public Player partyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    public Player characterId(String characterId) {
        this.characterId = characterId;
        return this;
    }

    public Player agent(Agent agent) {
        this.agent = agent;
        return this;
    }

    public Player competitiveTier(int competitiveTier) {
        this.competitiveTier = competitiveTier;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(puuid, player.puuid) && Objects.equals(teamId, player.teamId) && Objects.equals(partyId, player.partyId) && Objects.equals(characterId, player.characterId) && Objects.equals(agent, player.agent) && competitiveTier == player.competitiveTier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(puuid, teamId, partyId, characterId, agent, competitiveTier);
    }

    @Override
    public String toString() {
        return "{" +
            " puuid='" + getPuuid() + "'" +
            ", teamId='" + getTeamId() + "'" +
            ", partyId='" + getPartyId() + "'" +
            ", characterId='" + getCharacterId() + "'" +
            ", agent='" + getAgent() + "'" +
            ", competitiveTier='" + getCompetitiveTier() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"puuid\": \"" + getPuuid() + "\"," +
            " \"teamId\": \"" + getTeamId() + "\"," +
            " \"partyId\": \"" + getPartyId() + "\"," +
            " \"characterId\": \"" + getCharacterId() + "\"," +
            " \"agent\": " + getAgent().toJson() + "," +
            " \"competitiveTier\": " + getCompetitiveTier() + 
            " }";
    }

}
