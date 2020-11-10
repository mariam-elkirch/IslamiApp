package com.example.islamiapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.islamiapp.adapter.SurasRecyclerAdapter;


public class SurasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SurasRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras);
        recyclerView=findViewById(R.id.recycler_view);

        adapter=new SurasRecyclerAdapter(Constants.ArSuras);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String name) {
                //start activity sura details
              //  Toast.makeText(SurasActivity.this, pos+ " "+name, Toast.LENGTH_SHORT).show();
               // SuraDetailsActivity.pos=pos;
                Intent intent=new Intent(SurasActivity.this,SuraDetailsActivity.class);
                intent.putExtra("pos",pos);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        layoutManager=new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

          SnapHelper helper=new PagerSnapHelper();
          helper.attachToRecyclerView(recyclerView);


    }
}
