package com.codeChamp.ExaminationResults;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.ws.Service;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SaveAsText {

    Map<Double, JSONObject> dictionary = new HashMap<Double, JSONObject>();


    public void generateResultSheets(String index) throws  Exception{
        Services services = new Services();
        JSONObject results = services.sendget(index);
        System.out.println(index);


        if (results.get("year").toString() == "null") {

            dictionary.put(Double.MAX_VALUE,results);

        }else{
            JSONArray data = results.getJSONArray("studentInfo");
            JSONObject zscore = (JSONObject) data.get(6);
            String  zScore = zscore.getString("value");
            double d=Double.parseDouble(zScore);
            dictionary.put(d,results);
        }

        //System.out.println(dictionary.size());

        Map<Double, JSONObject> treeMap = new TreeMap(dictionary);
//        for (JSONObject  a : treeMap.values()) {
//            System.out.println(a);
//            fileWriter(a);
//        }

        try(FileWriter file = new FileWriter("C:\\codeChamp/file1.txt")) {


            for (Map.Entry<Double, JSONObject> treemap : treeMap.entrySet()) {
                Double key = treemap.getKey();
                JSONObject value = treemap.getValue();

                if(key==Double.MAX_VALUE){
                    file.write(value.toString());
                }
                else{
                    file.write(key + "" + value.toString());
                    file.append(System.lineSeparator());
                }


            }

        }
    }

    public void fileWriter(Double key, JSONObject object) throws  Exception{

        try(FileWriter file = new FileWriter("C:\\codeChamp/file1.txt")){
            file.write(key + "" + object.toString());

            System.out.println("sucess");
        }


    }


}
