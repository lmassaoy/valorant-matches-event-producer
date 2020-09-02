package blog.tech.lyamada.domain;

public class Match {
    private int id;
    private String country;
    private String type;

    public Match(int id, String country, String type) {
        this.id = id;
        this.country = country;
        this.type = type;
    }

    public Match() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
