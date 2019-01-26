package com.example.uzzal.customlistviewsearchviewandactionbar;

public class Model {

    String title;
    String desc;
    int icon;

    // create to constructor


    public Model(String title, String desc, int icon) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
    }

    // getter and setter create...


    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIcon() {
        return this.icon;
    }
}
