package com.example.valerezarvasyon.api;

import com.example.valerezarvasyon.model.Company;
import com.example.valerezarvasyon.model.Employee;
import com.example.valerezarvasyon.model.Rezervasyon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {


    @POST("employee")
    Call<Employee> postEmployee(@Body Employee employee);

    @POST("employee/rez")
    Call<Rezervasyon> postRez(@Body Rezervasyon rez);

    @GET("employee/company")
    Call<List<Company>> getCompany();


}
