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

import com.elietmsoft.gods20project.R;
import com.elietmsoft.gods20project.adapters.LearnerAdapter;
import com.elietmsoft.gods20project.adapters.SkillerAdapter;
import com.elietmsoft.gods20project.interfaces.RetrofitClient;
import com.elietmsoft.gods20project.models.Learner;
import com.elietmsoft.gods20project.models.Skiller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SkillerAdapter adapter;
    List<Skiller> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill_layout,container,false);

        recyclerView = view.findViewById(R.id.list_skills);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Skiller>> call = RetrofitClient.getInstance().getApi().getSkillers();
        call.enqueue(new Callback<List<Skiller>>() {
            @Override
            public void onResponse(Call<List<Skiller>> call, Response<List<Skiller>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getActivity(),"Error :"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                list = response.body();
                //sort by score
                Collections.sort(list);
                adapter = new SkillerAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void
            onFailure(Call<List<Skiller>> call, Throwable t) {
                Toast.makeText(getActivity(),"Failure :"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
