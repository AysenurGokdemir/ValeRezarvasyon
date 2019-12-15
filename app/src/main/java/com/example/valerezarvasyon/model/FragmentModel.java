package com.example.valerezarvasyon.model;

public class FragmentModel {

    private String fragmentId, fragmentTitle;

    /**
     * Fragment Modeli constructoru
     *
     * @param fragmentId    Oluşturulan fragmentın fragment idsi (Ör : fragment_main)
     * @param fragmentTitle Fragment ekranda gösterilirken toolbarda gösterilicek başlık.
     */
    public FragmentModel(String fragmentId, String fragmentTitle) {
        this.fragmentId = fragmentId;
        this.fragmentTitle = fragmentTitle;
    }

    public String getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(String fragmentId) {
        this.fragmentId = fragmentId;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public void setFragmentTitle(String fragmentTitle) {
        this.fragmentTitle = fragmentTitle;
    }
}
