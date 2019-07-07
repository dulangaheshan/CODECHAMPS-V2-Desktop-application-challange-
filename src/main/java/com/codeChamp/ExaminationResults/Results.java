package com.codeChamp.ExaminationResults;

import java.io.InputStream;

public class Results {

    private String name;
    private String indexNumber;
    private String  zScore;
    private String districtRank;
    private String islanRank;
    private String year;
    private String stream;
    private String[] studentInfo;
    private String examination;
    private String[] subjectResults;
    private String marks;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String[] getSubjectResults() {
        return subjectResults;
    }

    public void setSubjectResults(String[] subjectResults) {
        this.subjectResults = subjectResults;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;


    public Results(InputStream response) {

        this.name = response.toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        indexNumber = indexNumber;
    }

    public String getzScore() {
        return zScore;
    }

    public void setzScore(String zScore) {
        this.zScore = zScore;
    }

    public String getDistrictRank() {
        return districtRank;
    }

    public void setDistrictRank(String districtRank) {
        this.districtRank = districtRank;
    }

    public String getIslanRank() {
        return islanRank;
    }

    public void setIslanRank(String islanRank) {
        this.islanRank = islanRank;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        stream = stream;
    }

    public String[] getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String[] allResults) {
        this.studentInfo = allResults;
    }
}
