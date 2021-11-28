package com.hilow.searchcar.Adapter.User;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hilow.searchcar.Model.DetailMobil;
import com.hilow.searchcar.Activity.User.DetailSewa;
import com.hilow.searchcar.Model.Mobil;
import com.hilow.searchcar.R;

import java.util.List;

public class DetailMobilAdapter extends RecyclerView.Adapter<DetailMobilAdapter.ViewHolder> {

    private Context context;
    private List<Mobil> mobilList;

    public DetailMobilAdapter(Context context, List<Mobil> mobilList) {
        this.context = context;
        this.mobilList = mobilList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail_sewa, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Mobil mobil = mobilList.get(i);

        viewHolder.tvJenisDetail.setText(mobil.getJenislist());
        viewHolder.tvMerkDetail.setText(mobil.getMerkmobil());
        viewHolder.tvHargaDetail.setText(mobil.getHargasewa());
        Glide.with(context)
                .load(mobil.getGambarmobil())
                .placeholder(R.drawable.logo)
                .into(viewHolder.ivGambarDetail);
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvMerkDetail, tvHargaDetail, tvJenisDetail;
        ImageView ivGambarDetail;
        Button btnSewa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJenisDetail = itemView.findViewById(R.id.tvJenisDetail);
            tvMerkDetail = itemView.findViewById(R.id.tvMerkDetail);
            tvHargaDetail = itemView.findViewById(R.id.tvHargaDetail);
            ivGambarDetail = itemView.findViewById(R.id.ivDetail);
//            btnSewa = itemView.findViewById(R.id.btnSewa);
//            btnSewa.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, DetailSewa.class);
//                    context.startActivity(intent);
//                }
//            });


        }
    }
}
