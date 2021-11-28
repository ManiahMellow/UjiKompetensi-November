package com.hilow.searchcar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hilow.searchcar.Activity.User.DetailMobil;
import com.hilow.searchcar.Model.Menu;
import com.hilow.searchcar.R;

import java.util.List;

public class AdapterMobil extends RecyclerView.Adapter<AdapterMobil.ViewHolder> {

    private Context context;
    private List<Menu> MenuList;

    public AdapterMobil( List<Menu> menuList) {
        MenuList = menuList;
    }

    @NonNull
    @Override
    public AdapterMobil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_sewa, parent, false);
        return new AdapterMobil.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMobil.ViewHolder holder, int position) {

        holder.tvJenisDetail.setText(MenuList.get(position).getJenis());
        holder.tvMerkDetail.setText(MenuList.get(position).getMenu());
        holder.tvHargaDetail.setText(String.valueOf(MenuList.get(position).getHarga()));
        Glide.with(holder.itemView.getContext())
                .load("" + MenuList.get(position).getGambar())
                .into(holder.ivDetail);
        holder.clDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMobil.class);
                intent.putExtra("jenis", MenuList.get(position).getJenis());
                intent.putExtra("harga", MenuList.get(position).getHarga());
                intent.putExtra("menu", MenuList.get(position).getMenu());
                intent.putExtra("kelebihan", MenuList.get(position).getKelebihan());
                intent.putExtra("kekurangan", MenuList.get(position).getKekurangan());
                intent.putExtra("gambar", MenuList.get(position).getGambar());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MenuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout clDetail;
        TextView tvJenisDetail, tvMerkDetail, tvHargaDetail, tvIsiKelebihan, tvIsiKekurangan;
        ImageView ivDetail;

        @SuppressLint("ResourceType")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisDetail = itemView.findViewById(R.id.tvJenisDetail);
            tvMerkDetail = itemView.findViewById(R.id.tvMerkDetail);
            tvHargaDetail = itemView.findViewById(R.id.tvHargaDetail);
            ivDetail = itemView.findViewById(R.id.ivDetail);
            clDetail = itemView.findViewById(R.id.clDetail);
        }
    }
}
