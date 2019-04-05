package com.example.mvvmpractice;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataPOJO {

    @SerializedName("status")
    private String status;

    @SerializedName("msg")
    private String msg;

    @SerializedName("categories")
    private ArrayList<Categories> categories;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategoriesArrayList(ArrayList<Categories> categories) {
        this.categories = categories;
    }
}
