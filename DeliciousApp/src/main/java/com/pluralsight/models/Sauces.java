package com.pluralsight.models;

public class Sauces {
    //Set attribute for it

    private String type;

    //Generate constructor

    public Sauces(String type) {
        this.type = type;
    }

    //Generate getter and setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);
}
