package com.example.valerezarvasyon.fragments;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.api.ClientApi;
import com.example.valerezarvasyon.api.EmployeeApi;
import com.example.valerezarvasyon.helper.fragment.BaseFragment;
import com.example.valerezarvasyon.helper.fragment.FragmentController;
import com.example.valerezarvasyon.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Integer.parseInt;


public class SignUpFragment extends BaseFragment {

    // SignUp ekranı tasarım elemanları tanımlamaları
    private EditText edtSignupName;
    private EditText edtSignupSurName;
    private EditText edtSignupMail;
    private EditText edtSignupPassword;
    private EditText edtSignupPhoneNumber;
    private Button btnSignup;
    private Button btnCompany;
    private List<List<Employee>> userResponseList;
    private FragmentController fragmentController = new FragmentController();
    private EmployeeApi service;

    public SignUpFragment() {
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void init() {
        //Signup ekranı tasarım elemanlarının initialize edilmesi.
        edtSignupName = getActivity().findViewById(R.id.edt_name);
        edtSignupSurName = getActivity().findViewById(R.id.edt_surname);
        edtSignupMail = getActivity().findViewById(R.id.edt_email);
        edtSignupPassword = getActivity().findViewById(R.id.edt_password);
        edtSignupPhoneNumber = getActivity().findViewById(R.id.edt_telepone_number);
        btnSignup = getActivity().findViewById(R.id.angry_btn);
        btnCompany=getActivity().findViewById(R.id.btnCompany);
        service = ClientApi.RequestRetrofit().create(EmployeeApi.class);
    }

    @Override
    protected void handlers() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Employee employee = new Employee(parseInt(edtSignupPassword.getText().toString()), edtSignupName.getText().toString(), edtSignupSurName.getText().toString());
                Call<Employee> call = service.postEmployee(employee);
                Log.w("request", call.request().toString());
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        List<Employee> employee1 = Collections.singletonList(response.body());

                        if (response.body() != null) {
                            userResponseList = new ArrayList<List<Employee>>();
                            userResponseList.add(employee1);
                            fragmentController = fragmentController.getInstance(getActivity());


                            //listener.onFragmentChange(FragmentController.REZERVASYON);

                        } else {
                            Toast.makeText(getContext(), "hata", Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        t.printStackTrace();
                    }

                });
                listener.onFragmentChange(FragmentController.LOGIN);
            }
        });

        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onFragmentChange(FragmentController.COMPANY);
            }
        });
    }

    private boolean isEmpty(EditText edittext) {
        if (edittext.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}
