package com.example.valerezarvasyon.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.api.ClientApi;
import com.example.valerezarvasyon.api.EmployeeApi;
import com.example.valerezarvasyon.helper.fragment.BaseFragment;
import com.example.valerezarvasyon.model.Rezervasyon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RezervasyonFragment extends BaseFragment {
    private CheckBox checkYikama;
    private CheckBox checkYakit;
    private Button btnOnay;
    private EditText edtnot;
    private List<List<Rezervasyon>> rezResponseList;
    private EmployeeApi service;
    String state;
    public RezervasyonFragment() {
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_rezervasyon;
    }

    @Override
    protected void init() {
        checkYikama=getActivity().findViewById(R.id.checkYikama);
        checkYakit=getActivity().findViewById(R.id.checkYakit);
        btnOnay=getActivity().findViewById(R.id.btnRez);
        edtnot=getActivity().findViewById(R.id.edtNot);
        service= ClientApi.RequestRetrofit().create(EmployeeApi.class);
    }

    @Override
    protected void handlers() {

        btnOnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkYikama.isChecked()){
                    state="Yikama";
                }else{
                    state="benzin al";
                }
                Rezervasyon rez=new Rezervasyon(state,edtnot.getText().toString());
                Call<Rezervasyon> call=service.postRez(rez);
                call.enqueue(new Callback<Rezervasyon>() {
                    @Override
                    public void onResponse(Call<Rezervasyon> call, Response<Rezervasyon> response) {

                        List<Rezervasyon> rez1= Collections.singletonList(response.body());

                        if (response.body()!=null){
                            rezResponseList=new ArrayList<>();
                            rezResponseList.add(rez1);


                        }else{
                            Toast.makeText(getContext(), "null", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Rezervasyon> call, Throwable t) {

                    }
                });
            }
        });

    }
}

