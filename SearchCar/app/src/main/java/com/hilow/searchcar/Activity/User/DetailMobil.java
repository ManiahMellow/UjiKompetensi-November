package com.hilow.searchcar.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hilow.searchcar.LoginUser;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.R;

public class DetailMobil extends AppCompatActivity {
    ImageView imgdetail;
    Button btnSewa;
    TextView jenislist, merkmobil, hargadetail, isikelebihan, isikekurangan;
    Login getLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mobil);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent mintent = getIntent();
        imgdetail = findViewById(R.id.MobilDetail);
        jenislist = findViewById(R.id.JenisDetail);
        merkmobil = findViewById(R.id.MerkDetail);
        hargadetail = findViewById(R.id.tvHargaMobil);
        isikelebihan = findViewById(R.id.isiKelebihan);
        isikekurangan = findViewById(R.id.isiKekurangan);


        jenislist.setText(mintent.getStringExtra("jenis"));
        merkmobil.setText(mintent.getStringExtra("menu"));
        hargadetail.setText(Integer.toString(mintent.getIntExtra("harga", 0)));
        isikelebihan.setText(mintent.getStringExtra("kelebihan"));
        isikekurangan.setText(mintent.getStringExtra("kekurangan"));
        Glide.with(DetailMobil.this)
                .load("" + mintent.getStringExtra("gambar"))
                .apply(new RequestOptions().override(550, 700))
                .into(imgdetail);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void btnSewa(View view) {


        Intent nwIntent = (MainActivity.ma.getIntent());

        if (nwIntent.getExtras() == null){
            startActivity(new Intent(view.getContext(), LoginUser.class));
        }else {
            Intent intent = new Intent(this, DetailSewa.class);
            startActivity(intent);
        }

   }
}