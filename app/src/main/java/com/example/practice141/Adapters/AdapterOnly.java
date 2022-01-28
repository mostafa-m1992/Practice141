package com.example.practice141.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice141.Models.ModelOnly;
import com.example.practice141.R;
import com.google.android.material.card.MaterialCardView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterOnly extends RecyclerView.Adapter<AdapterOnly.MyViewHolder> {

    Context context;
    List<ModelOnly> modelOnlies;

    public AdapterOnly(Context context, List<ModelOnly> modelOnlies) {
        this.context = context;
        this.modelOnlies = modelOnlies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_only, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelOnly modelOnly = modelOnlies.get(position);

        holder.imageOnly.setImageResource(modelOnly.getImage());
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(modelOnly.getPrice());
        holder.textTitleOnly.setText(modelOnly.getTitle());
        holder.textVisitOnly.setText(modelOnly.getVisit());
        holder.textPriceOnly.setText(price + " " + "$");
    }

    @Override
    public int getItemCount() {
        return modelOnlies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        MaterialCardView cardViewOnly;
        ImageView imageOnly;
        TextView textTitleOnly, textVisitOnly, textPriceOnly;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewOnly = itemView.findViewById(R.id.cardViewOnly);
            imageOnly = itemView.findViewById(R.id.imageOnly);
            textTitleOnly = itemView.findViewById(R.id.textTitleOnly);
            textVisitOnly = itemView.findViewById(R.id.textVisitOnly);
            textPriceOnly = itemView.findViewById(R.id.textPriceOnly);
        }
    }
}
