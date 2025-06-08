package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.pauseBeforeContinuing;
import static com.pluralsight.util.UiHelper.showLoadingSpinner;

public class HandleNewOrder {
    public void startOrder() {

        Order myOrder = new Order();
        //To make them available in all cases, declare them before
        Scanner myScanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            while (running) {
                System.out.println(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.");
                System.out.println("           ♡ DELI-cious Menu ♡             ");
                System.out.println(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.");
                pauseBeforeContinuing(1000); // Show the user it's loading options

                // Display menu
                System.out.println("""
                        1. Add Sandwich
                        2. Add Drink
                        3. Add Chips
                        4. Checkout
                        0. Cancel Order
                        """);

                System.out.print("Choose an option (0-4):\n ");
                System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                String userChoice = myScanner.nextLine().trim();

                pauseBeforeContinuing(1000);
                ;//visual delay

                // Validate input: must be a number between 0 and 4
                while (!userChoice.matches("[0-4]")) {
                    System.out.print("Invalid input. Please enter 0, 1, 2, 3, or 4: ");
                    userChoice = myScanner.nextLine().trim();
                }

                switch (userChoice) {
                    case "1":
                        CustomizeSandwich sandwichBuilder = new CustomizeSandwich();// instantiate the object that build our sandwich.
                        Sandwich sandwich = sandwichBuilder.build();//we call the build method and store it in sandwich variable
                        if (sandwich == null) {
                            break;
                        }
                        // ========== Confirm before adding sandwich ==========
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        System.out.println("Do you want to add this sandwich to your order? (Y): or press Enter to cancel: ");
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        String confirmSandwich = myScanner.nextLine().trim();
                        if (!confirmSandwich.equalsIgnoreCase("Y")) {
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            System.out.println("Sandwich not added.\n");
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            break;
                        }
                        myOrder.addSandwich(sandwich);
                        pauseBeforeContinuing(1000);
                        ;
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        System.out.println("Sandwich added!\n");
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        pauseBeforeContinuing(1000);
                        ;

                        //System.out.println( myOrder.sandwiches.toString());
                        break;
                    case "2":
                        AddDrink drinkAdder = new AddDrink();
                        Drink drink = drinkAdder.getDrink();
                        if (drink == null) {
                            break;
                        }
                        // ========== Confirm before adding drink ==========
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        System.out.println("Do you want to add this drink to your order? (Y): or press Enter to cancel:\n ");
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        String confirmDrink = myScanner.nextLine().trim();
                        if (!confirmDrink.equalsIgnoreCase("Y")) {
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            System.out.println("Drink not added.\n");
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            break;
                        }

                        myOrder.addDrink(drink);
                        pauseBeforeContinuing(1000);
                        ;
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        System.out.println("Drink added!\n");
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        pauseBeforeContinuing(1000);
                        ;


                        //System.out.println( myOrder.drinks.toString());
                        break;
                    case "3":
                        AddChips chipAdder = new AddChips();
                        Chips chips = chipAdder.getChips();
                        if (chips == null) {
                            break;
                        }
                        // ========== Confirm before adding chips ==========
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        System.out.println("Do you want to add these chips to your order? (Y): or press Enter to cancel:\n ");
                        System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                        String confirmChips = myScanner.nextLine().trim();
                        if (!confirmChips.equalsIgnoreCase("Y")) {
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            System.out.println("Chips not added.\n");
                            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-◦-◦-◦-◦-◦-");
                            break;
                        }
                        myOrder.addChips(chips);
                        pauseBeforeContinuing(1000);
                        ;
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        System.out.println("Chips added!\n");
                        System.out.println("✧✦✧✦✧✦✧✦✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✦✧");
                        pauseBeforeContinuing(1000);
                        ;

                        //System.out.println( myOrder.chips.toString());
                        break;
                    case "4":
                        // Validate order before proceeding
                        if (myOrder.getSandwiches().isEmpty() && myOrder.getDrinks().isEmpty() && myOrder.getChips().isEmpty()) {
                            pauseBeforeContinuing(1000);
                            ;
                            System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                            System.out.println(" You must add at least one item before checkout.\n");
                            System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                            pauseBeforeContinuing(1000);
                            ;

                            break;
                        }
                        CheckOutAndPrint checkout = new CheckOutAndPrint();
                        checkout.printReceipt(myOrder);

                        running = false;
                        break;
                    case "0":
                        pauseBeforeContinuing(1000);
                        ;
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                        System.out.println("Order cancelled. See you next time!\n");
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*｡..｡**｡..｡*✒*｡..｡*✎*｡..｡*✒");
                        pauseBeforeContinuing(1000);
                        ;
                        running = false;
                        break;
                    default:
                        pauseBeforeContinuing(1000);
                        ;
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*");
                        System.out.println("Invalid option\n"); //how to save the item user giving me into one order object or class
                        System.out.println(".｡*✎*｡..｡*✒*｡..｡**｡..｡*✍*");
                        pauseBeforeContinuing(1000);
                        ;

                        //add the user input to the order class
                }

            }
        }
    }
}

