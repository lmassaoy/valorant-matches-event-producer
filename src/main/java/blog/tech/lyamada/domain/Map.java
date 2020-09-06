package blog.tech.lyamada.domain;

import java.util.List;
import java.util.Objects;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Map {
    private int mapId;
    private String mapName;
    private List<String> bombSites;


    public Map() {
    }

    public Map(int mapId, String mapName, List<String> bombSites) {
        this.mapId = mapId;
        this.mapName = mapName;
        this.bombSites = bombSites;
    }

    public int getMapId() {
        return this.mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return this.mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<String> getBombSites() {
        return this.bombSites;
    }

    public void setBombSites(List<String> bombSites) {
        this.bombSites = bombSites;
    }

    public Map mapId(int mapId) {
        this.mapId = mapId;
        return this;
    }

    public Map mapName(String mapName) {
        this.mapName = mapName;
        return this;
    }

    public Map bombSites(List<String> bombSites) {
        this.bombSites = bombSites;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map)) {
            return false;
        }
        Map map = (Map) o;
        return mapId == map.mapId && Objects.equals(mapName, map.mapName) && Objects.equals(bombSites, map.bombSites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapId, mapName, bombSites);
    }

    @Override
    public String toString() {
        return "{" +
            " mapId='" + getMapId() + "'" +
            ", mapName='" + getMapName() + "'" +
            ", bombSites='" + getBombSites() + "'" +
            "}";
    }

    public String bombSitesToString() {
        int listSize = getBombSites().size();
        int loopCounter = 0;

        String bombSites = "";
        bombSites = bombSites + "[";

        while (loopCounter < listSize) {
            String bombSite = "\"" + getBombSites().get(loopCounter) + "\"";
            bombSites = bombSites + bombSite;
            if (loopCounter+1 < listSize) {
                bombSites = bombSites + ",";
            }
            loopCounter++;
        }

        bombSites = bombSites + "]";
        return bombSites;
    }

    public String toJson() {
        return "{" +
            " \"mapId\": " + getMapId() + "," +
            " \"mapName\": \"" + getMapName() + "\"," +
            " \"bombSites\": " + bombSitesToString() +
            " }";
    }

}
