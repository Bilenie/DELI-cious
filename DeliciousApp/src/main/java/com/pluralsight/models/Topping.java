package com.pluralsight.models;

public class Topping {
// Set attribute
    //extra and size already the topping specifics classes include so no need to add it here

    private boolean isPremium;
    private double price;
    private String type; //regular or premium

    public Topping(String type) {
        this.isPremium = false;// don't need this attribute
        this.price = 0;
        this.type = type;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getPrice() {
        return price;
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

    // Static helper method to determine if a topping is premium
    public static boolean isPremiumTopping(Object topping) {//judging based on type rather than relying on internal data.
        return topping instanceof Meat || topping instanceof Cheese;

    }

    public void isRegular(Topping topping) {
        if (!topping.isPremium()) {
            System.out.println("You choose regular! " + topping.getType() + "topping no charge");
        }

        //String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);

    }
}



