package com.example.valerezarvasyon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.model.Rezervasyon;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapterRez extends RecyclerView.Adapter<CustomAdapterRez.MyViewHolder> {

    private List<Rezervasyon> rezArrayList;
    private Context context;

    public CustomAdapterRez(List<Rezervasyon> companyArrayList, Context context) {
        this.rezArrayList = companyArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapterRez.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_rezervasyon, parent, false);
        final MyViewHolder myHolder = new MyViewHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterRez.MyViewHolder holder, int position) {
        //viewHolder.companyName.setText(companyArrayList.get(position).getFirmaName());

    }


    @Override
    public int getItemCount() {
        return rezArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView companyNameRez;
        private TextView companyDistanceRez;
        private TextView companyServiceRez;
        private TextView companyServiceTimeRez;
        private CheckBox checkYikama;
        private CheckBox checkYakit;
        private CheckBox checkOnay;
        private Button btnOnay;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyNameRez=itemView.findViewById(R.id.companyNameRez);
            companyDistanceRez=itemView.findViewById(R.id.companyDistanceRez);
            companyServiceRez=itemView.findViewById(R.id.companyServiceRez);
            companyServiceTimeRez=itemView.findViewById(R.id.companyTimeRez);
            checkYikama=itemView.findViewById(R.id.checkYikama);
            checkYakit=itemView.findViewById(R.id.checkYakit);
            checkOnay=itemView.findViewById(R.id.checkOnay);
        }
    }
    }

