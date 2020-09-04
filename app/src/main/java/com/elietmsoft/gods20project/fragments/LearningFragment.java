package com.elietmsoft.gods20project.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elietmsoft.gods20project.R;
import com.elietmsoft.gods20project.adapters.LearnerAdapter;
import com.elietmsoft.gods20project.interfaces.RetrofitClient;
import com.elietmsoft.gods20project.models.Learner;
import com.elietmsoft.gods20project.models.LearnerList;
import com.elietmsoft.gods20project.models.PojoLearner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LearningFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LearnerAdapter adapter;
    List<Learner> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.learning_layout,container,false);

        recyclerView = view.findViewById(R.id.list_learning);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Call<LearnerList> call = RetrofitClient.getInstance().getApi().getLearners();
        call.enqueue(new Callback<LearnerList>() {
            @Override
            public void onResponse(Call<LearnerList> call, Response<LearnerList> response) {
                //list = response.body().getLearners();
                //adapter = new LearnerAdapter(getActivity(),list);
                //recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<LearnerList> call, Throwable t) {
                Log.d("LearningFragment","**************************"+t.getMessage());
            }
        });

        return view;
    }
    /*
    private void listGods(){
        list = new ArrayList<>();
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
        list.add(new PojoLearner("Elie Tshibangu","223 learning hours, RDC"));
    }
     */
}
