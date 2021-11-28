package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hilow.searchcar.R;

public class KodePembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kode_pembayaran);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(this, DetailPembayaran.class);
//        startActivity(intent);

        super.onBackPressed();
    }

    public void btnSelesai(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}