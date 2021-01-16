package com.h5190048.rabia_kose_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;



public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
