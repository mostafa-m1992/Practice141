package com.example.practice141.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice141.Models.ModelSales;
import com.example.practice141.R;
import com.google.android.material.card.MaterialCardView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterSales extends RecyclerView.Adapter<AdapterSales.MyViewHolder> {

    Context context;
    List<ModelSales> modelSales;

    public AdapterSales(Context context, List<ModelSales> modelSales) {
        this.context = context;
        this.modelSales = modelSales;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_sales, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelSales sales = modelSales.get(position);

        //holder.imageSales.setImageResource(sales.getImage());

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(sales.getPrice());
        holder.textPriceSales.setText(price + " " + "$");

        holder.textTitleSales.setText(sales.getTitle());
        holder.textVisitSales.setText(sales.getVisit());
    }

    @Override
    public int getItemCount() {
        return modelSales.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView cardViewSales;
        ImageView imageSales;
        TextView textTitleSales, textVisitSales, textPriceSales;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewSales = itemView.findViewById(R.id.cardViewSales);
            imageSales = itemView.findViewById(R.id.imageSales);
            textTitleSales = itemView.findViewById(R.id.textTitleSales);
            textVisitSales = itemView.findViewById(R.id.textVisitSales);
            textPriceSales = itemView.findViewById(R.id.textPriceSales);
        }
    }
}
