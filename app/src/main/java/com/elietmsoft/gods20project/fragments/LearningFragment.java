package com.elietmsoft.gods20project.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elietmsoft.gods20project.LaunchActivity;
import com.elietmsoft.gods20project.R;
import com.elietmsoft.gods20project.adapters.LearnerAdapter;
import com.elietmsoft.gods20project.interfaces.RetrofitClient;
import com.elietmsoft.gods20project.models.Learner;
import com.jaeger.library.StatusBarUtil;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LearnerAdapter adapter;
    List<Learner> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.learning_layout,container,false);
        //
        StatusBarUtil.setTransparent(getActivity());
        //
        recyclerView = view.findViewById(R.id.list_learning);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Learner>> call = RetrofitClient.getInstance().getApi().getLearners();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getActivity(),"Error :"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                list = response.body();
                //sort by hours
                Collections.sort(list);
                adapter = new LearnerAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void
            onFailure(Call<List<Learner>> call, Throwable t) {
                Toast.makeText(getActivity(),"Failure :"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
