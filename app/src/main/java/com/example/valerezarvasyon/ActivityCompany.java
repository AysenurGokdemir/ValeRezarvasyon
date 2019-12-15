package com.example.valerezarvasyon;

import android.os.Bundle;

import com.example.valerezarvasyon.adapters.CustomAdapter;
import com.example.valerezarvasyon.api.ClientApi;
import com.example.valerezarvasyon.api.EmployeeApi;
import com.example.valerezarvasyon.model.Company;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCompany extends AppCompatActivity {


    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private List<Company> companyResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);


        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        getCompanyFromRestApi();

    }


    private void getCompanyFromRestApi(){

        EmployeeApi employeeApi= ClientApi.RequestRetrofit().create(EmployeeApi.class);

        Call<List<Company>> call=employeeApi.getCompany();
        call.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                companyResult=response.body();

                customAdapter=new CustomAdapter(getApplicationContext(),companyResult);
                recyclerView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
