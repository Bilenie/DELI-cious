package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SandwichTest {

    @Test
    public void testAddMeatAndGetPriceWithoutExtra() {
        // Arrange
        Sandwich sandwich = new Sandwich("white", "4", false);
        Meat meat = new Meat("4", false,  "Ham");

        // Act
        sandwich.addMeats(meat);
        double total = sandwich.getPrice();

        // Assert
        assertEquals(6.00, total, 0.01); // no extra charge
    }

    @Test
    public void testAddMeatAndGetPriceWithExtra_4inch() {
        // Arrange
        Sandwich sandwich = new Sandwich("white", "4", false);
        Meat meat = new Meat("4", true, "Turkey");

        // Act
        sandwich.addMeats(meat);
        double total = sandwich.getPrice();

        // Assert
        assertEquals(7.00, total, 0.01); // $5.50 + 1 + $0.50 extra
    }

    @Test
    public void testAddMultipleMeatsWithAndWithoutExtra() {
        // Arrange
        Sandwich sandwich = new Sandwich("wheat", "8", true);
        Meat meat1 = new Meat("8", true,  "Chicken");
        Meat meat2 = new Meat("8", false, "Ham");

        // Act
        sandwich.addMeats(meat1);//10
        sandwich.addMeats(meat2);//9
        double total = sandwich.getPrice();

        // Assert
        assertEquals(12.00, total, 0.01); // $7.00 + $1.00 extra + $2.00meat
    }

}