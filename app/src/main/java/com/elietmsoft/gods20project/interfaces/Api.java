package com.elietmsoft.gods20project.interfaces;

import com.elietmsoft.gods20project.models.LearnerList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
   @GET("hours")
    Call<LearnerList> getLearners();

}
