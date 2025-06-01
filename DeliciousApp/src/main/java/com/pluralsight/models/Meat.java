package com.pluralsight.models;

public class Meat {

    // Set attribute => what meat have!!
    private String size;
    private String type;//name
    private boolean isExtra;

    //Generate constructor

    public Meat(String size, boolean isExtra, String type) {
        this.size = size;
        this.isExtra = isExtra;
        this.type = type;
    }

    public Meat(String type,String size) {
        this.type = type;
        this.size = size;
    }
//Generate getter and setter

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        //this.price = calculateBasePrice(size, this.isExtra); // recalc price if size changes
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return getBasePrice() + getExtraCharge();
    }

    public double getBasePrice() {
        // Adjust price only if it's extra
        double basePrice = 0.0;

        // Base price depends on size
        switch (this.size) {
            case "4": return 1.00;
            case "8": return 2.00;
            case "12": return 3.00;
            default: return 0.0;
        }
    }

    // If extra, add additional cost depending on size
    private double getExtraCharge() {
        if (!isExtra) return 0.0;
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


public boolean isExtra() {
    return isExtra;
}

public void setExtra(boolean extra) {
    isExtra = extra;
    // this.price = calculateBasePrice(this.size, extra); // recalc price if extra changes
}

@Override
public String toString() {
    return "Meat{" +
            "size='" + size + '\'' +
            " is extra : " + isExtra +
            ", price=" + getPrice() +
            ", type='" + type + '\'' +
            '}';
}
}

//String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);