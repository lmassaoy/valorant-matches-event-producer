package blog.tech.lyamada.domain;

import java.util.Objects;

public class PercentageTier {
    public Double minPercent;
    public Double maxPercent;
    public int tier;
    public String tierName;

    public PercentageTier() {
    }

    public PercentageTier(Double minPercent, Double maxPercent, int tier, String tierName) {
        this.minPercent = minPercent;
        this.maxPercent = maxPercent;
        this.tier = tier;
        this.tierName = tierName;
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

    public int getTier() {
        return this.tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getTierName() {
        return this.tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public PercentageTier minPercent(Double minPercent) {
        this.minPercent = minPercent;
        return this;
    }

    public PercentageTier maxPercent(Double maxPercent) {
        this.maxPercent = maxPercent;
        return this;
    }

    public PercentageTier tier(int tier) {
        this.tier = tier;
        return this;
    }

    public PercentageTier tierName(String tierName) {
        this.tierName = tierName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PercentageTier)) {
            return false;
        }
        PercentageTier percentageTier = (PercentageTier) o;
        return Objects.equals(minPercent, percentageTier.minPercent) && Objects.equals(maxPercent, percentageTier.maxPercent) && tier == percentageTier.tier && Objects.equals(tierName, percentageTier.tierName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minPercent, maxPercent, tier, tierName);
    }

    @Override
    public String toString() {
        return "{" +
            " minPercent='" + getMinPercent() + "'" +
            ", maxPercent='" + getMaxPercent() + "'" +
            ", tier='" + getTier() + "'" +
            ", tierName='" + getTierName() + "'" +
            "}";
    }


 
}
