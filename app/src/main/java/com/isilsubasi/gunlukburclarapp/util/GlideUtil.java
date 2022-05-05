package com.isilsubasi.gunlukburclarapp.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {

    public static void resmiIndiripGoster(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .fitCenter()
                //.error(R.drawable.errorResim)
                .into(imageView);


    }


}
