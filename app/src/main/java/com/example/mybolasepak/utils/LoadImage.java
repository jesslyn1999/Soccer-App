package com.example.mybolasepak.utils;

import android.graphics.drawable.Drawable;

import java.io.InputStream;
import java.net.URL;

public class LoadImage {
    public static Drawable loadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            return Drawable.createFromStream(is, "src name");
        } catch (Exception e) {
            return null;
        }
    }
}
