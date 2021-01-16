package com.h5190048.rabia_kose_final.util;

import com.google.gson.Gson;
import com.h5190048.rabia_kose_final.model.AgacModel;


public class ObjectUtil {
    public  static String agacToJsonString(AgacModel agacModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(agacModel);
    }
    public  static AgacModel jsonStringToAgac(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString, AgacModel.class);
    }
}