package com.example.glavatskikh.dtlboxdemoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public JSONObject serverResponse() {
        try {
            return new JSONObject(getString(R.string.response));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



}
