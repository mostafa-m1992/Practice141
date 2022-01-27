package com.example.practice141.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice141.Models.ModelFree;
import com.example.practice141.R;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterFree extends RecyclerView.Adapter<AdapterFree.MyViewHolder> {

    Context context;
    List<ModelFree> modelFrees;

    public AdapterFree(Context context, List<ModelFree> modelFrees) {
        this.context = context;
        this.modelFrees = modelFrees;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_free, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelFree free = modelFrees.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format((free.getPrice()));
        holder.textPriceFree.setText(price + " " + "$");
        holder.textVisitFree.setText(free.getVisit());
        holder.textTitle.setText(free.getTitle());
        holder.textFreePrice.setText(free.getFree());
        holder.imageFree.setImageResource(free.getImage());
    }

    @Override
    public int getItemCount() {
        return modelFrees.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        CardView cardViewFree;
        ImageView imageFree;
        TextView textTitle, textVisitFree, textPriceFree, textFreePrice;
        //Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), String.valueOf(R.font.times));

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            cardViewFree = itemView.findViewById(R.id.cardViewFree);
            imageFree = itemView.findViewById(R.id.imageFree);
            textTitle = itemView.findViewById(R.id.textTitle);
            //textTitle.setTypeface(typeface);
            textVisitFree = itemView.findViewById(R.id.textVisitFree);
            //textVisitFree.setTypeface(typeface);
            textPriceFree = itemView.findViewById(R.id.textPriceFree);
            //textPriceFree.setTypeface(typeface);
            textFreePrice = itemView.findViewById(R.id.textFreePrice);
            //textFreePrice.setTypeface(typeface);
        }
    }
}
