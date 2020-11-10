package com.example.islamiapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamiapp.adapter.VersesRecycleAdapter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    VersesRecycleAdapter versesRecycleAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView name_sura;


    int pos;
    String name;
    ArrayList<String> verses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        recyclerView = findViewById(R.id.recycler_view);
        name_sura = findViewById(R.id.name_sura);
        pos = getIntent()
                .getIntExtra("pos", -1);
        name = getIntent().getStringExtra("name");
        verses = readSuraFromFile((pos + 1) + ".txt");
        name_sura.setText(name);
        versesRecycleAdapter = new VersesRecycleAdapter(verses);
        layoutManager = new LinearLayoutManager(SuraDetailsActivity.this);
        recyclerView.setAdapter(versesRecycleAdapter);
        recyclerView.setLayoutManager(layoutManager);


    }


    public ArrayList<String> readSuraFromFile(String fileName) {
        ArrayList<String> allVerses = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                allVerses.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return allVerses;
    }
}
