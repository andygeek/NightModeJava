package com.andygeek.nightmodejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_button;
    boolean mode_night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_button = findViewById(R.id.fab_button);


        getSupportFragmentManager().beginTransaction().add(R.id.fragment, new NightModeFragment()).commit();
        mode_night = false;

        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                if(mode_night){
                    fragment = new NightModeFragment();
                }
                else{
                    fragment = new DayModeFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
                mode_night = !mode_night;
            }
        });

    }
}
