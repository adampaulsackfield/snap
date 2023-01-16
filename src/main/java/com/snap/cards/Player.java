package com.snap.cards;

public class Player {
    private int points = 0;
    private String name;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
