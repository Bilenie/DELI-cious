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
(Optional: Add screenshots or GIFs here if you have them)
### Home Screen
![Home Screen](Resources/videos_gif/homescreen-ezgif.com-video-to-gif-converter.mp4)

### Order Screen

  *Add Drinks/*Add Chips

![Order Drink,Checkout and Chips](src/main/Resources/videos_gif/addChipsDrinkCheckout-ezgif.com-video-to-gif-converter.gif)

  *Add Sauce

![Add Sauce](src/main/Resources/videos_gif/addSandwich_sauce-ezgif.com-video-to-gif-converter.mp4)

  
  *Add Meat

![Add Meat](src/main/Resources/videos_gif/addSandwich_meat-ezgif.com-video-to-gif-converter.mp4)

  *Add Cheese

![Add Cheese](src/main/Resources/videos_gif/addSandwich_cheese-ezgif.com-animated-gif-maker.gif)

  *Checkout

![Add Side ](src/main/Resources/videos_gif/addSandwich_side-ezgif.com-video-to-gif-converter.mp4)


  *Cancel Order

![Cancel Order](src/main/Resources/videos_gif/orderCancel-ezgif.com-video-to-gif-converter.mp4)

*Add Sandwich

![Topping Reg](src/main/Resources/videos_gif/addSandwich_regutopping-ezgif.com-video-to-gif-converter.mp4)

  *Diagrams
  
![Diagram1](src/main/Resources/images/2025-05-30T03_07_05.png)

![Diagram2](src/main/Resources/images/2025-05-30T02_35_34.png)

![Diagram3](src/main/Resources/images/2025-05-30T02_53_21.png)


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

