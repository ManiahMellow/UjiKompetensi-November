package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.GetRegister;
import com.hilow.searchcar.Model.Register;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClient;
import com.hilow.searchcar.Rest.ApiClientUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarUser extends AppCompatActivity {

    EditText etnama, etalamat, ettelp, etemail, etpassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_user);

        etnama = findViewById(R.id.etnama);
        etalamat = findViewById(R.id.etalamat);
        ettelp = findViewById(R.id.ettelp);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
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

            Intent intent = new Intent(DaftarUser.this, LoginUser.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnDaftar(View view) {

        String nama = etnama.getText().toString();
        String alamat = etalamat.getText().toString();
        String telp = ettelp.getText().toString();
        String email = etemail.getText().toString();
        String pasword = etpassword.getText().toString();

        if (email.isEmpty() || !email.contains("@gmail.com")){
//            showError(etemail, "Alamat email tidak valid");
            Toast.makeText(this, "Alamat email tidak valid", Toast.LENGTH_SHORT).show();
        }else if(nama.isEmpty() || alamat.isEmpty() || telp.isEmpty() || pasword.isEmpty()){
            String message = "Setiap data harus diisi!";
            Toast.makeText(DaftarUser.this, message, Toast.LENGTH_SHORT).show();
        } else {
            Register register = new Register();
            register.setNama(etnama.getText().toString());
            register.setAlamat(etalamat.getText().toString());
            register.setTelp(ettelp.getText().toString());
            register.setEmail(etemail.getText().toString());
            register.setPassword(etpassword.getText().toString());

            registerPenyewa(register);
        }

    }



    private void showError(EditText input, String a) {
        input.setError(a);
        input.requestFocus();
    }

    public void  registerPenyewa(Register register){
        Call<GetRegister> registerCall = ApiClientUser.getApi().daftarUser(register);
        registerCall.enqueue(new Callback<GetRegister>() {
            @Override
            public void onResponse(Call<GetRegister> call, Response<GetRegister> response) {
                if (response.isSuccessful()){
                    String message = "Register Succes";
                    Toast.makeText(DaftarUser.this, message, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(DaftarUser.this, LoginPenyewa.class));
                    finish();

                }else {
                    String message = "Unable to register, please try again";
                    Toast.makeText(DaftarUser.this, message, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GetRegister> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DaftarUser.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}