package com.pluralsight.ui;

import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.*;

public class AddDrink {
    public Drink getDrink() {
        // Set up scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("       Welcome to the Drink Menu    ");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

        // Ask the user if they want a drink
        pauseBeforeContinuing(1000);
        ;
        System.out.print("Would you like a drink? (yes/Y) /(No/N): ");
        String answer = scanner.nextLine().trim();

        // 🍹 Ask if they want a drink
        boolean drinksAgain = true;

        while (drinksAgain) {
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                // Cute drinks menu display
                System.out.println();
                System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆ 𝒪𝓊𝓇 𝒟𝓇𝒾𝓃𝓀 𝑀𝑒𝓃𝓊 ☆･ﾟ:*:･｡,★･ﾟ:*:･｡");
                System.out.println("  🥤 Available Drinks Options 🥤");
                System.out.println("        🥤 Coke");
                System.out.println("        🍋 Lemonade");
                System.out.println("        🧃 Orange Juice");
                System.out.println("        🧊 Iced Tea");
                System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆･ﾟ:*:･｡★｡･ﾟ:*:･ﾟ☆･ﾟ");

                // ✏ Ask for drink type
                System.out.print("Enter drink type: ");
                String type = scanner.nextLine().trim();

                // Validate drink name
                if (!type.matches("(?i)^(Coke|Lemonade|Orange Juice|Iced Tea)$")) {
                    System.out.println("💔 Oops! That drink isn’t on the menu. Please pick one from our cute list! 💕");
                    continue; // stay in loop until valid input
                }

                // ✏Ask for drink size
                System.out.print("Enter size (Small/Medium/Large): ");
                String size = scanner.nextLine().trim();

                //  Valid drink, return it
                Drink myDrink = new Drink(size, type);
                return myDrink;
            }
            if (confirmYesNo(scanner, "Are you sure you don't want drinks?")) {
                // User said yes, stop asking and return null
                drinksAgain = false;
            } else {
                // User said no, ask again about chips
                System.out.print("Would you like drinks? (yes(Y)/no(N)): ");
                answer = scanner.nextLine();
            }
        }
// If no drink selected, return null
        return null;
    }
}
