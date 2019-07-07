package com.codeChamp.ExaminationResults;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.Iterator;

public class Services implements ResultsSupplier {

    //private Results results;
//    private Gson gson;
//    private JsonObject jsonObject;



    public JSONObject sendget(String index) throws  Exception{

        String url = "https://doenets.lk/result/service/AlResult/" + index;
        System.out.println(url + "url");



        URL obj = new URL(url);
//        InputStream is = obj.openStream();
//        Results result = new Gson().fromJson(is.toString(),Results.class);
//        System.out.println(result);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responsecode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        StringBuilder sb = new StringBuilder();
        sb.append(response);

        //results = gson.fromJson(response.toString(),Results.class);
        //assert()
        JSONObject myObject = new JSONObject(sb.toString());
//        Iterator<?> keys = myObject.keys();
//
//        while( keys.hasNext() ){
//            String key = (String)keys.next();
//            System.out.println(key+"fd");
//        }

       // Results result = new Gson().fromJson(myObject,Results.class);
        //System.out.println(myObject);
        //System.out.println(response);


        return myObject;



    }

    @Override
    public Results get() {
        return null;
    }
}
