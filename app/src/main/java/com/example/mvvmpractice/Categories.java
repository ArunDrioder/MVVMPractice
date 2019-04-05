package com.example.mvvmpractice;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categories {

    @SerializedName("menu_id")
    private Integer menu_id;

    @SerializedName("name")
    private String name;

    @SerializedName("image_path")
    private String image_path;

    @SerializedName("slug")
    private String slug;

    @SerializedName("child_categories")
    private ArrayList<Categories> child_categories;

    @SerializedName("parent_categories")
    private ArrayList<Categories> parent_categories;



    @SerializedName("all_categories")
    private ArrayList<Categories> all_categories;



    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public ArrayList<Categories> getChild_categories() {
        return child_categories;
    }

    public void setChild_categories(ArrayList<Categories> child_categories) {
        this.child_categories = child_categories;
    }

    public ArrayList<Categories> getParent_categories() {
        return parent_categories;
    }

    public void setParent_categories(ArrayList<Categories> parent_categories) {
        this.parent_categories = parent_categories;
    }

    public ArrayList<Categories> getAll_categories() {
        return all_categories;
    }

    public void setAll_categories(ArrayList<Categories> all_categories) {
        this.all_categories = all_categories;
    }



}
