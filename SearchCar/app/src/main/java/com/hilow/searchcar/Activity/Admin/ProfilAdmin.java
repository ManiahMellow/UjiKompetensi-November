package com.hilow.searchcar.Activity.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.R;

public class ProfilAdmin extends AppCompatActivity {

    TextView tvnamaprofiladmin, tvalamatprofiladmin, tvnotelpadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_admin);

        Intent mintent = getIntent();
        tvnamaprofiladmin = findViewById(R.id.tvnamaprofiladmin);
        tvalamatprofiladmin = findViewById(R.id.tvalamatprofiladmin);
        tvnotelpadmin = findViewById(R.id.tvnotelpadmin);

        tvnamaprofiladmin.setText(mintent.getStringExtra("nama"));
        tvalamatprofiladmin.setText(mintent.getStringExtra("alamat"));
        tvnotelpadmin.setText(mintent.getStringExtra("telp"));

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

            Intent intent = new Intent(ProfilAdmin.this, HomeAdmin.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnLogout(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.logoapk)
                .setTitle("Logout Aplikasi")
                .setMessage("Apakah anda yakin ingin logout dari posisi admin?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ProfilAdmin.this, LoginUser.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}