package com.example.raviteja.crudjson;

/**
 * Created by talarir on 10/27/2016.
 */

public class DataProvider {
    String name,hostel;
    int images;

    public DataProvider(String name, String hostel, int images) {
        this.name = name;
        this.hostel = hostel;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
