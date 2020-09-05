package com.elietmsoft.gods20project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elietmsoft.gods20project.R;
import com.elietmsoft.gods20project.models.Skiller;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SkillerAdapter extends RecyclerView.Adapter<SkillerAdapter.MyHolder> {

    Context mContext;
    List<Skiller> pojoSkillers;
    public SkillerAdapter(Context mContext, List<Skiller> pojoSkillers)  {
        this.mContext = mContext;
        this.pojoSkillers = pojoSkillers;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_skill_item,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(pojoSkillers.get(position).getName());
        holder.score.setText(pojoSkillers.get(position).getScore()+" Skill IQ Score, "+pojoSkillers.get(position).getCountry());
        Picasso.
                with(mContext).
                load(pojoSkillers.get(position).getBadgeUrl()).
                into(holder.badgetUrl);
    }

    @Override
    public int getItemCount() {
        return pojoSkillers.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView name, score;
        ImageView badgetUrl;
        public MyHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            score = itemView.findViewById(R.id.txtSkillScore);
            badgetUrl = itemView.findViewById(R.id.img_badget);
        }
    }
}
