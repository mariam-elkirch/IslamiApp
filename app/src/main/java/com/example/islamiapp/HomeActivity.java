package com.example.islamiapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener
    navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    int id = menuItem.getItemId();
                    Fragment fragment=null;
                    if(id==R.id.navigation_quran){
                        fragment = new SurasFragment();
                    }else if(id==R.id.navigation_tasbeh){
                        fragment = new SurasFragment();
                    }
                    //replace fragment
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();

                    return true;
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
       }

}
