package com.example.fidelbarcaya.country.models;

/**
 * Created by fidel.barcaya on 4/3/2017.
 */

public class Country {

    private String name;
    private String capital;
    private String alpha2Code;

    public String getAlpha2Code() {
        return alpha2Code.toLowerCase();
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


}
