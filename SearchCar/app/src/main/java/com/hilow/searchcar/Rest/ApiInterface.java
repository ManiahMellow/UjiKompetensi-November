package com.hilow.searchcar.Rest;

import com.hilow.searchcar.Model.GetHistory;
import com.hilow.searchcar.Model.GetKategori;
import com.hilow.searchcar.Model.GetLogin;
import com.hilow.searchcar.Model.GetMenu;
import com.hilow.searchcar.Model.GetRegister;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.Model.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/kategori")
    Call<GetKategori> getKategori();

    @GET("/api/menu")
    Call<GetMenu> getMenu();

    @GET("/api/order")
    Call<GetHistory> getOrder();

    @POST("/api/register")
    Call<GetRegister> daftarUser(@Body Register register);

    @POST("/api/login")
    Call<GetLogin> loginUser(@Body Login login);


}
