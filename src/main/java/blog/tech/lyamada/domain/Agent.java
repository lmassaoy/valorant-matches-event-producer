package blog.tech.lyamada.domain;

import java.util.Objects;

public class Agent {
    private int agentId;
    private String agentName;


    public Agent() {
    }

    public Agent(int agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
    }

    public int getAgentId() {
        return this.agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Agent agentId(int agentId) {
        this.agentId = agentId;
        return this;
    }

    public Agent agentName(String agentName) {
        this.agentName = agentName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Agent)) {
            return false;
        }
        Agent agent = (Agent) o;
        return agentId == agent.agentId && Objects.equals(agentName, agent.agentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentId, agentName);
    }

    @Override
    public String toString() {
        return "{" +
            " agentId='" + getAgentId() + "'" +
            ", agentName='" + getAgentName() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"agentId\": " + getAgentId() + "," +
            " \"agentName\": \"" + getAgentName() + "\"" +
            " }";
    }
    
}
