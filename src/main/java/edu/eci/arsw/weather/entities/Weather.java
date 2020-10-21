package edu.eci.arsw.weather.entities;

public class Weather {
    private String description;
    private String main;
    private int id;

    public Weather() {
    }

    public Weather(int id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
