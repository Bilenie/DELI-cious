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


    // Waits for a specific time in milliseconds (like 2000 ms = 2 seconds).Then continues automatically.
    public static void pauseBeforeContinuing(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Pause interrupted.");
        }

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

    public static String[] getValidMeat(Scanner myScanner) {
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

    public static String[] getValidCheese(Scanner myScanner) {
        String[] cheeses;
        while (true) {
            System.out.print("Enter Cheese - American, Provolone, Cheddar, Swiss (comma-separated): \n");
            String cheeseInput = myScanner.nextLine().trim();
            pauseBeforeContinuing(1000);

            cheeses = cheeseInput.split(",");
            boolean allValid = true;

            for (String cheese : cheeses) {
                String c = cheese.trim().toLowerCase();
                if (!c.matches("(?i)american|provolone|cheddar|swiss")) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Invalid Cheese: '" + c + "'. Try again.\n");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    allValid = false;
                    break;
                }
            }

            if (allValid) break;
        }
        return cheeses;
    }


    public static String askSize(Scanner scanner) {
        String size;
        while (true) {
            System.out.print("Enter the size you want (4/8/12):\n ");
            size = scanner.nextLine().trim();
            if (size.matches("4|8|12")) return size;

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Invalid size. Try again.\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public static String[] getValidTopping(Scanner myScanner) {
        String[] topping;
        while (true) {
            System.out.print("Enter your toppings - lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms (use comma please) \n: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            pauseBeforeContinuing(1000);

            String regularInput = myScanner.nextLine().trim().toLowerCase();
            pauseBeforeContinuing(1000);


            if (!regularInput.isEmpty()) {

                topping = regularInput.split(",");
                boolean allValid = true;

                for (String t : topping) {
                    String toppings = t.trim().toLowerCase();
                    if (!toppings.matches("(?i)lettuce|peppers|onions|tomatoes|jalapeños|cucumbers|pickles|guacamole|mushrooms")) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Invalid Topping: '" + toppings + "'. Try again.\n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        allValid = false;
                        break;
                    }
                }
                if (allValid) {
                    return topping;
                } else {
                    System.out.println("Please enter at least one topping.\n");
                }

            }

        }
    }

    public static boolean askExtra(Scanner scanner, String category) {
        System.out.printf("Do you want extra %s? (Y/N):\n ", category);
        String input = scanner.nextLine().trim();
        return input.equalsIgnoreCase("Y");
    }

}
