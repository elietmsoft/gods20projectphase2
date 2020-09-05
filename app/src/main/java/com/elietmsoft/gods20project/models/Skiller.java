package com.elietmsoft.gods20project.models;

public class Skiller implements Comparable<Skiller> {
    private String name;
    private int score;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public int compareTo(Skiller skiller) {
        if(skiller.getScore() > this.getScore()){
            return +1;
        }
        else if(skiller.getScore() < this.getScore()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
