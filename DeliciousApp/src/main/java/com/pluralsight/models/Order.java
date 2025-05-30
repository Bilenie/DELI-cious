package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    // create List for order items (sandwiches, drinks, and chips)
    //Saves all sandwiches, drinks, chips	A big tray where all our snacks go

    public ArrayList<Sandwich> sandwiches;
    public ArrayList<Chips> chips;
    public ArrayList<Drink> drinks;
    public double price; // store total price

    // constructor:
    //   - initialize the class properties

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.price = price;
    }


    // addSandwich method:
    //   - add sandwich to list
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // addDrink method:
    //   - add drink to list
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // addChips method:
    //   - add chips to list
    public void addChips(Chips chip) {
        chips.add(chip);
    }

    // getTotal method:
    //   - return total price of order
    public double getTotal() {
        double totalPrice = 0.0;

        // Add up price of all sandwiches
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.getPrice();
        }

        // Add up price of all drinks
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }

        // Add up price of all chips
        for (Chips chip : chips) {
            totalPrice += chip.getPrice();
        }

        price = totalPrice; // save total price for later
        return totalPrice;
    }

    // getSandwiches, getDrinks, getChips:
    //   - return the orders items
    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }

    // getOrderSummary method:
    //   - return formatted string of all items and total

    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();

        summary.append("Order Summary:\n");

        // List sandwiches
        summary.append("Sandwiches:\n");
        for (Sandwich s : sandwiches) {
            summary.append(" - " + s.getSummary() + "\n"); // get the summary method from sandwich class.
        }

        // List drinks
        summary.append("Drinks:\n");
        for (Drink d : drinks) {
            summary.append(" - " + d.getType() + "\n"); // calling drink class getType method
        }

        // List chips
        summary.append("Chips:\n");
        for (Chips c : chips) {
            summary.append(" - " + c.getFlavor() + "\n"); // calling chips class flavor method.
        }

        // Show total price with 2 decimals
        summary.append(String.format("Total Price: $%.2f\n", getTotal()));

        return summary.toString();
    }
//String.format("%-12s | %-12s | %-18s | %-18s | %18.2f, %s", date.toString(), time.toString(), description, vendor, amount, type);
}
