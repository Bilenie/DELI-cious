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
            pauseBeforeContinuing(1000);

            System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");
            System.out.print(" Choose bread (White/Wheat/Rye/Wrap):\n ");
            System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");
            bread = myScanner.nextLine().trim().toLowerCase();

            if (bread.matches("(?i)white|wheat|rye|wrap")) break;

            pauseBeforeContinuing(1000);
            System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");
            System.out.println("Invalid choice. Try again.\n");
            System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");

        }
        // Ask size

        String sizeChoice = askSize(myScanner);

        // Ask if toasted
        boolean toasted = true;
        while (toasted) {

            pauseBeforeContinuing(1000);
            System.out.print("Would you like it toasted? Enter Y to toast !\n ");
            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");

            String toastedInput = myScanner.nextLine().trim();
            if (!toastedInput.equalsIgnoreCase("Y")) {
                System.out.println("Are you sure? press Y for Yes!");
                String userChoice = myScanner.nextLine().trim();

                if (userChoice.equalsIgnoreCase("Y")) {
                    toasted = false;
                    pauseBeforeContinuing(1000);
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping toasted option...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    break;
                } else {
                    continue;
                }

            } else {
                pauseBeforeContinuing(1000);
                System.out.println("You have Successfully chosen your bread!!!");
                break;
            }

        }

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);
        if (!confirmStep(myScanner, sandwich)) return null;


        //============================ MEAT ============================
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("\nMeats (Premium Toppings):\n");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

        pauseBeforeContinuing(1000);

        System.out.println(" Steak, Ham, Salami, Roast Beef, Chicken, Bacon");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");

        pauseBeforeContinuing(1000);

        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦");

        pauseBeforeContinuing(1000);
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦");

        boolean validMeat = true;
        while (validMeat) {
            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");
            System.out.println("Would you like to add meat? (Y for YES): or press Enter to skip: \n");
            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");

            String meatChoice = myScanner.nextLine().trim();
            pauseBeforeContinuing(1000);
            boolean addMeat = false;

            if (meatChoice.equalsIgnoreCase("Y")) {
                addMeat = true;

                // ============== SIZE ===================
                String meatSize = sizeChoice;

                // ============== TYPE ===================
                String[] meats = getValidMeat(myScanner);

                // ============== EXTRA ===================
                boolean isExtra;

                System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                System.out.print("Do you want extra meat? (Y/N): \n");
                System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

                String meatExtra = myScanner.nextLine().trim();
                pauseBeforeContinuing(1000);

                if (meatExtra.equalsIgnoreCase("Y")) {
                    isExtra = true;
                } else {
                    isExtra = false;
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping extra meat ...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                }


                for (String meat : meats) {
                    String meatType = meat.trim().toLowerCase();
                    if (!meatType.isEmpty()) {
                        Meat topping = new Meat(meatType, sizeChoice);
                        topping.setExtra(isExtra);
                        sandwich.addMeats(topping);
                    }
                }

            } else {
                // ============== RETRY / SKIP ===================
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");
                System.out.println("You didn't choose your Meat. Would you like to try again? Press Y for Yes:\n");
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");

                String meatRetry = myScanner.nextLine().trim();
                pauseBeforeContinuing(1000);

                if (meatRetry.equalsIgnoreCase("y")) {
                    continue;
                } else {
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping meat ...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    pauseBeforeContinuing(1000);
                }
            }
            break;
        }

        // ============== Confirm Sandwich ===================
        if (!confirmStep(myScanner, sandwich)) return null;

        //============================ CHEESE ============================
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
        System.out.println("\nCheese (Premium Toppings):\n");
        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");

        showLoadingSpinner(1000);
        System.out.println("- american, provolone, cheddar, swiss\n");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");

        pauseBeforeContinuing(1000);
        System.out.println("Base Prices: $0.75 $1.50 $2.25\n");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");

        pauseBeforeContinuing(1000);
        System.out.println("Extra Cheese: $0.30 $0.60 $0.90\n");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");


        boolean validCheese = true;
        while (validCheese) {

            System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦");
            System.out.println("Would you like to add cheese? (Y): or press Enter to skip:\n ");
            System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦");

            String cheeseChoice = myScanner.nextLine().trim();
            pauseBeforeContinuing(1000);
            boolean addCheese = false;

            if (cheeseChoice.equalsIgnoreCase("Y")) {
                addCheese = true;

                // ============== SIZE ===================
                String cheeseSize = sizeChoice;
                // ============== TYPE ===================
                String[] cheeses = getValidCheese(myScanner);
                // ============== EXTRA ===================

                System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");
                System.out.print("Do you want extra cheese? (Y/N): \n");
                System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");

                String cheeseExtra = myScanner.nextLine().trim();
                pauseBeforeContinuing(1000);

                if (!cheeseExtra.equalsIgnoreCase("Y")) {
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping extra cheese ...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                }
                // Add cheese objects
                boolean isExtra = true;
                for (String cheese : cheeses) {
                    String cheeseType = cheese.trim().toLowerCase();
                    if (!cheeseType.isEmpty()) {
                        Cheese topping = new Cheese(cheeseType, sizeChoice);
                        topping.setExtra(isExtra);
                        sandwich.addCheese(topping);
                    }
                }


            } else {
                // ============== RETRY / SKIP ===================
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");
                System.out.println("You didn't choose your Cheese. Would you like to try again? Press Y for Yes:\n");
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡.");

                String cheeseRetry = myScanner.nextLine().trim();
                pauseBeforeContinuing(1000);

                if (!cheeseRetry.equalsIgnoreCase("Y")) {
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping Cheese ...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    showLoadingSpinner(100);
                } else {
                    continue;
                }

            }
            break;
        }
        // Confirm sandwich
        if (!confirmStep(myScanner, sandwich)) return null;


        // ======================= REGULAR TOPPINGS (Included) =======================

        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");
        System.out.println("Regular Toppings (Included, no extra charge):");
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦");

        pauseBeforeContinuing(1000);

        while (true) {

            String[] toppings = getValidTopping(myScanner); // method to enter topping and validate it

            // Add valid toppings
            for (String t : toppings) {
                Topping topping = new Topping(t.trim().toLowerCase());
                sandwich.addTopping(topping);

                pauseBeforeContinuing(1000);

                System.out.println("Topping Successfully added!!!");
            }

            if (!confirmStep(myScanner, sandwich)) return null;

            if (toppings.length == 0) {
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡.");
                System.out.println("You didn't choose your free toppings. Would you like to try again?\nPress Y for Yes");
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡.");

                String toppingInput = myScanner.nextLine().trim().toLowerCase();
                pauseBeforeContinuing(1000);

                if (!toppingInput.equalsIgnoreCase("y")) {
                    System.out.println("Are you sure? press Y for Yes!");
                    String userChoice = myScanner.nextLine().trim();

                    if (userChoice.equalsIgnoreCase("Y")) {
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        System.out.println("Skipping Topping...\n");
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        pauseBeforeContinuing(1000);
                        break;
                    } else {
                        continue; // retry topping input
                    }
                }

            }
            break;
        }

        //============================ Sauces (Included) ============================
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧");
        System.out.println(" Sauces (Included): Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette\n");
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧✦✧");

        showLoadingSpinner(1000);
        while (true) {
            System.out.print("Enter sauces you want (Use comma please)  or press Enter to skip :\n ");
            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");

            String saucesInput = myScanner.nextLine().trim().toLowerCase();
            pauseBeforeContinuing(1000);

              if (!saucesInput.isEmpty()) {
                // Validate only allowed sauces are added
                String[] sauces = saucesInput.split(",");
                boolean invalidFound = false;  // Flag to detect invalid sauce

                for (String s : sauces) {
                    String sauce = s.trim().toLowerCase();
                    if (sauce.equals("mayo") ||
                            sauce.equals("mustard") ||
                            sauce.equals("ketchup") ||
                            sauce.equals("ranch") ||
                            sauce.equals("thousand island") ||
                            sauce.equals("vinaigrette")) {

                        sandwich.addSauce(new Sauces(sauce));
                    } else {
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                        System.out.println("Invalid sauce: '" + sauce + "'. Try again.\n");
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                        invalidFound = true;
                        break;  // Stop checking more sauces because one is invalid
                    }
                }
                  if (invalidFound) {
                      continue; // Ask again
                  }
            } else {
                  // User pressed Enter to skip, now ask "Are you sure?"
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..");
                System.out.println("You didn't choose your free Sauces. Would you like to try again? Press Y for Yes:\n");
                System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..");

                String sauceRetry = myScanner.nextLine().trim().toLowerCase();
                pauseBeforeContinuing(1000);

                if (!sauceRetry.equalsIgnoreCase("Y")) {
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                    System.out.println("Skipping Sauce ...\n");
                    System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");
                    pauseBeforeContinuing(1000);
                    break;
                } else {
                    // User said No, so ask sauces again by continuing loop
                    continue;
                }
            }
            break; // If we reach here, sauces were entered correctly, break loop
        }
        if (!confirmStep(myScanner, sandwich)) return null;


        //============================ Sides (Included) ============================

        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
        System.out.println(" Sides (Included): Au Jus, Sauce");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");

        System.out.print("Enter sides you want (Use comma please)  or press Enter to skip: \n");
        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦");

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
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..");
                        System.out.println("Invalid side: '" + sideTrimmed + "'. Only 'Au Jus' and 'Sauce' are allowed.");
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..");
                    }
                }
            }
        }

        if (!confirmStep(myScanner, sandwich)) return null;

        // ============================ Printing Summary of Order ============================

        System.out.println(sandwich.getSummary());
        showLoadingSpinner(1500);

        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡");
        System.out.println("Is this sandwich correct : Y");
        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒.｡*✎*｡");

        String userChoice = myScanner.nextLine();
        pauseBeforeContinuing(1000);


        if (!userChoice.equalsIgnoreCase("y")) {
            return null;
        }
        // ============================ RETURN FINAL SANDWICH ============================
        return sandwich;

    }


}


