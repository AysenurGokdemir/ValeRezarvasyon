package com.example.valerezarvasyon.fragments;

import android.view.View;
import android.widget.Button;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.helper.fragment.BaseFragment;
import com.example.valerezarvasyon.helper.fragment.FragmentController;


public class SignInFragment extends BaseFragment {

    Button entry;
    Button register;


    public SignInFragment() {
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_sign_in;
    }

    @Override
    protected void init() {

        entry=getActivity().findViewById(R.id.btn_login);
        register=getActivity().findViewById(R.id.btn_register);
    }

    @Override
    protected void handlers() {
         entry.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 listener.onFragmentChange(FragmentController.COMPANY);
             }
         });
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listener.onFragmentChange(FragmentController.SIGNUP);
             }
         });
    }
}
