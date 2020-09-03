package com.elietmsoft.gods20project.models;

public class PojoLearner {
    private String name;
    private String score;

    public PojoLearner(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
