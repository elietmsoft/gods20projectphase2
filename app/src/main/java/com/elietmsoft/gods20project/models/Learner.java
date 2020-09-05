package com.elietmsoft.gods20project.models;

import java.util.Comparator;

public class Learner implements Comparable<Learner> {
    private String name;
    private int hours;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
    public int compareTo(Learner learner) {
        if(learner.getHours()>this.getHours()){
            return +1;
        }
        else if(learner.getHours()<this.getHours()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
