# DELI-cious

## Description
The motivation behind this project was to practice Java object-oriented programming and user input handling in a fun, interactive way.

I built this app to see how much I have learned about creating Java applications that take user input from the console and build complex objects based on choices.

By following a step-by-step sandwich customization process,

I applied concepts like class instantiation, working with lists of objects, input validation, loops, conditionals, and CLI (Command Line Interface) design.

My application allows users to build a custom sandwich by choosing bread type, size, toasted option, premium meats and cheeses with extra options, regular toppings, sauces, and sides.

The app collects all inputs, creates the corresponding objects (Meat, Cheese, Topping, Sauces, Sides), and returns a fully constructed Sandwich object.

The user can add multiple meats and cheeses, decide on extras, and skip optional ingredients easily.

## Table of Content
N/A

Installation
N/A

## Usage
### To use the application:

- Open your Java IDE (like IntelliJ or Eclipse) or use the terminal/command prompt.

- Navigate to the project folder.

- Compile all Java files:

bash
Copy
Edit
javac *.java
Run your main class that calls the build() method:

bash
Copy
Edit
java YourMainClass

=> Follow the prompts in the console to customize your sandwich.

=> Example interaction: Choose bread (White/Wheat/Rye/Wrap), Enter size (4/8/12), Choose if toasted (yes/no), Enter meats (comma-separated), and choose if extra meat, Add cheeses (looped prompt) with size and extra options, Add regular toppings (comma-separated)
Add sauces (comma-separated), add sides (comma-separated), The sandwich will be constructed with your selections and ready to use in your program.

## Screenshots

  *Home Screen/Order Screen

![home_order_screen reduce.gif](Resources/videos_gif/home_order_screen%20reduce.gif)

  *Add Chips/Drink/CheckOut

![addChipsDrinkCheckout_reduced.gif](Resources/videos_gif/addChipsDrinkCheckout_reduced.gif)

  *Add Cheese 

![addSandwich_cheese](Resources/videos_gif/addSandwich_cheese_reduced.gif)

  *AddTopping

![addSandwich_regutopping](Resources/videos_gif/addSandwich_regutopping-reduce.gif)


  *Diagrams

![Diagram1](Resources/images/reduce%20diag1.png)

![Diagram3](Resources/images/tree.png)



## Console Flow

Sandwich Summary

## Credit
Thanks to my instructor, tutors, peers, extensive Googling, and AI assistance, who helped me understand Java concepts, handle user input, and design the CLI flow. Their support was invaluable in helping me complete this project and build a functional interactive sandwich shop app.

## Interesting Piece of Code
One interesting part of my code is the build() method, which uses Scanner to interactively collect user input for each sandwich component, and dynamically creates objects for each choice. It handles multiple entries for meats and cheeses, validates inputs, and loops for adding multiple cheeses until the user is done.

java
Copy
Edit
```
public Sandwich build() {
    Scanner myScanner = new Scanner(System.in);

    // Get bread and size
    System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
    String bread = myScanner.nextLine();

    System.out.print("Enter the size you want (4/8/12): ");
    String sizeChoice = myScanner.nextLine();

    // Ask if toasted
    boolean toasted = false;
    System.out.print("Would you like it toasted? (yes/no): ");
    String toastInput = myScanner.nextLine();
    toasted = toastInput.equalsIgnoreCase("yes");

    // (continue  logic...)
}
This method is a great demonstration of how to build a complex object through user input, conditionals, loops, and OOP principles.
```

## License
N/A

