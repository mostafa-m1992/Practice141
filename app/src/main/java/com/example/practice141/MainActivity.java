package com.example.practice141;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.practice141.Adapters.AdapterFree;
import com.example.practice141.Models.ModelFree;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView image1;
    CoordinatorLayout coordinator;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar mainToolbar;
    RecyclerView recyclerFree, recyclerOnly, recyclerVisit, recyclerSales;

    AdapterFree adapterFree;
    List<ModelFree> modelFreeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinator = findViewById(R.id.coordinator);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        mainToolbar = findViewById(R.id.main_toolbar);
        image1 = findViewById(R.id.image1);
        recyclerFree = findViewById(R.id.recyclerFree);
        recyclerOnly = findViewById(R.id.recyclerOnly);
        recyclerVisit = findViewById(R.id.recyclerVisit);
        recyclerSales = findViewById(R.id.recyclerSales);

        setSupportActionBar(mainToolbar);

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayout, mainToolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        Picasso.get().load(R.drawable.lexuse).into(image1);

        setDataFree();
    }

    private void setDataFree() {
        adapterFree = new AdapterFree(getApplicationContext(), modelFreeList);
        recyclerFree.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerFree.setAdapter(adapterFree);

        modelFreeList.add(new ModelFree(1, R.drawable.lexus2, "lexus2", "10", 100000, "5%"));
        modelFreeList.add(new ModelFree(2, R.drawable.lexus3, "lexus3", "20", 20000, "6$"));
        modelFreeList.add(new ModelFree(3, R.drawable.lexus3, "lexus3", "30", 30000, "7$"));
        modelFreeList.add(new ModelFree(4, R.drawable.lexus4, "lexus4", "40", 40000, "8$"));
        modelFreeList.add(new ModelFree(5, R.drawable.lexus5, "lexus5", "50", 50000, "9$"));
        modelFreeList.add(new ModelFree(6, R.drawable.lexusd, "lexus6", "60", 60000, "5$"));


        adapterFree.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int optionId = item.getItemId();
        switch (optionId) {
            case R.id.page2:
                startActivity(new Intent(this, MainActivity2.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}