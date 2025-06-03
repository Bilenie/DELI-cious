package com.pluralsight.ui;

import com.pluralsight.models.Chips;

import java.util.Scanner;

public class AddChips {

    public Chips getChips() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("      Welcome to the Chips Menu     ");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

        //Prompt user if they want to add chips.
        System.out.print("Would you like chips?\n (yes(Y)/no(N)): ");

        //Based on input if yes => we ask flavor
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {

            System.out.print("Enter chip flavor: ");
            String flavor = scanner.nextLine();

            Chips myChips = new Chips(flavor);

            return myChips;
        }
        // If they said "no", return nothing (null) — meaning no Chips was selected
        return null;
    }
}

