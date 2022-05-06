package com.isilsubasi.gunlukburclarapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.isilsubasi.gunlukburclarapp.R;
import com.isilsubasi.gunlukburclarapp.model.BurcModel;
import com.isilsubasi.gunlukburclarapp.util.Constans;
import com.isilsubasi.gunlukburclarapp.util.GlideUtil;
import com.isilsubasi.gunlukburclarapp.util.ObjectUtils;

public class BurcDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    WebView webViewGunluk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burc_detay);

        init();

    }


    private void init(){
        String tasinanBurcString=getIntent().getStringExtra(Constans.TIKLANAN_BURC);

        BurcModel burcModel= ObjectUtils.jsonStringToBurc(tasinanBurcString);

        imgKapak=findViewById(R.id.imgKapak);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtDetay=findViewById(R.id.txtDetay);
        webViewGunluk=findViewById(R.id.webViewGunluk);


        txtBaslik.setText(burcModel.getBurcAdi());
        txtDetay.setText(burcModel.getAciklama());

        GlideUtil.resmiIndiripGoster(getApplicationContext(), burcModel.getKapakFotoUrl(),imgKapak);

        webViewGunluk.loadUrl(burcModel.getGunlukYorumUrl());

    }



}