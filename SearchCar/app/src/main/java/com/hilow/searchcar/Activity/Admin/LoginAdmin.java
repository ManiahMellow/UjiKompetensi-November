package com.hilow.searchcar.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hilow.searchcar.Activity.User.LoginPenyewa;
import com.hilow.searchcar.Activity.User.MainActivity;
import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.GetLogin;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClientUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAdmin extends AppCompatActivity {

    EditText etemailadmin, etpasswordadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        etemailadmin = findViewById(R.id.etemailadmin);
        etpasswordadmin = findViewById(R.id.etpasswordadmin);
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

            Intent intent = new Intent(LoginAdmin.this, LoginUser.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnLogin(View view) {

        String etemaildaftar = etemailadmin.getText().toString();
        String etpassworddaftar = etpasswordadmin.getText().toString();

        if (etemaildaftar.isEmpty() || etpassworddaftar.isEmpty()){
            String message = "All inputs required";
            Toast.makeText(LoginAdmin.this, message, Toast.LENGTH_SHORT).show();
        }else {
            Login login = new Login();
            login.setEmail(etemailadmin.getText().toString());
            login.setPassword(etpasswordadmin.getText().toString());

            loginAdmin(login);

        }

//        Intent intent = new Intent(this, HomeAdmin.class);
//        startActivity(intent);
    }

    public void loginAdmin(Login login){
        Call<GetLogin> loginCall = ApiClientUser.getApi().loginUser(login);
        loginCall.enqueue(new Callback<GetLogin>() {
            @Override
            public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                if (response.isSuccessful()){
                    Login login = (Login) response.body().getData();
                    startActivity(new Intent(LoginAdmin.this, HomeAdmin.class).putExtra("data", login));
                    finish();
                }else {
                    String message = "Unable to register, please try again";
                    Toast.makeText(LoginAdmin.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetLogin> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginAdmin.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}