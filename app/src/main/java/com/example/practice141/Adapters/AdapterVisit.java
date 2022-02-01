package com.example.practice141.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice141.Models.ModelVisit;
import com.example.practice141.R;
import com.google.android.material.card.MaterialCardView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterVisit extends RecyclerView.Adapter<AdapterVisit.MyViewHolder> {

    Context context;
    List<ModelVisit> modelVisits;

    public AdapterVisit(Context context, List<ModelVisit> modelVisits) {
        this.context = context;
        this.modelVisits = modelVisits;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_visit, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelVisit modelVisit = modelVisits.get(position);

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(modelVisit.getPrice());
        holder.textPriceVisit.setText(price + " " + "$");

        //holder.imageVisit.setImageResource(modelVisit.getImage());
        holder.textTitleVisit.setText(modelVisit.getTitle());
        holder.textVisitVisit.setText(modelVisit.getVisit());
    }

    @Override
    public int getItemCount() {
        return modelVisits.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        MaterialCardView cardViewVisit;
        ImageView imageVisit;
        TextView textTitleVisit, textVisitVisit, textPriceVisit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewVisit = itemView.findViewById(R.id.cardViewVisit);
            imageVisit = itemView.findViewById(R.id.imageVisit);
            textTitleVisit = itemView.findViewById(R.id.textTitleVisit);
            textVisitVisit = itemView.findViewById(R.id.textVisitVisit);
            textPriceVisit = itemView.findViewById(R.id.textPriceVisit);
        }
    }
}
