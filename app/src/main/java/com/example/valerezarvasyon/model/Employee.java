package com.example.valerezarvasyon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {


    @SerializedName("employeeNo")
    @Expose
    private Integer employeeNo;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("employeeSurname")
    @Expose
    private String employeeSurname;

    public Employee() {
    }

    public Employee(int employeeNo, String employeeName, String employeeSurname) {

        this.employeeNo = employeeNo;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }



    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
}
