package com.example.valerezarvasyon.helper.fragment;

import android.os.Bundle;

import com.example.valerezarvasyon.model.FragmentModel;

public interface FragmentListener {

    /**
     * Fragmentı ekranda göstermek için çağırılan fonksiyon.
     *
     * @param fragment ekranda göstermek istediğimiz fragment idsi
     */
    void onFragmentChange(FragmentModel fragment);

    /**
     * Fragmentı ekranda gösterip, fragmenta veri göndermek için kullanılan fonksiyon.
     *
     * @param fragment ekranda göstermek istediğimiz fragment idsi
     * @param bundle   ekranda göstermek istediğimiz ve fragmenta göndereceğimiz bundle
     */
    void onFragmentChange(FragmentModel fragment, Bundle bundle);
}