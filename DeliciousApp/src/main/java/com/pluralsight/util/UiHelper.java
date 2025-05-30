package com.pluralsight.util;

import com.pluralsight.models.Sandwich;

import java.util.Scanner;

public class UiHelper {

    //================================ Loading Spinner ===============================

    // gives the user a visual spinner for loading. Useful and looks professional.
    public static void showLoadingSpinner(int durationMillis) {
        char[] spinner = {'|', '/', '-', '\\'};
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < durationMillis) {
            for (char ch : spinner) {
                System.out.print("\rLoading " + ch);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("\nLoading interrupted.");
                    return;
                }
            }
        }

        System.out.print("\rLoading done!         \n");
    }

    //Method waits until user presses Enter gives control to user.
    public static void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static boolean confirmStep(Scanner scanner, Sandwich sandwich) {

        // Print the current summary of the sandwich (bread, meat, cheese, etc.)
        System.out.println("\n" + sandwich.getSummary());

        // Ask the user if they like what they see.
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("Is this correct? Press \"Y\" to continue or anything else to cancel! ");
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        // Use the Scanner to read what the user types.
        String input = scanner.nextLine();
        // Check if the user typed "Y" (yes)
        if (input.equalsIgnoreCase("Y")) {
            return true; // They confirmed, continue with the order
        } else {
            // They typed something else — cancel it

            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("Order canceled.");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            return false;
        }
        //if (!confirmStep(myScanner, sandwich)) return null;
    }

    public static String[] getValid(Scanner myScanner) {
        String[] meats;
        while (true) {
            showLoadingSpinner(1000);
            System.out.print("Enter meats - steak, ham, salami, roast beef, chicken, bacon (use comma please):\n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String meatInput = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);

            meats = meatInput.split(",");
            boolean allValid = true;

            for (String meat : meats) {
                String m = meat.trim().toLowerCase();
                if (!m.matches("(?i)steak|ham|salami|roast beef|chicken|bacon")) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Invalid meat: '" + m + "'. Try again.\n");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    allValid = false;
                    break;
                }
            }

            if (allValid) break;
        }

        return meats;
    }

    // Waits for a specific time in milliseconds (like 2000 ms = 2 seconds).Then continues automatically.
    public void pauseBeforeContinuing(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }

    }
}
