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


    public BurcViewHolder(@NonNull View cardView, BurcAdapter.OnItemClickListener listener) {
        super(cardView);

        imgBurcLogo=cardView.findViewById(R.id.imgBurcLogo);
        txtBurcAdi=cardView.findViewById(R.id.txtBurcAdi);
        txtTarih=cardView.findViewById(R.id.txtTarih);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });



    }
}
