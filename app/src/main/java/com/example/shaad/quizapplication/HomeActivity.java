package com.example.shaad.quizapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView_home = (BottomNavigationView) findViewById(R.id.bottomNavigationView_home);

        bottomNavigationView_home.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.action_subject:
                        selectedFragment = SubjectFragment.newInstance();
                        break;
                    case R.id.action_profile:
                        selectedFragment = ProfileFragment.newInstance();
                        break;
                }

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.layout_home_frame, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }


        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_home_frame, ProfileFragment.newInstance());
        fragmentTransaction.commit();
    }
}
