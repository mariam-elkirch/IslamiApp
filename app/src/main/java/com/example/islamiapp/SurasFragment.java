package com.example.islamiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.islamiapp.adapter.SurasRecyclerAdapter;

public class SurasFragment extends Fragment {

    public SurasFragment(){

    }

    RecyclerView recyclerView;
    SurasRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_suras,container,false);


        recyclerView=view.findViewById(R.id.recycler_view);

        adapter=new SurasRecyclerAdapter(Constants.ArSuras);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {
                //start activity sura details
                //  Toast.makeText(SurasActivity.this, pos+ " "+name, Toast.LENGTH_SHORT).show();
                // SuraDetailsActivity.pos=pos;
                Intent intent=new Intent(getActivity(),SuraDetailsActivity.class);
                intent.putExtra("pos",pos);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        layoutManager=new GridLayoutManager(getContext(),3,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        SnapHelper helper=new PagerSnapHelper();
        helper.attachToRecyclerView(recyclerView);



        return view;
    }
}
