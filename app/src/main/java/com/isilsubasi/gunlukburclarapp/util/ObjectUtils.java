package com.isilsubasi.gunlukburclarapp.util;

import com.google.gson.Gson;
import com.isilsubasi.gunlukburclarapp.model.BurcModel;

public class ObjectUtils {

    //Objeyi Stringe dönüştürmek
    public static String burcToJsonString(BurcModel burcModel){
        Gson gson = new Gson();
        return gson.toJson(burcModel);
    }

    //Stringi objeye dönüştürmek
    public static BurcModel jsonStringToBurc(String jsonString){

        Gson gson = new Gson();
        return gson.fromJson(jsonString,BurcModel.class);
    }

}
