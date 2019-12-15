package com.example.valerezarvasyon.model;

public class Rezervasyon {

    int id;
    int companyId;
    String state;
    String ekstservice;
    String note;

    public Rezervasyon() {

    }

    public Rezervasyon(String ekstservice, String state) {


        this.state = state;
        this.ekstservice = ekstservice;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getEkstservice() {
        return ekstservice;
    }

    public void setEkstservice(String ekstservice) {
        this.ekstservice = ekstservice;
    }


}

