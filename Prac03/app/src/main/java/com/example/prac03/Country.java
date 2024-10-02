package com.example.prac03;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;
    private int flag; // Đây là ID của drawable resource
    private String population;
    private String area;
    private String density;
    private String worldShare;

    // Constructor
    public Country(String name, String capital, int flag, String population, String area, String density, String worldShare) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.population = population;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlag() {
        return flag;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public String getDensity() {
        return density;
    }

    public String getWorldShare() {
        return worldShare;
    }
}

