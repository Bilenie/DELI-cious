package com.pluralsight.models;

public class Drink implements OrderItem {

    //Set attribute

    private String size;
    private double price;
    private String type;

    //Generate constructor

    public Drink(String size, String type) {
        this.size = size;
        this.type = type;

        this.price = price; //Automatically set price based on size
    }

    //Generate getter and setter.

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;

    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "s":
            case "small":
                return 2.00;
            case "m":
            case "medium":
                return 2.50;
            case "l":
            case "large":
                return 3.00;
            default:
                return 0.00;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String getDescription() {
        return type + " (" + size + ")";
    }
//String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);
}


