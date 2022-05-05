package com.isilsubasi.gunlukburclarapp.network;

import com.isilsubasi.gunlukburclarapp.model.BurcModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //https://raw.githubusercontent.com/isilsubasi/GunlukBurclar/main/
    //https://raw.githubusercontent.com/isilsubasi/OgretmenListele/main/
    @GET("GunlukBurclarApi.json")
    Observable<List<BurcModel>> burclariGetir();



}
