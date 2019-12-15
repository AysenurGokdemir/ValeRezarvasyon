package com.example.valerezarvasyon.helper.fragment;

import android.content.Context;
import android.os.Bundle;

import com.example.valerezarvasyon.R;
import com.example.valerezarvasyon.fragments.RezervasyonFragment;
import com.example.valerezarvasyon.fragments.SignUpFragment;
import com.example.valerezarvasyon.model.FragmentModel;

import androidx.fragment.app.Fragment;

public class FragmentController {

    private static FragmentController instance = null;
    private static String currentFragment = "";
    private Context context;

    public static FragmentModel LOGIN;
    public static FragmentModel SIGNUP;
    public static FragmentModel EXAMPLE;
    public static FragmentModel REZERVASYON;

    /**
     * Fragmentların tanımlandığı fonksiyon.
     */
    private void setFragmentDetails() {

        LOGIN = new FragmentModel("fragment_sign_in", context.getResources().getString(R.string.sign_In));
        SIGNUP = new FragmentModel("fragment_sign_up", context.getResources().getString(R.string.sign_Up));
        REZERVASYON=new FragmentModel("fragment_rezervasyon","REZERVASYON YAP");


    }
    public FragmentController() {
    }

    /**
     * Singleton class yapısı oluşturmak için yazılmış fonksiyon.
     *
     * @return FragmentController
     */
    public synchronized FragmentController getInstance(Context context) {
        this.context = context;
        setFragmentDetails();
        if (instance == null) {
            instance = new FragmentController();
        }
        return instance;
    }

    /**
     * Gönderdiğimiz fragment idsinden android.Fragment objesini aldığımız fonksiyon.
     *
     * @param fragment almak istediğimiz fragment idsi
     * @param bundle   almak istediğimiz fragmenta göndereceğimiz bundle
     * @return android.Fragment
     */
    public Fragment getFragment(String fragment, Bundle bundle) {
        if (fragment == null) {
            return null;
        } else {
            currentFragment = fragment;
            if (fragment.equals(REZERVASYON.getFragmentId())) return new RezervasyonFragment();
            else if (fragment.equals(SIGNUP.getFragmentId())) return new SignUpFragment();
            //else if (fragment.equals(SIGNUP.getFragmentId())) return new SignUpFragment();

            return null;
        }
    }
    /**
     * Ekranda gösterdiğimiz fragment idsini döndürür.
     *
     * @return FragmentId
     */
    public static String getCurrentFragment() {
        return currentFragment;
    }
}
