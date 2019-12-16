package com.example.valerezarvasyon.fragments;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.adapters.CustomAdapter;
import com.example.valerezarvasyon.api.ClientApi;
import com.example.valerezarvasyon.api.EmployeeApi;
import com.example.valerezarvasyon.helper.fragment.BaseFragment;
import com.example.valerezarvasyon.model.Company;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private List<Company> companyResult;

    public CompanyFragment() {
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_company;
    }

    @Override
    protected void init() {
        recyclerView = getActivity().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    protected void handlers() {
        EmployeeApi employeeApi= ClientApi.RequestRetrofit().create(EmployeeApi.class);

        Call<List<Company>> call=employeeApi.getCompany();
        call.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                companyResult=response.body();

                customAdapter=new CustomAdapter(getActivity(),companyResult);
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
