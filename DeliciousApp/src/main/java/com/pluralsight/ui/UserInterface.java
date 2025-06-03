package com.pluralsight.ui;

import com.pluralsight.models.Order;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.*;

public class UserInterface {

    //Lets people type what they want	“Do you want bread?” “White or wheat?” any interaction with user goes here.
//method to display Home scree
    public void homeScreen() {

        boolean exit = false;
        Order myOrder = new Order();

        while (!exit) {
            System.out.println(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.");
            System.out.println("   ♡ Place for DELI-cious Sandwiches ♡   ");
            System.out.println(".｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡..｡*♡*｡.");
            waitForEnter();
            // Show loading spinner to simulate processing
           pauseBeforeContinuing(1500);

            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-");
            System.out.println("Please select an option:");
            System.out.println("◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦-◦◦-");
            System.out.println("  1) Start a New Order");
            System.out.println("  0) Exit the Shop\n");

            // Small spinner for better feedback after prompt
            showLoadingSpinner(1000);
            System.out.print(" Your choice => \n");

            Scanner myScanner = new Scanner(System.in);
            String choice = myScanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢");
                    System.out.println("Great! Let’s start your order...");
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢");
                    pauseBeforeContinuing(2000);
                    HandleNewOrder newOrder = new HandleNewOrder();
                    newOrder.startOrder();
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢");
                    System.out.println("\nThank You for your Order! Returning to home screen...\n");
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢");

                    pauseBeforeContinuing(1500);
                    break;

                case "0":
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆");
                    System.out.println("\nThanks You for visiting DELI-cious! Goodbye! ");
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆");

                    exit = true;
                    break;

                default:
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢");
                    System.out.println("\nOops! That’s not a valid option. Please try again.\n");
                    System.out.println("♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆♢◆◆♢♢◆♢◆♢◆♢◆◆♢◆♢◆♢◆♢◆♢◆♢◆♢");

                    // Loop will continue automatically for retry
            }
        }

    }
}
