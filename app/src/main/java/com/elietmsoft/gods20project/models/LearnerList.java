package com.elietmsoft.gods20project.models;

import java.util.ArrayList;
import java.util.List;

public class LearnerList {
    private List<Learner> learners;

    public LearnerList(List<Learner> learners) {
        this.learners = new ArrayList<>();
        this.learners = learners;
    }

    public List<Learner> getLearners(){
        return learners;
    }
}
