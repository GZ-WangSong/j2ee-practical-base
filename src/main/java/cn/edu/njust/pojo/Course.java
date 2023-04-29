package cn.edu.njust.pojo;

import java.util.ArrayList;

public class Course {
    private String cId;
    private String cName;
    private int cNum;
    private String cType;

    private ArrayList<String> cIdList;
    private ArrayList<String> cNameList;
    private ArrayList<String> cNumList;
    private ArrayList<String> cTypeList;

    public Course() {
    }

    public Course(String cname, int num) {
        this.cName = cname;
        this.cNum = num;
    }

    public Course(String id, String name, int num, String type) {
        this.cId = id;
        this.cName = name;
        this.cNum = num;
        this.cType = type;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public ArrayList<String> getcIdList() {
        return cIdList;
    }

    public void setcIdList(ArrayList<String> cIdList) {
        this.cIdList = cIdList;
    }

    public ArrayList<String> getcNameList() {
        return cNameList;
    }

    public void setcNameList(ArrayList<String> cNameList) {
        this.cNameList = cNameList;
    }

    public ArrayList<String> getcNumList() {
        return cNumList;
    }

    public void setcNumList(ArrayList<String> cNumList) {
        this.cNumList = cNumList;
    }

    public ArrayList<String> getcTypeList() {
        return cTypeList;
    }

    public void setcTypeList(ArrayList<String> cTypeList) {
        this.cTypeList = cTypeList;
    }
}
