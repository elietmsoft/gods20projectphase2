package com.elietmsoft.gods20project.fragments;

import android.os.Bundle;
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
import com.elietmsoft.gods20project.adapters.SkillerAdapter;
import com.elietmsoft.gods20project.models.PojoLearner;
import com.elietmsoft.gods20project.models.PojoSkiller;

import java.util.ArrayList;

public class SkillFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SkillerAdapter adapter;
    ArrayList<PojoSkiller> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skill_layout,container,false);
        listGods();
        recyclerView = view.findViewById(R.id.list_skills);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SkillerAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        return view;

    }

    private void listGods(){
        list = new ArrayList<>();
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","223 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));
        list.add(new PojoSkiller("Elie Tshibangu","234 Skill IQ Score, RDC"));

    }
}
