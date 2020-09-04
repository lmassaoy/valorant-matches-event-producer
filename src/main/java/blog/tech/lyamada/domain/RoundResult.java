package blog.tech.lyamada.domain;

import java.util.Objects;

public class RoundResult {
    private int roundNum;
    private String roundResult;
    private String roundCeremony;
    private String attackers;
    private String defenders;
    private String winningTeam;
    private String bombPlanter;
    private String bombDefuser;
    private int plantRoundTime;
    private int defuseRoundTime;
    private String plantSite;
    // private List<PlayerStats> playerStats;
    private String roundResultCode;


    public RoundResult() {
    }

    public RoundResult(int roundNum, String roundResult, String roundCeremony, String attackers, String defenders, String winningTeam, String bombPlanter, String bombDefuser, int plantRoundTime, int defuseRoundTime, String plantSite, String roundResultCode) {
        this.roundNum = roundNum;
        this.roundResult = roundResult;
        this.roundCeremony = roundCeremony;
        this.attackers = attackers;
        this.defenders = defenders;
        this.winningTeam = winningTeam;
        this.bombPlanter = bombPlanter;
        this.bombDefuser = bombDefuser;
        this.plantRoundTime = plantRoundTime;
        this.defuseRoundTime = defuseRoundTime;
        this.plantSite = plantSite;
        this.roundResultCode = roundResultCode;
    }

    public int getRoundNum() {
        return this.roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public String getRoundResult() {
        return this.roundResult;
    }

    public void setRoundResult(String roundResult) {
        this.roundResult = roundResult;
    }

    public String getRoundCeremony() {
        return this.roundCeremony;
    }

    public void setRoundCeremony(String roundCeremony) {
        this.roundCeremony = roundCeremony;
    }

    public String getAttackers() {
        return this.attackers;
    }

    public void setAttackers(String attackers) {
        this.attackers = attackers;
    }

    public String getDefenders() {
        return this.defenders;
    }

    public void setDefenders(String defenders) {
        this.defenders = defenders;
    }

    public String getWinningTeam() {
        return this.winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getBombPlanter() {
        return this.bombPlanter;
    }

    public void setBombPlanter(String bombPlanter) {
        this.bombPlanter = bombPlanter;
    }

    public String getBombDefuser() {
        return this.bombDefuser;
    }

    public void setBombDefuser(String bombDefuser) {
        this.bombDefuser = bombDefuser;
    }

    public int getPlantRoundTime() {
        return this.plantRoundTime;
    }

    public void setPlantRoundTime(int plantRoundTime) {
        this.plantRoundTime = plantRoundTime;
    }

    public int getDefuseRoundTime() {
        return this.defuseRoundTime;
    }

    public void setDefuseRoundTime(int defuseRoundTime) {
        this.defuseRoundTime = defuseRoundTime;
    }

    public String getPlantSite() {
        return this.plantSite;
    }

    public void setPlantSite(String plantSite) {
        this.plantSite = plantSite;
    }

    public String getRoundResultCode() {
        return this.roundResultCode;
    }

    public void setRoundResultCode(String roundResultCode) {
        this.roundResultCode = roundResultCode;
    }

    public RoundResult roundNum(int roundNum) {
        this.roundNum = roundNum;
        return this;
    }

    public RoundResult roundResult(String roundResult) {
        this.roundResult = roundResult;
        return this;
    }

    public RoundResult roundCeremony(String roundCeremony) {
        this.roundCeremony = roundCeremony;
        return this;
    }

    public RoundResult attackers(String attackers) {
        this.attackers = attackers;
        return this;
    }

    public RoundResult defenders(String defenders) {
        this.defenders = defenders;
        return this;
    }

    public RoundResult winningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
        return this;
    }

    public RoundResult bombPlanter(String bombPlanter) {
        this.bombPlanter = bombPlanter;
        return this;
    }

    public RoundResult bombDefuser(String bombDefuser) {
        this.bombDefuser = bombDefuser;
        return this;
    }

    public RoundResult plantRoundTime(int plantRoundTime) {
        this.plantRoundTime = plantRoundTime;
        return this;
    }

    public RoundResult defuseRoundTime(int defuseRoundTime) {
        this.defuseRoundTime = defuseRoundTime;
        return this;
    }

    public RoundResult plantSite(String plantSite) {
        this.plantSite = plantSite;
        return this;
    }

    public RoundResult roundResultCode(String roundResultCode) {
        this.roundResultCode = roundResultCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoundResult)) {
            return false;
        }
        RoundResult roundResult = (RoundResult) o;
        return roundNum == roundResult.roundNum && Objects.equals(roundResult, roundResult.roundResult) && Objects.equals(roundCeremony, roundResult.roundCeremony) && Objects.equals(attackers, roundResult.attackers) && Objects.equals(defenders, roundResult.defenders) && Objects.equals(winningTeam, roundResult.winningTeam) && Objects.equals(bombPlanter, roundResult.bombPlanter) && Objects.equals(bombDefuser, roundResult.bombDefuser) && plantRoundTime == roundResult.plantRoundTime && defuseRoundTime == roundResult.defuseRoundTime && Objects.equals(plantSite, roundResult.plantSite) && Objects.equals(roundResultCode, roundResult.roundResultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundNum, roundResult, roundCeremony, attackers, defenders, winningTeam, bombPlanter, bombDefuser, plantRoundTime, defuseRoundTime, plantSite, roundResultCode);
    }

    @Override
    public String toString() {
        return "{" +
            " roundNum='" + getRoundNum() + "'" +
            ", roundResult='" + getRoundResult() + "'" +
            ", roundCeremony='" + getRoundCeremony() + "'" +
            ", attackers='" + getAttackers() + "'" +
            ", defenders='" + getDefenders() + "'" +
            ", winningTeam='" + getWinningTeam() + "'" +
            ", bombPlanter='" + getBombPlanter() + "'" +
            ", bombDefuser='" + getBombDefuser() + "'" +
            ", plantRoundTime='" + getPlantRoundTime() + "'" +
            ", defuseRoundTime='" + getDefuseRoundTime() + "'" +
            ", plantSite='" + getPlantSite() + "'" +
            ", roundResultCode='" + getRoundResultCode() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"roundNum\": " + getRoundNum() + "," +
            " \"roundResult\": \"" + getRoundResult() + "\"," +
            " \"roundCeremony\": \"" + getRoundCeremony() + "\"," +
            " \"attackers\": \"" + getAttackers() + "\"," +
            " \"defenders\": \"" + getDefenders() + "\"," +
            " \"winningTeam\": \"" + getWinningTeam() + "\"," +
            " \"bombPlanter\": \"" + getBombPlanter() + "\"," +
            " \"bombDefuser\": \"" + getBombDefuser() + "\"," +
            " \"plantRoundTime\": " + getPlantRoundTime() + "," +
            " \"defuseRoundTime\": " + getDefuseRoundTime() + "," +
            " \"plantSite\": \"" + getPlantSite() + "\"," +
            " \"roundResultCode\": \"" + getRoundResultCode() + "\"" +
            " }";
    }

}
