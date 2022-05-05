package com.isilsubasi.gunlukburclarapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isilsubasi.gunlukburclarapp.R;

public class BurcViewHolder extends RecyclerView.ViewHolder {

    ImageView imgBurcLogo;
    TextView txtBurcAdi;
    TextView txtTarih;


    public BurcViewHolder(@NonNull View itemView) {
        super(itemView);

        imgBurcLogo=itemView.findViewById(R.id.imgBurcLogo);
        txtBurcAdi=itemView.findViewById(R.id.txtBurcAdi);
        txtTarih=itemView.findViewById(R.id.txtTarih);



    }
}
