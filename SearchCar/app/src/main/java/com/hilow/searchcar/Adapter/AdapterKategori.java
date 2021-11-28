package com.hilow.searchcar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hilow.searchcar.Activity.Admin.UpdateMobil;
import com.hilow.searchcar.Adapter.Admin.ListMobilAdapter;
import com.hilow.searchcar.Model.Kategori;
import com.hilow.searchcar.Model.Mobil;
import com.hilow.searchcar.R;

import java.util.List;

public class AdapterKategori extends RecyclerView.Adapter<AdapterKategori.ViewHolder> {

    private Context context;
    private List<Kategori> KategoriList;

    public AdapterKategori(List<Kategori> kategoriList) {
        KategoriList = kategoriList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mobil, parent, false);
        return new AdapterKategori.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvJenisList.setText(KategoriList.get(position).getKategori());
        holder.tvMerkMobil.setText(KategoriList.get(position).getKeterangan());

//        viewHolder.tvMerkMobil.setText(mobil.getMerkmobil());
//        viewHolder.tvHargaSewa.setText(mobil.getHargasewa());
//        Glide.with(context)
//                .load(mobil.getGambarmobil())
//                .placeholder(R.drawable.logo)
//                .into(viewHolder.ivGambarMobil);
    }

    @Override
    public int getItemCount() {
        return KategoriList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        TextView tvJenisList,tvMerkMobil, tvHargaSewa, tvOption;
        ImageView ivGambarMobil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisList = itemView.findViewById(R.id.tvJenisList);
            tvMerkMobil = itemView.findViewById(R.id.tvMerkMobil);
            tvHargaSewa = itemView.findViewById(R.id.tvHargaSewa);
            tvOption = itemView.findViewById(R.id.tvOption);
            tvOption.setOnClickListener(this);
            ivGambarMobil = itemView.findViewById(R.id.ivMobil);
        }


        @Override
        public void onClick(View view) {
            showtvOption(view);
        }

        private void showtvOption(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.optionmenu);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.ubah:
                    Intent intent = new Intent(context, UpdateMobil.class);
                    context.startActivity(intent);
                    return true;

                case R.id.hapus:
                    Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return false;
            }

        }
    }
}
