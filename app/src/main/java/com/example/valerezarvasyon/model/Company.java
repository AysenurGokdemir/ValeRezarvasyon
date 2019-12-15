package com.example.valerezarvasyon.model;

import com.google.gson.annotations.SerializedName;

public class Company {

    private int firmaId;
    @SerializedName("firmaName")
    private String firmaName;
    @SerializedName("firmaDistance")
    private String firmaDistance;
    @SerializedName("firmaService")
    private String firmaService;
    @SerializedName("firmaServiceTime")
    private String firmaServiceTime;

    public Company() {
    }

    public Company(String firmaName, String firmaDistance, String firmaService, String firmaServiceTime) {


        this.firmaName = firmaName;
        this.firmaDistance = firmaDistance;
        this.firmaService = firmaService;
        this.firmaServiceTime = firmaServiceTime;
    }



    public String getFirmaName() {
        return firmaName;
    }

    public void setFirmaName(String firmaName) {
        this.firmaName = firmaName;
    }

    public String getFirmaDistance() {
        return firmaDistance;
    }

    public void setFirmaDistance(String firmaDistance) {
        this.firmaDistance = firmaDistance;
    }

    public String getFirmaService() {
        return firmaService;
    }

    public void setFirmaService(String firmaService) {
        this.firmaService = firmaService;
    }

    public String getFirmaServiceTime() {
        return firmaServiceTime;
    }

    public void setFirmaServiceTime(String firmaServiceTime) {
        this.firmaServiceTime = firmaServiceTime;
    }


}


