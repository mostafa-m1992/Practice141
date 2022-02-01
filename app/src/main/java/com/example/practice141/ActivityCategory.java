package com.example.practice141;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.practice141.Adapters.AdapterCategory;
import com.example.practice141.Models.ModelCategory;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategory extends AppCompatActivity {

    private RecyclerView recyclerCategory;
    AdapterCategory adapterCategory;
    List<ModelCategory> modelCategoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerCategory = findViewById(R.id.recyclerCategory);
        adapterCategory = new AdapterCategory(this, modelCategoryList);
        recyclerCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerCategory.setAdapter(adapterCategory);

        setCategory();
    }

    private void setCategory() {

        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(1, R.drawable.hyundai1, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));
        modelCategoryList.add(new ModelCategory(5, R.drawable.hyundai6, "hyundai1"));


        adapterCategory.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}