package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich implements OrderItem{

    //Set attribute for sandwich class
    private String breadType;// store bread type (white, wheat, rye, wrap)
    private String size;// store sandwich size (4, 8, or 12 inches)
    private boolean isToasted;// store if sandwich is toasted
    private ArrayList<Meat> meats; //store meats
    private ArrayList<Cheese> cheeses; //store Cheeses
    private ArrayList<Topping> toppings;// store toppings includes meats, cheeses, and regular toppings
    private ArrayList<Sauces> sauces; // store sauces
    private ArrayList<Sides> sides;
    private Chips chips;
    private Drink drink;

    private double price;// keep track of total price


    // constructor: takes bread type, size, toasted

    public Sandwich(String breadType, String size, boolean isToasted) {

        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;

        //initialize the list to be new list.

        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();

    }
// addMeat/Cheese/Topping/Sauce method:

    public void addMeats(Meat meat) {
        meats.add(meat);// add meat(s)
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);// add cheese(s)
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);// add topping(s)
    }

    public void addSauce(Sauces sauce) {
        sauces.add(sauce);// add sauce(s)
    }

    public void addSides(Sides side) {
        sides.add(side);
    }

    /*
     * Calculates total sandwich price:
     * Base sandwich price + premium (meats + cheeses )+ regular toppings.
     * Sauces and sides are free.
     * return total price as double
     */

    // The price based on size and whether it's extra?
    @Override
    public double getPrice() {

        double totalPrice = 0.0;

        // Base sandwich price by size
        switch (size) {
            case "4": totalPrice += 5.50; break;
            case "8": totalPrice += 7.00; break;
            case "12": totalPrice += 8.50; break;
        }
        // Add meats (base + extra included in getPrice)
        for (Meat meat : meats) {
            totalPrice += meat.getPrice();
        }

        // Add cheeses
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice();
        }

        //  Regular toppings (free) are not charged


        // Add chips (if selected)
        if (chips != null) {
            totalPrice += chips.getPrice(); // Always $1.50
        }
        // Add drink (if selected)
        if (drink != null) {
            totalPrice += drink.getPrice(); // $2.00–$3.00 based on size
        }

        //  Store total
        this.price = totalPrice;

        return totalPrice;
    }

    public String getSize() {
        return size;
    }
    // getSummary method
//   returns a string with sandwich details and total price


    public String getSummary() {

        StringBuilder summary = new StringBuilder();

        // Cute top border
        summary.append(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.\n");
        summary.append("｡                                               ｡\n");
        summary.append("｡           ⚙ Sandwich Summary ✧               ｡\n");
        summary.append("｡     .｡*♡*｡..｡*☆*.｡.*✧*.｡.*✧*.｡.*♡*｡.         ｡\n");

        // Bread, size, toasted
        summary.append(String.format("｡  Bread    => %s%-30s｡\n", breadType, ""));
        summary.append(String.format("｡  Size     => %s%-30s｡\n", size, ""));
        summary.append(String.format("｡  Toasted  => %s%-30s｡\n", (isToasted ? "Yes" : "No"), ""));

        // Meats
        if (!meats.isEmpty()) {
            summary.append("｡  Meats:\n");
            for (Meat m : meats) {
                summary.append(String.format("｡    ➤ Type: %s, Size: %s inch, ฿%s, Extra: %s%-5s｡\n",
                        m.getType(), m.getSize(), m.getPrice(), m.isExtra(), ""));
            }
        }

        // Cheeses
        if (!cheeses.isEmpty()) {
            summary.append("｡  Cheeses:\n");
            for (Cheese c : cheeses) {
                summary.append(String.format("｡    ➤ Type: %s, Extra: %s%-5s｡\n",
                        c.getType(), c.isExtra(), ""));
            }
        }

        // Toppings
        if (!toppings.isEmpty()) {
            summary.append("｡  Toppings: ");
            for (Topping t : toppings) {
                summary.append(t.getType() + ", ");
            }
            summary.append(String.format("%-18s｡\n", ""));
        }

        // Sauces
        if (!sauces.isEmpty()) {
            summary.append("｡  Sauces: ");
            for (Sauces s : sauces) {
                summary.append(s.getType() + ", ");
            }
            summary.append(String.format("%-20s｡\n", ""));
        }

        // Sides
        if (!sides.isEmpty()) {
            summary.append("｡  Sides: ");
            for (Sides s : sides) {
                summary.append(s.getType() + ", ");
            }
            summary.append(String.format("%-21s｡\n", ""));
        }

        // Total Price
        String formattedPrice = String.format("%.2f", this.getPrice());
        summary.append("｡                                               ｡\n");
        summary.append(String.format("｡  Total Price: ฿%s%-26s｡\n", formattedPrice, ""));
        summary.append("｡                                               ｡\n");
        summary.append(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.\n");

        return summary.toString();
    }

    @Override
    public String getDescription() {
        return getSummary();
    }
}


