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
import com.example.practice141.Adapters.AdapterOnly;
import com.example.practice141.Adapters.AdapterSales;
import com.example.practice141.Adapters.AdapterVisit;
import com.example.practice141.Models.ModelFree;
import com.example.practice141.Models.ModelOnly;
import com.example.practice141.Models.ModelSales;
import com.example.practice141.Models.ModelVisit;
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

    AdapterOnly adapterOnly;
    List<ModelOnly> modelOnlyList = new ArrayList<>();

    AdapterVisit adapterVisit;
    List<ModelVisit> modelVisitList = new ArrayList<>();

    AdapterSales adapterSales;
    List<ModelSales> modelSalesList = new ArrayList<>();

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
        setDataOnly();
        setDataVisit();
        setDataSales();
    }

    private void setDataSales() {
        adapterSales = new AdapterSales(this, modelSalesList);
        recyclerSales.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerSales.setAdapter(adapterSales);

        modelSalesList.add(new ModelSales(1, R.drawable.hyundai1, "hyundai1", "10", 1000000));
        modelSalesList.add(new ModelSales(2, R.drawable.hyundai2, "hyundai2", "10", 1000000));
        modelSalesList.add(new ModelSales(3, R.drawable.hyundai4, "hyundai3", "10", 1000000));
        modelSalesList.add(new ModelSales(4, R.drawable.hyundai5, "hyundai4", "10", 1000000));
        modelSalesList.add(new ModelSales(5, R.drawable.hyundai6, "hyundai5", "10", 1000000));
        modelSalesList.add(new ModelSales(6, R.drawable.hyundai7, "hyundai6", "10", 1000000));
        modelSalesList.add(new ModelSales(7, R.drawable.hyundai8, "hyundai7", "10", 1000000));
        modelSalesList.add(new ModelSales(8, R.drawable.hyundai9, "hyundai8", "10", 1000000));
        modelSalesList.add(new ModelSales(9, R.drawable.hyundai10, "hyundai9", "10", 1000000));
        modelSalesList.add(new ModelSales(10, R.drawable.hyundai11, "hyundai10", "10", 1000000));
        modelSalesList.add(new ModelSales(11, R.drawable.hyundai12, "hyundai", "10", 1000000));
        modelSalesList.add(new ModelSales(12, R.drawable.hyundai13, "hyundai", "10", 1000000));
        modelSalesList.add(new ModelSales(13, R.drawable.hyundai14, "hyundai", "10", 1000000));
        modelSalesList.add(new ModelSales(14, R.drawable.hyundai15, "hyundai", "10", 1000000));
        modelSalesList.add(new ModelSales(15, R.drawable.hyundai16, "hyundai", "10", 1000000));

        adapterSales.notifyDataSetChanged();
    }

    private void setDataVisit() {
        adapterVisit = new AdapterVisit(this, modelVisitList);
        recyclerVisit.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerVisit.setAdapter(adapterVisit);

        modelVisitList.add(new ModelVisit(1, R.drawable.bmw1, "bmw1", "10", 1000000));
        modelVisitList.add(new ModelVisit(2, R.drawable.bmw2, "bmw2", "20", 2000000));
        modelVisitList.add(new ModelVisit(3, R.drawable.bmw3, "bmw3", "30", 3000000));
        modelVisitList.add(new ModelVisit(4, R.drawable.bmw4, "bmw4", "40", 4000000));
        modelVisitList.add(new ModelVisit(5, R.drawable.bmw5, "bmw5", "50", 5000000));
        modelVisitList.add(new ModelVisit(6, R.drawable.bmw6, "bmw6", "60", 6000000));
        modelVisitList.add(new ModelVisit(7, R.drawable.bmw7, "bmw7", "70", 7000000));
        modelVisitList.add(new ModelVisit(8, R.drawable.bmw8, "bmw8", "80", 8000000));
        modelVisitList.add(new ModelVisit(9, R.drawable.bmw9, "bmw9", "90", 9000000));
        modelVisitList.add(new ModelVisit(10, R.drawable.bmw10, "bmw10", "100", 1000000));
        modelVisitList.add(new ModelVisit(11, R.drawable.bmw11, "bmw11", "11", 1000000));
        modelVisitList.add(new ModelVisit(12, R.drawable.bmw12, "bmw12", "12", 1000000));
        modelVisitList.add(new ModelVisit(13, R.drawable.bmw13, "bmw13", "13", 1000000));
        modelVisitList.add(new ModelVisit(14, R.drawable.bmw14, "bmw14", "14", 1000000));
        modelVisitList.add(new ModelVisit(15, R.drawable.bmw15, "bmw15", "15", 1000000));
        modelVisitList.add(new ModelVisit(16, R.drawable.bmw16, "bmw16", "16", 1000000));
        modelVisitList.add(new ModelVisit(17, R.drawable.bmw17, "bmw17", "17", 1000000));
        modelVisitList.add(new ModelVisit(18, R.drawable.bmw18, "bmw18", "18", 1000000));
        modelVisitList.add(new ModelVisit(19, R.drawable.bmw19, "bmw19", "19", 1000000));
        modelVisitList.add(new ModelVisit(20, R.drawable.bmw20, "bmw20", "220", 1000000));
        modelVisitList.add(new ModelVisit(21, R.drawable.bmw21, "bmw21", "24", 1000000));

        adapterVisit.notifyDataSetChanged();
    }

    private void setDataOnly() {
        adapterOnly = new AdapterOnly(this, modelOnlyList);
        recyclerOnly.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerOnly.setAdapter(adapterOnly);

        modelOnlyList.add(new ModelOnly(1, R.drawable.benz1, "benz1", "10", 1000000));
        modelOnlyList.add(new ModelOnly(2, R.drawable.benz2, "benz2", "11", 2000000));
        modelOnlyList.add(new ModelOnly(3, R.drawable.benz3, "benz3", "12", 3000000));
        modelOnlyList.add(new ModelOnly(4, R.drawable.benz4, "benz4", "33", 4000000));
        modelOnlyList.add(new ModelOnly(5, R.drawable.benz5, "benz5", "44", 5000000));
        modelOnlyList.add(new ModelOnly(6, R.drawable.benz6, "benz6", "55", 6000000));
        modelOnlyList.add(new ModelOnly(7, R.drawable.benz7, "benz7", "66", 7000000));
        modelOnlyList.add(new ModelOnly(8, R.drawable.benz8, "benz8", "77", 8000000));
        modelOnlyList.add(new ModelOnly(9, R.drawable.benz9, "benz9", "88", 9000000));

        adapterOnly.notifyDataSetChanged();
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
        modelFreeList.add(new ModelFree(7, R.drawable.lexusa, "lexus7", "60", 60000, "5$"));
        modelFreeList.add(new ModelFree(8, R.drawable.lexusb, "lexus8", "60", 60000, "5$"));
        modelFreeList.add(new ModelFree(9, R.drawable.lexusc, "lexus9", "60", 60000, "5$"));
        modelFreeList.add(new ModelFree(10, R.drawable.lexuse, "lexus10", "60", 60000, "5$"));
        modelFreeList.add(new ModelFree(11, R.drawable.lexusf, "lexus11", "60", 60000, "5$"));
        modelFreeList.add(new ModelFree(12, R.drawable.lexusg, "lexus12", "60", 60000, "5$"));

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