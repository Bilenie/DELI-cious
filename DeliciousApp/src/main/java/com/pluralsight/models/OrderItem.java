package com.pluralsight.models;

public interface OrderItem {
    double getPrice();         // All items have a price

    String getDescription();   // A short description for receipt/display
}
