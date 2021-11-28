package com.hilow.searchcar.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hilow.searchcar.Activity.User.DaftarUser;
import com.hilow.searchcar.Activity.User.LoginPenyewa;
import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.GetRegister;
import com.hilow.searchcar.Model.Register;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClientUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarAdmin extends AppCompatActivity {

    EditText etnamadaftar, etemaildaftar, etalamatdaftar, etpassworddaftar, ettelpdaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_admin);

        etnamadaftar = findViewById(R.id.etnamadaftar);
        etalamatdaftar = findViewById(R.id.etalamatdaftar);
        ettelpdaftar = findViewById(R.id.ettelpdaftar);
        etemaildaftar = findViewById(R.id.etemaildaftar);
        etpassworddaftar = findViewById(R.id.etpassworddaftar);

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

            Intent intent = new Intent(DaftarAdmin.this, LoginUser.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnRegister(View view) {

        String nama = etnamadaftar.getText().toString();
        String alamat = etalamatdaftar.getText().toString();
        String telp = ettelpdaftar.getText().toString();
        String email = etemaildaftar.getText().toString();
        String password = etpassworddaftar.getText().toString();

        if(nama.isEmpty() || alamat.isEmpty() || telp.isEmpty() || email.isEmpty() || password.isEmpty()){
            String message = "All inputs required";
            Toast.makeText(DaftarAdmin.this, message, Toast.LENGTH_SHORT).show();
        }else {
            Register register = new Register();
            register.setNama(etnamadaftar.getText().toString());
            register.setAlamat(etalamatdaftar.getText().toString());
            register.setTelp(ettelpdaftar.getText().toString());
            register.setEmail(etemaildaftar.getText().toString());
            register.setPassword(etpassworddaftar.getText().toString());

            registerAdmin(register);
        }


//        Intent intent = new Intent(this, LoginAdmin.class);
//        startActivity(intent);
    }

    public void registerAdmin(Register register){
        Call<GetRegister> registerCall = ApiClientUser.getApi().daftarUser(register);
        registerCall.enqueue(new Callback<GetRegister>() {
            @Override
            public void onResponse(Call<GetRegister> call, Response<GetRegister> response) {
                if (response.isSuccessful()){
                    String message = "Register Succes";
                    Toast.makeText(DaftarAdmin.this, message, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(DaftarAdmin.this, LoginAdmin.class));
                    finish();
                }else {
                    String message = "Unable to register, please try again";
                    Toast.makeText(DaftarAdmin.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetRegister> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DaftarAdmin.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}