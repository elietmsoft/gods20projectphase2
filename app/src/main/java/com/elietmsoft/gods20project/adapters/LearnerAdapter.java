package com.elietmsoft.gods20project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elietmsoft.gods20project.R;
import com.elietmsoft.gods20project.models.Learner;
import com.elietmsoft.gods20project.models.PojoLearner;

import java.util.ArrayList;
import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.MyHolder> {

    Context mContext;
    //ArrayList<PojoLearner> pojoLearners;
    List<Learner> pojoLearners;
    public LearnerAdapter(Context mContext,List<Learner> pojoLearners)  {
        this.mContext = mContext;
        this.pojoLearners = pojoLearners;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_learning_item,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(pojoLearners.get(position).getName());
        holder.hours.setText(""+pojoLearners.get(position).getHours());
    }

    @Override
    public int getItemCount() {
        return pojoLearners.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView name, hours,country;
        public MyHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            hours = itemView.findViewById(R.id.txtLearningScore);
            //country = itemView.findViewById()
        }
    }
}
