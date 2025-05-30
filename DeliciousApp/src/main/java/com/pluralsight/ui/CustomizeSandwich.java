package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.*;


public class CustomizeSandwich {
    public Sandwich build() {
        Scanner myScanner = new Scanner(System.in);

        // Get bread and size

        //============================ BREAD ============================
        String bread;
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print(" Choose bread (White/Wheat/Rye/Wrap):\n ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            bread = myScanner.nextLine().trim().toLowerCase();

            if (bread.matches("(?i)white|wheat|rye|wrap")) break;

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Invalid choice. Try again.\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }

        String sizeChoice;
        while (true) {
            System.out.print("   Enter the size you want (4/8/12):\n ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            sizeChoice = myScanner.nextLine().trim();
            if (sizeChoice.matches("4|8|12")) break;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Invalid size. Try again.\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }

        // Ask if toasted
        boolean toasted = false;
        System.out.print("Would you like it toasted? Enter Y to toast !\n ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String toastedInput = myScanner.nextLine().trim();
        if (toastedInput.equalsIgnoreCase("Y")) {
            toasted = true;
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Skipping toasted option...\n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);
        if (!confirmStep(myScanner, sandwich)) return null;


        //============================ MEAT ============================
        System.out.println("********************************");
        System.out.println("\nMeats (Premium Toppings):\n");
        System.out.println("\n********************************");

        showLoadingSpinner(1000);

        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Would you like to add meat? (Y): or press Enter to skip: \n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String meatChoice = myScanner.nextLine().trim();
        showLoadingSpinner(1000);
        boolean addMeat = false;

        if (meatChoice.equalsIgnoreCase("Y")) {
            addMeat = true;

            // ============== SIZE ===================
            while (true) {
                System.out.print("Enter the size you want (4/8/12): \n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                sizeChoice = myScanner.nextLine().trim();
                showLoadingSpinner(1000);

                if (sizeChoice.matches("4|8|12")) break;

                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Invalid size. Try again.");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }

            // ============== TYPE ===================
            String[] meats = getValid(myScanner);

            // ============== EXTRA ===================
            boolean isExtra;

            System.out.println("********************************");
            System.out.print("Do you want extra meat? (Y/N): \n");
            System.out.println("********************************");

            String meatExtra = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (meatExtra.equalsIgnoreCase("Y")) {
                isExtra = true;
            } else {
                isExtra = false;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping extra meat ...\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }


            for (String meat : meats) {
                String meatType = meat.trim().toLowerCase();
                if (!meatType.isEmpty()) {
                    Meat topping = new Meat(meatType, sizeChoice);
                    topping.setExtra(isExtra);
                    sandwich.addMeats(topping);
                }
            }

            System.out.println("test");

        } else {
            // ============== RETRY / SKIP ===================
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your Meat. Would you like to try again? Press Y for Yes:\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String meatRetry = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (meatRetry.equalsIgnoreCase("y")) {
                getValid(myScanner); // validates whether meat input match the options
            } else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping meat ...\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                showLoadingSpinner(100);
            }
        }

        // ============== Confirm Sandwich ===================
        if (!confirmStep(myScanner, sandwich)) return null;

        //============================ CHEESE ============================
        System.out.println("********************************");
        System.out.println("\nCheese (Premium Toppings):\n");
        System.out.println("********************************");

        showLoadingSpinner(1000);
        System.out.println("- american, provolone, cheddar, swiss\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Base Prices: $0.75 $1.50 $2.25\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Extra Cheese: $0.30 $0.60 $0.90\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Would you like to add cheese? (Y): or press Enter to skip:\n ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String cheeseChoice = myScanner.nextLine().trim();
        showLoadingSpinner(1000);
        boolean addCheese = false;

        if (cheeseChoice.equalsIgnoreCase("Y")) {
            addCheese = true;

            // ============== SIZE ===================
            while (true) {
                System.out.print("Enter the size you want (4/8/12): \n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                sizeChoice = myScanner.nextLine().trim();
                showLoadingSpinner(1000);

                if (sizeChoice.matches("4|8|12")) break;

                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Invalid size. Try again.\n");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }

            // ============== TYPE ===================
            String[] cheeses;
            while (true) {
                System.out.print("Enter Cheese - American, Provolone, Cheddar, Swiss (comma-separated): \n");
                String cheeseInput = myScanner.nextLine().trim();
                showLoadingSpinner(1000);

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

            // ============== EXTRA ===================
            boolean isExtra;
            System.out.println("********************************");
            System.out.print("Do you want extra cheese? (Y/N): \n");
            System.out.println("********************************");

            String cheeseExtra = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (cheeseExtra.equalsIgnoreCase("Y")) {
                isExtra = true;
            } else {
                isExtra = false;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping extra cheese ...\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            // Add cheese objects
            for (String cheese : cheeses) {
                String cheeseType = cheese.trim().toLowerCase();
                if (!cheeseType.isEmpty()) {
                    Cheese topping = new Cheese(cheeseType,sizeChoice);
                    topping.setExtra(isExtra);
                    sandwich.addCheese(topping);
                }
            }

        } else {
            // ============== RETRY / SKIP ===================
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your Cheese. Would you like to try again? Press Y for Yes:\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String cheeseRetry = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (!cheeseRetry.equalsIgnoreCase("Y")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping Cheese ...\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                showLoadingSpinner(100);
            } else {
                getValid(myScanner);
            }
        }
            // Confirm sandwich
            if (!confirmStep(myScanner, sandwich)) return null;



        // ======================= REGULAR TOPPINGS (Included) =======================

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Regular Toppings (Included, no extra charge):\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        String[] toppings;
        boolean toppingsAdded = false;
        while (true) {
            System.out.print("Enter your toppings - lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms (use comma please) \n: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String regularInput = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);

            if (!regularInput.isEmpty()) {
                toppings = regularInput.split(",");
                boolean allValid = true;

                for (String t : toppings) {
                    String topping = t.trim().toLowerCase();
                    if (!topping.matches("(?i)lettuce|peppers|onions|tomatoes|jalapeños|cucumbers|pickles|guacamole|mushrooms")) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Invalid Topping: '" + topping + "'. Try again.\n");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        allValid = false;
                        break;
                    }
                }
                if (allValid) {
                    for (String t : toppings) {
                        // Create a new instance of Topping using the user's valid input and add it to the sandwich
                        Topping topping = new Topping(t.trim().toLowerCase());
                        sandwich.addTopping(topping);
                    }
                    toppingsAdded = true;
                    if (!confirmStep(myScanner, sandwich)) return null; // confirmation here
                    break;
                }

            } else {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("You didn't choose your free toppings. Would you like to try again?\nPress Y for Yes\n");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                String toppingInput = myScanner.nextLine().trim().toLowerCase();
                showLoadingSpinner(1000);

                if (toppingInput.equalsIgnoreCase("Y")) {
                    continue;//need checking
                } else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Skipping Topping...\n");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    showLoadingSpinner(100);
                    break;
                }
            }
        }


        //============================ Sauces (Included) ============================
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" Sauces (Included): Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);

        System.out.print("Enter sauces you want (Use comma please)  or press Enter to skip :\n ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String saucesInput = myScanner.nextLine().trim().toLowerCase();
        showLoadingSpinner(1000);


        if (!saucesInput.equalsIgnoreCase("Y")) {

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your free Sauces. Would you like to try again? Press Y for Yes:\n");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String sauceRetry = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);


            if (!sauceRetry.equalsIgnoreCase("Y")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping Sauce ...\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                showLoadingSpinner(100);
            }
            // Validate only allowed sauces are added
            if (!saucesInput.trim().isEmpty()) {
                String[] sauces = saucesInput.split(",");
                for (String s : sauces) {
                    String sauce = s.trim().toLowerCase();
                    if (!sauce.isEmpty()) {
                        if (sauce.equals("mayo") ||
                                sauce.equals("mustard") ||
                                sauce.equals("ketchup") ||
                                sauce.equals("ranch") ||
                                sauce.equals("thousand island") ||
                                sauce.equals("vinaigrette")) {

                            sandwich.addSauce(new Sauces(sauce));
                        } else {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("Invalid sauce: '" + sauce + "'. Skipping it.\n");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                    }
                }
            }
            if (!confirmStep(myScanner, sandwich)) return null;


            //============================ Sides (Included) ============================

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Sides (Included): Au Jus, Sauce");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.print("Enter sides you want (Use comma please)  or press Enter to skip: \n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String sidesInput = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);


            // Only allow valid sides: "au jus" and "sauce"
            if (!sidesInput.trim().isEmpty()) {
                String[] sides = sidesInput.split(",");
                for (String side : sides) {
                    String sideTrimmed = side.trim();
                    if (!sideTrimmed.isEmpty()) {
                        if (sideTrimmed.equalsIgnoreCase("au jus") || sideTrimmed.equalsIgnoreCase("sauce")) {
                            sandwich.addSides(new Sides(sideTrimmed));
                        } else {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("Invalid side: '" + sideTrimmed + "'. Only 'Au Jus' and 'Sauce' are allowed.");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                    }
                }
            }

            if (!confirmStep(myScanner, sandwich)) return null;

            // ============================ Printing Summary of Order ============================

            System.out.println(sandwich.getSummary());
            showLoadingSpinner(1000);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Is this sandwich correct : Y");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String userChoice = myScanner.nextLine();
            showLoadingSpinner(1000);

            if (!userChoice.equalsIgnoreCase("y")) {
                return null;
            }
        }

        // ============================ RETURN FINAL SANDWICH ============================
        return sandwich;
    }
}

