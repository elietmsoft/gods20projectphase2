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
import com.elietmsoft.gods20project.models.PojoLearner;

import java.util.ArrayList;

public class LearningFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LearnerAdapter adapter;
    ArrayList<PojoLearner> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.learning_layout,container,false);
        listGods();
        recyclerView = view.findViewById(R.id.list_learning);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LearnerAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        return view;

    }

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
}
