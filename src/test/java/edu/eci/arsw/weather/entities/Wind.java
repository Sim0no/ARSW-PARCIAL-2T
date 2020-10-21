package edu.eci.arsw.weather.entities;

public class Wind {
    private double deg;
    private double speed;


    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
