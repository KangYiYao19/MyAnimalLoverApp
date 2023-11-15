package com.example.myanimalloverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.DestHome) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.DestAboutApp) {
                replaceFragment(new AboutAppFragment());
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView, fragment, null)
                .addToBackStack("name")
                .commit();
    }
}