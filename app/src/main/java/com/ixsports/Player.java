package com.ixsports;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("position")
    @Expose
    String position;

    @SerializedName("birthdate")
    @Expose
    String birthdate;

    @SerializedName("shirtnumber")
    @Expose
    String shirtnumber;

    @SerializedName("weight")
    @Expose
    String width;

    @SerializedName("height")
    @Expose
    String height;

    public String getShirtnumber() {
        return shirtnumber;
    }

    public void setShirtnumber(String shirtnumber) {
        this.shirtnumber = shirtnumber;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
