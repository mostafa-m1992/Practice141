package com.example.practice141.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice141.Models.ModelCategory;
import com.example.practice141.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder> {

    Context context;
    List<ModelCategory> modelCategories;

    public AdapterCategory(Context context, List<ModelCategory> modelCategories) {
        this.context = context;
        this.modelCategories = modelCategories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelCategory modelCategory = modelCategories.get(position);
        //holder.imageCategory.setImageResource(modelCategory.getImage());
        holder.textTitleCategory.setText(modelCategory.getTitleCategory());

        holder.cardViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, modelCategory.getId() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCategories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView cardViewCategory;
        ImageView imageCategory;
        TextView textTitleCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewCategory = itemView.findViewById(R.id.cardViewCategory);
            imageCategory = itemView.findViewById(R.id.imageCategory);
            textTitleCategory = itemView.findViewById(R.id.textTitleCategory);
        }
    }
}
