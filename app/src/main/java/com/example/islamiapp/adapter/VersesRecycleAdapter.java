package com.example.islamiapp.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.islamiapp.R;

import java.util.ArrayList;

public class VersesRecycleAdapter extends RecyclerView.Adapter<VersesRecycleAdapter.ViewHolder> {

    ArrayList<String> verses;

    public VersesRecycleAdapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_verse,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String verse=verses.get(position);
        holder.name.setText(verse);
    }

    @Override
    public int getItemCount() {
        if (verses==null)return 0;
        return verses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.details);
        }
    }
}
