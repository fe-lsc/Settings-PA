package com.example.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    SharedPref sharedPref;
    private Switch darkswitchbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);

        if (sharedPref.loadNightModeState() == true) {
            setTheme(R.style.darktheme);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darkswitchbutton = (Switch) findViewById(R.id.darkswitchbutton);
        if (sharedPref.loadNightModeState() == true) {
            darkswitchbutton.setChecked(true);
        }

        darkswitchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedPref.setNightModeState(true);
                    recreate();
                } else {
                    sharedPref.setNightModeState(false);
                    recreate();
                }
            }
        });
    }
}