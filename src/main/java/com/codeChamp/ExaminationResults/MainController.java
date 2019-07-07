package com.codeChamp.ExaminationResults;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.String;

import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    private javafx.scene.control.TextField fieldSearch;

    @FXML
    public javafx.scene.control.Label name;
    @FXML
    public javafx.scene.control.Label indexNumber;
    @FXML
    public javafx.scene.control.Label zScore;
    @FXML
    public javafx.scene.control.Label districtRank;
    @FXML
    private javafx.scene.control.Label labelInfo;
    @FXML
    public javafx.scene.control.Label stream;
    @FXML
    public javafx.scene.control.Label sub1;
    @FXML
    public javafx.scene.control.Label sub2;
    @FXML
    public javafx.scene.control.Label sub3;
    @FXML
    public javafx.scene.control.Label sub4;
    @FXML
    public javafx.scene.control.Label sub5;
    @FXML
    public javafx.scene.control.Label sub6;


    public void search(ActionEvent actionEvent) throws Exception {
        String index = fieldSearch.getText();

        List<String> indexNumbers = Arrays.asList(index.split("\\s*,\\s*"));
        if (indexNumbers.size() == 1) {
                getResults(indexNumbers.get(0));
        }
        else{

            SaveAsText saveAsText = new SaveAsText();

            for(int i=0;i<indexNumbers.size();i++){
                Thread.sleep(1000L);
                saveAsText.generateResultSheets(indexNumbers.get(i));

            }

        }






        //

//
//        JSONObject subj6 = (JSONObject) subjectResults.get(6);
//        System.out.println(subj6);
//        sub6.setText(subj6.get("subjectName") + ": " + subj6.get("subjectResult"));

    }

    public void getResults(String index) throws Exception {

        //labelInfo.setMaxWidth(180);
        labelInfo.setWrapText(true);
        //labelInfo.setText(index);

        Services services = new Services();
        JSONObject results = services.sendget(index);
        System.out.println();

        System.out.println(results.get("year").toString());

        if (results.get("year").toString() == "null") {

            labelInfo.setText(results.get("errMsge").toString());
            name.setText("");
            indexNumber.setText("");
            districtRank.setText("");
            zScore.setText("");
            sub1.setText("");
            sub2.setText("");
            sub3.setText("");
            sub5.setText("");
            sub4.setText("");
            sub5.setText("");


        } else {


            JSONArray data = results.getJSONArray("studentInfo");
            System.out.println(data);
            JSONObject Name = (JSONObject) data.get(2);
            name.setText("Name : " + Name.getString("value"));
            JSONObject Index = (JSONObject) data.get(3);
            indexNumber.setText("Index Number : " + Index.getString("value"));
            JSONObject dRank = (JSONObject) data.get(4);
            districtRank.setText("District Rank :" + dRank.getString("value"));
            JSONObject iRank = (JSONObject) data.get(5);
            System.out.println(iRank);

            JSONObject zscore = (JSONObject) data.get(6);
            zScore.setText("Z-Score : " + zscore.getString("value"));
            labelInfo.setText("IslandRank :" + iRank.getString("value"));
            JSONObject substream = (JSONObject) data.get(7);
            System.out.println(substream + "hjgjhghfghg");
            //stream.setText("Stream + " + results.get("stream").toString());
            //System.out.println(data.get(8));
            System.out.println(index);
            JSONArray subjectResults = results.getJSONArray("subjectResults");
            //System.out.println(subjectResults);
            JSONObject subj1 = (JSONObject) subjectResults.get(0);
            // System.out.println(subj1);
            sub1.setText(subj1.get("subjectName") + ": " + subj1.get("subjectResult"));

            JSONObject subj2 = (JSONObject) subjectResults.get(1);
            // System.out.println(subj2);
            sub2.setText(subj2.get("subjectName") + ": " + subj2.get("subjectResult"));

            JSONObject subj3 = (JSONObject) subjectResults.get(2);
            //System.out.println(subj3);
            sub3.setText(subj3.get("subjectName") + ": " + subj3.get("subjectResult"));

            JSONObject subj4 = (JSONObject) subjectResults.get(4);
            //System.out.println(subj4);
            sub4.setText(subj4.get("subjectName") + ": " + subj4.get("subjectResult"));

            JSONObject subj5 = (JSONObject) subjectResults.get(3);
            //System.out.println(subj5);
            sub5.setText(subj5.get("subjectName") + ": " + subj5.get("subjectResult"));
        }

    }

}
