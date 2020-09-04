package blog.tech.lyamada.domain;

import java.util.Objects;

public class RoundResultType {
    private int roundResultCode;
    private String roundResult;
    public Double minPercent;
    public Double maxPercent;


    public RoundResultType() {
    }

    public RoundResultType(int roundResultCode, String roundResult, Double minPercent, Double maxPercent) {
        this.roundResultCode = roundResultCode;
        this.roundResult = roundResult;
        this.minPercent = minPercent;
        this.maxPercent = maxPercent;
    }

    public int getRoundResultCode() {
        return this.roundResultCode;
    }

    public void setRoundResultCode(int roundResultCode) {
        this.roundResultCode = roundResultCode;
    }

    public String getRoundResult() {
        return this.roundResult;
    }

    public void setRoundResult(String roundResult) {
        this.roundResult = roundResult;
    }

    public Double getMinPercent() {
        return this.minPercent;
    }

    public void setMinPercent(Double minPercent) {
        this.minPercent = minPercent;
    }

    public Double getMaxPercent() {
        return this.maxPercent;
    }

    public void setMaxPercent(Double maxPercent) {
        this.maxPercent = maxPercent;
    }

    public RoundResultType roundResultCode(int roundResultCode) {
        this.roundResultCode = roundResultCode;
        return this;
    }

    public RoundResultType roundResult(String roundResult) {
        this.roundResult = roundResult;
        return this;
    }

    public RoundResultType minPercent(Double minPercent) {
        this.minPercent = minPercent;
        return this;
    }

    public RoundResultType maxPercent(Double maxPercent) {
        this.maxPercent = maxPercent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoundResultType)) {
            return false;
        }
        RoundResultType roundResultType = (RoundResultType) o;
        return roundResultCode == roundResultType.roundResultCode && Objects.equals(roundResult, roundResultType.roundResult) && Objects.equals(minPercent, roundResultType.minPercent) && Objects.equals(maxPercent, roundResultType.maxPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundResultCode, roundResult, minPercent, maxPercent);
    }

    @Override
    public String toString() {
        return "{" +
            " roundResultCode='" + getRoundResultCode() + "'" +
            ", roundResult='" + getRoundResult() + "'" +
            ", minPercent='" + getMinPercent() + "'" +
            ", maxPercent='" + getMaxPercent() + "'" +
            "}";
    }


}
