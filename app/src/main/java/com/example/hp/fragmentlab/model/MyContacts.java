package com.example.hp.fragmentlab.model;

/**
 * Created by hp on 10/12/2017.
 */

public class MyContacts {
    private String name;
    private String phoen;
    private int imgId;

    public MyContacts(String name, String phoen, int imgId) {
        this.name = name;
        this.phoen = phoen;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoen() {
        return phoen;
    }

    public void setPhoen(String phoen) {
        this.phoen = phoen;
    }

    public MyContacts(String name, String phoen) {

        this.name = name;
        this.phoen = phoen;
    }
}
