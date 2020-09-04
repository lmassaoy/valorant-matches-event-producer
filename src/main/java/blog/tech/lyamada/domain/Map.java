package blog.tech.lyamada.domain;

import java.util.Objects;

public class Map {
    private int mapId;
    private String mapName;


    public Map() {
    }

    public Map(int mapId, String mapName) {
        this.mapId = mapId;
        this.mapName = mapName;
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

    public Map mapId(int mapId) {
        this.mapId = mapId;
        return this;
    }

    public Map mapName(String mapName) {
        this.mapName = mapName;
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
        return mapId == map.mapId && Objects.equals(mapName, map.mapName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapId, mapName);
    }

    @Override
    public String toString() {
        return "{" +
            " mapId='" + getMapId() + "'" +
            ", mapName='" + getMapName() + "'" +
            "}";
    }

    public String toJson() {
        return "{" +
            " \"mapId\": " + getMapId() + "," +
            " \"mapName\": \"" + getMapName() + "\"" +
            " }";
    }

}
