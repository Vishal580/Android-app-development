package com.example.madassign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    FrameLayout framelayout_one;
    BottomNavigationView bottomnav_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        framelayout_one=(FrameLayout) findViewById(R.id.framelayout_one);
        bottomnav_one=(BottomNavigationView) findViewById(R.id.bottomnav_one);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_one,new Home()).commit();

        bottomnav_one.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_one, new Home()).commit();
                        break;

                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_one, new Settings()).commit();
                        break;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_one, new Profile()).commit();
                        break;

                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_one, new About()).commit();
                        break;
                }
                return false;
            }
        });
    }
}