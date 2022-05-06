package com.isilsubasi.gunlukburclarapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.isilsubasi.gunlukburclarapp.R;
import com.isilsubasi.gunlukburclarapp.adapter.BurcAdapter;
import com.isilsubasi.gunlukburclarapp.model.BurcModel;
import com.isilsubasi.gunlukburclarapp.network.Service;
import com.isilsubasi.gunlukburclarapp.util.Constans;
import com.isilsubasi.gunlukburclarapp.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();

    }
    private void init(){
        burclariGetir();

    }




    void burclariGetir(){
        new Service().getServiceApi().burclariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BurcModel>>() {
                    List<BurcModel> burclar=new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.e("RETROFIT","onSubscribe");
                    }
                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","ERROR :" + e.getLocalizedMessage());

                    }
                    @Override
                    public void onNext(List<BurcModel> burcModelList) {
                        Log.e("RETROFIT","onNext");
                        burclar=burcModelList;
                    }
                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete");

                        if(burclar.size()>0) {

                            Log.e("ogretmen", String.valueOf(burclar));
                            initRecyclerView(burclar);

                        }
                    }
                });

    }


    private void initRecyclerView(List<BurcModel> burcList){
        recyclerView=findViewById(R.id.rcvBurclar);

        BurcAdapter burcAdapter=new BurcAdapter(burcList, getApplicationContext(), new BurcAdapter.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                BurcModel tiklananBurc = burcList.get(position);
                Toast.makeText(getApplicationContext(), "Tıklanan Adi" + tiklananBurc.getBurcAdi(), Toast.LENGTH_SHORT).show();
                openScreen(tiklananBurc);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(burcAdapter);

    }


    private void openScreen(BurcModel tiklananBurc){
        Intent intent=new Intent(getApplicationContext(), BurcDetayActivity.class);
        String tiklananBurcString= ObjectUtils.burcToJsonString(tiklananBurc);
        intent.putExtra(Constans.TIKLANAN_BURC,tiklananBurcString);
        startActivity(intent);

    }




}