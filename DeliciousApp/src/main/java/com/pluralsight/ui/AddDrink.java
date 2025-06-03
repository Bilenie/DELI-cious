package com.pluralsight.ui;

import com.pluralsight.models.Drink;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.showLoadingSpinner;

public class AddDrink {
    public Drink getDrink() {
        // Set up scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("       Welcome to the Drink Menu    ");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

        // Ask the user if they want a drink
        showLoadingSpinner(1000);
        System.out.print("Would you like a drink? (yes/Y) /(No/N): ");
        String answer = scanner.nextLine().trim();

        // If they said "yes", ask for details and create a drink
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            // Ask for the type of drink (like Coke, Sprite, etc.)
            showLoadingSpinner(1000);
            System.out.print("Enter drink type: ");
            String type = scanner.nextLine().trim();

            // Ask for the drink size (Small/Medium/Large)
            showLoadingSpinner(1000);
            System.out.print("Enter size (Small/Medium/Large): ");
            String size = scanner.nextLine().trim();


            // Return a new Drink object with the type and size the user gave
            Drink myDrink = new Drink(size, type);

            return myDrink;
        }

        // If they said "no", return nothing (null) — meaning no drink was selected
        return null;
    }
}
