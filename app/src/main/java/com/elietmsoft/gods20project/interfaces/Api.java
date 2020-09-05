package com.elietmsoft.gods20project.interfaces;

import com.elietmsoft.gods20project.models.Learner;
import com.elietmsoft.gods20project.models.Skiller;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
   @GET("hours")
    Call<List<Learner>> getLearners();
   @GET("skilliq")
    Call<List<Skiller>> getSkillers();

}
