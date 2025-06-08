package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.*;

public class AddChips {

    public Chips getChips() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("      Welcome to the Chips Menu     ");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        pauseBeforeContinuing(1000);

        //Prompt user if they want to add chips.
        System.out.print("Would you like chips?\n (yes(Y)/no(N)): ");

        //Based on input if yes => we ask flavor
        String choice = scanner.nextLine();

        //  Ask if they want chips
        boolean chipsAgain = true;
        while (chipsAgain) {
            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {

                //  Cute chips menu display
                System.out.println();
                System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆ 𝒪𝓊𝓇 𝒞𝒽𝒾𝓅𝓈 𝑀𝑒𝓃𝓊 ☆･ﾟ:*:･｡,★･ﾟ:*:･｡");
                System.out.println(" 🧂 Available Chips Options 🧂");
                System.out.println("        🍟 Lays");
                System.out.println("        🔺 Doritos");
                System.out.println("        🧀 Cheetos");
                System.out.println("        ☀️ SunChips");
                System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆･ﾟ:*:･｡★｡･ﾟ:*:･ﾟ☆･ﾟ");

                // ✏ Ask for chip flavor
                System.out.print("Enter chip flavor: ");
                String flavor = scanner.nextLine().trim();

                //  Validate chip name
                if (!flavor.matches("(?i)^(Lays|Doritos|Cheetos|SunChips)$")) {
                    System.out.println("💔 Aww... that chip isn’t on the menu. Try one from our cute list! 💕");
                    continue; // Stay in the loop until valid input
                }

                //  Valid chip, return it
                Chips myChips = new Chips(flavor);
                return myChips;
            }
            if (confirmYesNo(scanner, "Are you sure you don't want chips?")) {
                // User said yes, stop asking and return null
                chipsAgain = false;
            } else {
                // User said no, ask again about chips
                System.out.print("Would you like chips? (yes(Y)/no(N)): ");
                choice = scanner.nextLine();
            }
        }

//  If no chip selected, return null
        return null;
    }
}





