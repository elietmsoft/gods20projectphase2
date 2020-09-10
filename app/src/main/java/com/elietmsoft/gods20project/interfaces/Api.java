package com.elietmsoft.gods20project.interfaces;

import com.elietmsoft.gods20project.models.Learner;
import com.elietmsoft.gods20project.models.Skiller;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
   @GET("hours")
    Call<List<Learner>> getLearners();
   @GET("skilliq")
    Call<List<Skiller>> getSkillers();
   @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
   @FormUrlEncoded
    Call<ResponseBody> envoiProject(
         @Field("entry.1824927963") String email,
         @Field("entry.1877115667") String firstName,
         @Field("entry.2006916086") String lastName,
         @Field("entry.284483984") String link
   );

}
