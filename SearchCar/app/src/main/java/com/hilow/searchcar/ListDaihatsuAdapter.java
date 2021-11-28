package com.hilow.searchcar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListDaihatsuAdapter extends RecyclerView.Adapter<ListDaihatsuAdapter.ViewHolder> {

    private Context context;
    private List<Daihatsu> daihatsuList;

    public ListDaihatsuAdapter(Context context, List<Daihatsu> daihatsuList) {
        this.context = context;
        this.daihatsuList = daihatsuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_daihatsu, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Daihatsu daihatsu = daihatsuList.get(i);

        viewHolder.btnListDaihatsu.setText(daihatsu.getBtndaihatsu());
    }

    @Override
    public int getItemCount() {
        return daihatsuList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        Button btnListDaihatsu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnListDaihatsu = itemView.findViewById(R.id.btnListDaihatsu);
            btnListDaihatsu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                        switch (getAdapterPosition()){
                            case 0 :
                                intent = new Intent(context, DaihatsuAyla.class);
                                break;

                            case 1 :
                                intent = new Intent(context, DaihatsuTerios.class);
                                break;

                            case 2 :
                                intent = new Intent(context, DaihatsuSigra.class);
                                break;

                            case 3 :
                                intent = new Intent(context, DaihatsuRocky.class);
                                break;
                        }
                        context.startActivity(intent);
                }
            });

        }
    }
}
