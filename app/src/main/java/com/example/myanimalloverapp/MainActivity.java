package com.example.myanimalloverapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());

        Toolbar toolbar = findViewById(R.id.TBMainAct);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.DestHome) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.DestAboutApp) {
                replaceFragment(new AboutAppFragment());
            }
            return true;
        });


        drawerLayout = findViewById(R.id.DLMain);
        navigationView = findViewById(R.id.sideNav);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.DestHome) {
                    replaceFragment(new HomeFragment());
                    drawerLayout.closeDrawers();
                }
                else if (item.getItemId() == R.id.DestAboutApp) {
                    replaceFragment(new AboutAppFragment());
                    drawerLayout.closeDrawers();
                }
                else if (item.getItemId() == R.id.DestCat) {
                    replaceFragment(new CatFragment());
                    drawerLayout.closeDrawers();
                }
                else if (item.getItemId() == R.id.DestDog) {
                    replaceFragment(new DogFragment());
                    drawerLayout.closeDrawers();
                }
                return false;
            }
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