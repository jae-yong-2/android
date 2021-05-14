package com.example.houseapp;

import android.net.Uri;

public class ImageFile {
    private static String[] image={                     //이미지 저장 장소
        Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.img1).toString(),
        Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.img2).toString(),
        Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.img1).toString(),
        Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.img2).toString(),
        Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.img1).toString(),
    };



    static String[] getImage(){
        return image;
    }
}
