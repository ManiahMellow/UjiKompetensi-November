package com.hilow.searchcar.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hilow.searchcar.Adapter.AdapterMenu;
import com.hilow.searchcar.Adapter.Admin.ListMobilAdapter;
import com.hilow.searchcar.Model.GetKategori;
import com.hilow.searchcar.Model.GetMenu;
import com.hilow.searchcar.Model.Kategori;
import com.hilow.searchcar.Model.Login;
import com.hilow.searchcar.Model.Mobil;
import com.hilow.searchcar.R;
import com.hilow.searchcar.Rest.ApiClient;
import com.hilow.searchcar.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdmin extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HomeAdmin ma;
    Login getLogin;
    ListMobilAdapter adapter;
    List<Mobil> mobilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        Intent intent = getIntent();
        if (intent.getExtras() != null){

            getLogin =  (Login) intent.getSerializableExtra("data");
            Log.e("TAG", "===>" + getLogin.getEmail());

        }


        mRecyclerView = (RecyclerView) findViewById(R.id.rcvListMobil);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();

//        load();
//        isiData();
    }

    public void refresh() {
//        Call<GetKategori> kategoriCall = mApiInterface.getKategori();
//        kategoriCall.enqueue(new Callback<GetKategori>() {
//            @Override
//            public void onResponse(Call<GetKategori> call, Response<GetKategori> response) {
//                List<Kategori> KategoriList = response.body().getData();
//                Log.d("Retrofit Get", "Jumlah data Kontak: " +
//                        String.valueOf(KategoriList.size()));
//                mAdapter = new AdapterKategori(KategoriList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<GetKategori> call, Throwable t) {
//                Log.e("Retrofit Get", t.toString());
//            }

        Call<GetMenu> menuCall = mApiInterface.getMenu();
        menuCall.enqueue(new Callback<GetMenu>() {

            @Override
            public void onResponse(Call<GetMenu> call, Response<GetMenu> response) {
                List<com.hilow.searchcar.Model.Menu> MenuList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(MenuList.size()));
                mAdapter = new AdapterMenu(MenuList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMenu> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profil_menu, menu);
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.iconProfil:
                if (getLogin != null){
                    Intent intent = new Intent(HomeAdmin.this, ProfilAdmin.class);
                    intent.putExtra("nama", getLogin.getNama());
                    intent.putExtra("alamat", getLogin.getAlamat());
                    intent.putExtra("telp", getLogin.getTelp());

                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
                }
                return true;


            case  R.id.iconHistory:
                Intent intent = new Intent(HomeAdmin.this, HistoryAdmin.class);
                startActivity(intent);

                return true;
        }


//        int id = item.getItemId();
//
//        if (id == R.id.iconProfil) {
//
//           Intent intent = new Intent(HomeAdmin.this, ProfilAdmin.class);
//           startActivity(intent);
//        }
//
//        if (id == R.id.iconHistory){
//           Intent intent = new Intent(HomeAdmin.this, HistoryAdmin.class);
//           startActivity(intent);
//        }
//
        return super.onOptionsItemSelected(item);
    }

    public void btnTambah(View view) {
        Intent intent = new Intent(this, TambahMobil.class);
        startActivity(intent);
    }

//    public void load(){
//        recyclerView = findViewById(R.id.rcvListMobil);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    public void isiData(){
//        mobilList = new ArrayList<Mobil>();
//
//        mobilList.add(new Mobil("Toyota", "Avanza", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Kijang Innova", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Kijang Innova", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Kijang Innova", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Kijang Innova", "250000", R.drawable.avanza));
//        mobilList.add(new Mobil("Toyota", "Kijang Innova", "250000", R.drawable.avanza));
//
//        adapter = new ListMobilAdapter(this, mobilList);
//        recyclerView.setAdapter(adapter);
//    }

}