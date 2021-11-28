package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;
import com.hilow.searchcar.R;

import java.util.Calendar;

public class DetailSewa extends AppCompatActivity {

    Spinner spinner;
    TextInputLayout sewaLama;
    EditText etSewa, etKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sewa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        load();
    }

    public void load(){
        spinner = findViewById(R.id.listJenisMobil);
        etSewa = findViewById(R.id.etsewa);
        etKembali = findViewById(R.id.etkembali);
        sewaLama = findViewById(R.id.sewalama);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        super.onBackPressed();
    }

    public void tglSewa(View view) {
        Calendar cal = Calendar.getInstance();

        int tgl = cal.get(Calendar.DAY_OF_MONTH);
        int bln = cal.get(Calendar.MONTH);
        int thn = cal.get(Calendar.YEAR);

        DatePickerDialog dtp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                etSewa.setText(tgl + " - " + (bln + 1) + " - " + thn);
            }
        }, thn, bln, tgl);

        dtp.show();

    }

    public void tglKembali(View view) {
        Calendar cal = Calendar.getInstance();

        int tgl = cal.get(Calendar.DAY_OF_MONTH);
        int bln = cal.get(Calendar.MONTH);
        int thn = cal.get(Calendar.YEAR);

        DatePickerDialog dtp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                etKembali.setText(tgl + " - " + (bln + 1) + " - " + thn);
            }
        }, thn, bln, tgl);

        dtp.show();
    }

    public void btnSewa(View view) {
        Intent intent = new Intent(this, DetailPembayaran.class);
        startActivity(intent);
    }


}