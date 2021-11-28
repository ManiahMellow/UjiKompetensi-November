package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hilow.searchcar.Activity.User.LoginPenyewa;
import com.hilow.searchcar.Activity.User.MainActivity;
import com.hilow.searchcar.Model.GetLogin;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.Rest.ApiClientUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // langsung pindah ke MainActivity atau activity lain
        // begitu memasuki splash screen ini

        loginPenyewa(login);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void loginPenyewa(Login login){
        Call<GetLogin> loginCall = ApiClientUser.getApi().loginUser(login);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    Login login = (Login) response.body().getData();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class).putExtra("data", login));
                    finish();
                }else {
                    String message = "Unable to register, please try again";
                    Toast.makeText(SplashActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(LoginPenyewa.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}