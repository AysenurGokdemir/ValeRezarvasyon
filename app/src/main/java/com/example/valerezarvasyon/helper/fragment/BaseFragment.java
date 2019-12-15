package com.example.valerezarvasyon.helper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {

    protected FragmentListener listener;


    /**
     * Fragmentın fragment idsini döndürür
     *
     * @return integer
     */
    protected abstract int getFragmentId();

    /**
     * Fragment oluşturulurken view tanımlamalarının veya başlangıç kontrollerinin yapılacağı fonksiyon.
     */
    protected abstract void init();

    /**
     * Fragment initten sonra listener tanımlamalarının yapılacağı fonksiyon.
     */
    protected abstract void handlers();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        handlers();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentId(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (FragmentListener) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
