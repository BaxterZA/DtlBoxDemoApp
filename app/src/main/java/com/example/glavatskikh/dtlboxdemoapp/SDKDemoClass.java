package com.example.glavatskikh.dtlboxdemoapp;

import android.graphics.Bitmap;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.graphics.BitmapFactory.decodeStream;

public class SDKDemoClass {

    public NativeAd getAd(JsonObject json) {
        if (json == null)
            return null;
        final JsonObject jsonObject = json.get("ad").getAsJsonObject();
        return new NativeAd() {
            @Override
            public String getTitle() {
                return jsonObject.get("title").getAsString();
            }

            @Override
            public String getCallToAction() {
                return jsonObject.get("click_url").getAsString();
            }

            @Override
            public float getRating() {
                return jsonObject.get("rating").getAsFloat();
            }

            @Override
            public String getDescription() {
                return jsonObject.get("description").getAsString();
            }

            @Override
            public Bitmap getImage() {
                return getBitmapFromURL(getImageUrl());
            }

            @Override
            public Bitmap getIcon() {
                return getBitmapFromURL(getIconUrl());
            }

            @Override
            public String getImageUrl() {
                return jsonObject.get("image").getAsString();
            }

            @Override
            public String getIconUrl() {
                return jsonObject.get("icon").getAsString();
            }

            @Override
            public boolean containsVideo() {
                String s = jsonObject.get("video_url").getAsString();
                return (s != null);
            }
        };
    }

    private Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
