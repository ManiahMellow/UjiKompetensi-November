package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.R;

public class ProfilUser extends AppCompatActivity {

    TextView tvNamaProfil, tvAlamatProfil, tvNoTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);

        Intent mintent = getIntent();
        tvNamaProfil = findViewById(R.id.tvnamaprofil);
        tvAlamatProfil = findViewById(R.id.tvalamatprofil);
        tvNoTelp = findViewById(R.id.tvnotelp);

        tvNamaProfil.setText(mintent.getStringExtra("nama"));
        tvAlamatProfil.setText(mintent.getStringExtra("alamat"));
        tvNoTelp.setText(mintent.getStringExtra("telp"));
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

            Intent intent = new Intent(ProfilUser.this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnLogout(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.logoapk)
                .setTitle("Logout Aplikasi")
                .setMessage("Apakah anda yakin ingin logout dari posisi user?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ProfilUser.this, LoginUser.class);
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