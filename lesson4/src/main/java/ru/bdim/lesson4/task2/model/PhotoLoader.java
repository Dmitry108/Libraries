package ru.bdim.lesson4.task2.model;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotoLoader {
    public static void setPhoto(Context context, String url, ImageView img){
        Picasso.with(context)
               .load(url)
               .into(img);
    }
}
