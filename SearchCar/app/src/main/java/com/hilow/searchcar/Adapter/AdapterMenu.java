package com.hilow.searchcar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hilow.searchcar.Activity.Admin.UpdateMobil;
import com.hilow.searchcar.Activity.User.DetailMobil;
import com.hilow.searchcar.Model.Menu;
import com.hilow.searchcar.R;

import java.util.List;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ViewHolder> {

    private Context context;
    private List<Menu> MenuList;

    public AdapterMenu(List<Menu> menuList) {
        MenuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mobil, parent, false);
        return new AdapterMenu.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMenu.ViewHolder holder, int position ) {

        holder.tvJenisList.setText(MenuList.get(position).getJenis());
        holder.tvMerkMobil.setText(MenuList.get(position).getMenu());
        holder.tvHargaSewa.setText(String.valueOf(MenuList.get(position).getHarga()));
         Glide.with(holder.itemView.getContext())
                .load("" + MenuList.get(position).getGambar())
                .into(holder.ivGambarMobil);
         holder.tvOption.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 PopupMenu popup = new PopupMenu(view.getContext(), holder.tvOption);
                 popup.inflate(R.menu.optionmenu);
                 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem menuItem) {
                         switch (menuItem.getItemId()) {
                             case R.id.ubah:
                                 Intent intent = new Intent(view.getContext(), UpdateMobil.class);
                                 view.getContext().startActivity(intent);
                                 return true;

                             case R.id.hapus:
                                 Toast.makeText(view.getContext(), "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                                 return true;

                             default:
                                 return false;
                         }
                     }
                 });
                 popup.show();
             }
         });


//        holder.clAdmin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(view.getContext(), DetailMobil.class);
//                intent.putExtra("desc", MenuList.get(position).getMenu());
//                intent.putExtra("menu", MenuList.get(position).getCreatedAt());
//                intent.putExtra("gambar", MenuList.get(position).getGambar());
//
//                view.getContext().startActivity(intent);
//            }
//        });
//        holder.clAdmin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), DetailMobil.class);
//                intent.putExtra("desc", MenuList.get(position).getMenu());
//                intent.putExtra("menu", MenuList.get(position).getCreatedAt());
//                intent.putExtra("gambar", MenuList.get(position).getGambar());
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return MenuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ConstraintLayout clAdmin;
        TextView tvJenisList,tvMerkMobil, tvHargaSewa, tvOption;
        Button btnSewa;
        ImageView ivGambarMobil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisList = itemView.findViewById(R.id.tvJenisList);
            tvMerkMobil = itemView.findViewById(R.id.tvMerkMobil);
            tvHargaSewa = itemView.findViewById(R.id.tvHargaSewa);
            ivGambarMobil = itemView.findViewById(R.id.ivMobil);
            tvOption = itemView.findViewById(R.id.tvOption);
//            clAdmin = itemView.findViewById(R.id.clDetail);
//            btnSewa = itemView.findViewById(R.id.btnSewa);
//            btnSewa.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                Intent intent = new Intent(context, DetailSewa.class);
//                 context.startActivity(intent);
//               }
//          });

        }

//        @Override
//        public void onClick(View view) {
//            showtvOption(view);
//        }
//
//        private void showtvOption(View view) {
//            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
//            popupMenu.inflate(R.menu.optionmenu);
//            popupMenu.setOnMenuItemClickListener(this);
//            popupMenu.show();
//        }
//
//        @Override
//        public boolean onMenuItemClick(MenuItem menuItem) {
//            switch (menuItem.getItemId()){
//                case R.id.ubah:
//                    Intent intent = new Intent(menuItem.getIntent(UpdateMobil.class) );
//                    getCstartActivity(intent);
//                    return true;
//
//                case R.id.hapus:
////                    Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(AdapterMenu, "ya", Toast.LENGTH_SHORT).show();
//                    return true;
//
//                default:
//                    return false;
//            }
        }
    }

