package com.isilsubasi.gunlukburclarapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isilsubasi.gunlukburclarapp.model.BurcModel;
import com.isilsubasi.gunlukburclarapp.R;
import com.isilsubasi.gunlukburclarapp.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

public class BurcAdapter extends RecyclerView.Adapter<BurcViewHolder> {

    List<BurcModel> burclar =new ArrayList<>();
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }





    public BurcAdapter(List<BurcModel> burclar, Context context, OnItemClickListener listener) {
        this.burclar = burclar;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public BurcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_burc,parent,false);
        return new BurcViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BurcViewHolder viewHolder, int position) {

        viewHolder.txtBurcAdi.setText(burclar.get(position).getBurcAdi());
        viewHolder.txtTarih.setText(burclar.get(position).getBurcTarihi());
        GlideUtil.resmiIndiripGoster(context, burclar.get(position).getLogoUrl(),viewHolder.imgBurcLogo);

    }

    @Override
    public int getItemCount() {
        return burclar.size();
    }
}
