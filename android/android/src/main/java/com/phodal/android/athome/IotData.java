package com.phodal.android.athome;

/**
 * Created by fdhuang on 5/24/14.
 */
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by phodal on 13-12-26.
 */
public class IotData {

    public GsonBuilder gsonb = new GsonBuilder();
    public Gson gson = gsonb.create();
    public JSONObject jObj = null;

    typePhoData phoData = gson.fromJson(jObj.toString(),
            typePhoData.class);

    public int get_id(){
        return phoData.id;
    }

    public double get_sensors1(){
        return phoData.sensors1;
    }

    public double get_sensors2(){
        return phoData.sensors2;
    }

    public double get_temperature(){
        return phoData.temperature;
    }

    public int get_led1(){
        return phoData.led1;
    }

    public class typePhoData{
        public int led1;
        public double temperature;
        public double sensors1;
        public double sensors2;
        public int    id;
    }

}