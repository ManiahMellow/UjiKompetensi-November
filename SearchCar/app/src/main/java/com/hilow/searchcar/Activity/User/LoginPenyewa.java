package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.GetLogin;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClientUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPenyewa extends AppCompatActivity {
    EditText etemaillogin, etpasswordlogin;
    Button btnLogin;
    public static LoginPenyewa ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_penyewa);

        etemaillogin = findViewById(R.id.etemaillogin);
        etpasswordlogin = findViewById(R.id.etpasswordlogin);
        btnLogin = findViewById(R.id.btnLogin);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.iconHome) {

            Intent intent = new Intent(LoginPenyewa.this, LoginUser.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnLogin(View view) {

        String etemail = etemaillogin.getText().toString();
        String etpassword = etpasswordlogin.getText().toString();

        if (etemail.isEmpty() || etpassword.isEmpty()){
            String message = "All inputs required";
            Toast.makeText(LoginPenyewa.this, message, Toast.LENGTH_SHORT).show();
        }else {
            Login login = new Login();
            login.setEmail(etemaillogin.getText().toString());
            login.setPassword(etpasswordlogin.getText().toString());

            loginPenyewa(login);

        }

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

    public void loginPenyewa(Login login){
        Call<GetLogin> loginCall = ApiClientUser.getApi().loginUser(login);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    Login login = (Login) response.body().getData();
                    startActivity(new Intent(LoginPenyewa.this, MainActivity.class).putExtra("data", login));
                    finish();
                }else {
                    String message = "Unable to register, please try again";
                    Toast.makeText(LoginPenyewa.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginPenyewa.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}