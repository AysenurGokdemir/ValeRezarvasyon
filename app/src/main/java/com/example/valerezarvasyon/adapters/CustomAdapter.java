package com.example.valerezarvasyon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.valerezarvasyon.MainActivity;
import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.helper.fragment.FragmentController;
import com.example.valerezarvasyon.model.Company;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    private List<Company> companyArrayList;
    private static MainActivity obj=new MainActivity();
    private static FragmentController fragmentController = new FragmentController();
    private Context context;


    public CustomAdapter(Context context, List<Company> companyArrayList) {
        this.context = context;
        this.companyArrayList = companyArrayList;
        //this.filteredUserList = companyArrayList;

    }


    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_company, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder viewHolder, int position) {

        viewHolder.companyName.setText(companyArrayList.get(position).getFirmaName());
        viewHolder.companyDistance.setText(companyArrayList.get(position).getFirmaDistance());
        viewHolder.companyService.setText(companyArrayList.get(position).getFirmaService());
        viewHolder.companyServiceTime.setText(companyArrayList.get(position).getFirmaServiceTime());
    }

    @Override
    public int getItemCount() {
        return companyArrayList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView companyName;
        private TextView companyDistance;
        private TextView companyService;
        private TextView companyServiceTime;

        public MyViewHolder(View view) {
            super(view);
            companyName = view.findViewById(R.id.companyName);
            companyDistance = view.findViewById(R.id.companyDistance);
            companyService = view.findViewById(R.id.companyService);
            companyServiceTime = view.findViewById(R.id.companyServiceTime);



        }
    }
}
