package com.hilow.searchcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.hilow.searchcar.Activity.Admin.DaftarAdmin;
import com.hilow.searchcar.Activity.Admin.LoginAdmin;
import com.hilow.searchcar.Activity.User.DaftarUser;
import com.hilow.searchcar.Activity.User.LoginPenyewa;

public class LoginUser extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {

    Button button, btndaftar, btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        button = findViewById(R.id.btndropdown);
        btndaftar = findViewById(R.id.daftar);
        btnlogin = findViewById(R.id.login);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), button);
                dropDownMenu.getMenuInflater().inflate(R.menu.dropdown_menu, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.admin :
                                button.setText("Admin");
                             break;

                            case R.id.penyewa:
                                button.setText("Penyewa");
                            break;
                        }
                        return false;
                    }
                });
                dropDownMenu.show();
            }
        });

    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    public void btnDaftar(View view) {
        if (button.getText()=="Admin"){
            Intent intent = new Intent(this, DaftarAdmin.class);
            startActivity(intent);
        }

        if (button.getText()=="Penyewa"){
            Intent intent = new Intent(this, DaftarUser.class);
            startActivity(intent);
        }
    }

    public void btnLogin(View view) {
        if (button.getText()=="Admin"){
            Intent intent = new Intent(this, LoginAdmin.class);
            startActivity(intent);
        }

        if (button.getText()=="Penyewa"){
            Intent intent = new Intent(this, LoginPenyewa.class);
            startActivity(intent);
        }

    }
}