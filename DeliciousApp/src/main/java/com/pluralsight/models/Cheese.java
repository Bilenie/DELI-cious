package com.pluralsight.models;

public class Cheese {

    //set the attributes for Cheese.

    private String type;
    private String size;
    private double price;
    private boolean isExtra;

    //Generate constructor

    public Cheese(String size, String type, boolean isExtra) {
        this.size = size;
        this.type = type;
        this.isExtra = isExtra;
        this.price = getPrice();
    }

    public Cheese(String type, String size) {
        this.type = type;
        this.size = size;
    }
//generate getter and setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return getBasePrice() + getExtraCharge();
    }

    private double getBasePrice() {
        if (size == null) {
            System.out.println("Cheese size is null default base price => $0.00");
            return 0.0;
        }
        switch (this.size) {
            case "4":
                return 1.00;
            case "8":
                return 2.00;
            case "12":
                return 3.00;
            default:
                return 0.0;
        }
    }

    private double getExtraCharge() {
        if (!isExtra) return 0.0;
        if (this.size == null) {
            System.out.println("Cheese size is null  default extra charge => $0.00");
            return 0.0;
        }
        switch (this.size) {
            case "4":
                return 0.50;
            case "8":
                return 1.00;
            case "12":
                return 1.50;
            default:
                return 0.0;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "size='" + size + '\'' +
                ", isExtra=" + isExtra +
                ", type='" + type + '\'' +
                '}';
    }
    //String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);
}

