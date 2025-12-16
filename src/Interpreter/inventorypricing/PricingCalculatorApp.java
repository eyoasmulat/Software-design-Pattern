// PricingCalculatorApp.java 
package inventorypricing;

import java.util.Scanner;

public class PricingCalculatorApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Basic Inventory Pricing Calculator (Interpreter Pattern) ===");
        System.out.println("This program calculates total price using dynamic formulas.\n");

        // Pre-build the ASTs once (they are reusable!)
        Expression formula1 = buildFormula1(); // (BASE_PRICE * QUANTITY) + TAX
        Expression formula2 = buildFormula2(); // ((BASE_PRICE * QUANTITY) + TAX) - DISCOUNT
        Expression formula3 = buildFormula3(); // Apply percentage discount then add tax
        Expression formula4 = buildFormula4(); // Formula 2 + SHIPPING_FEE

        boolean continueCalculating = true;
        while (continueCalculating) {
            PricingContext context = new PricingContext();

            // Collect user input
            System.out.println("Enter item details:");
            context.setVariable("BASE_PRICE", readDouble("Base Price per unit: "));
            context.setVariable("QUANTITY", readDouble("Quantity: "));
            context.setVariable("TAX", readDouble("Flat Tax Amount: "));
            context.setVariable("DISCOUNT", readDouble("Flat Discount Amount: "));
            context.setVariable("DISCOUNT_PERCENT", readDouble("Discount Percentage (e.g., 10 for 10%): "));
            context.setVariable("SHIPPING_FEE", readDouble("Shipping Fee: "));

            System.out.println("\n--- Available Pricing Formulas ---");
            System.out.println("1: (Base * Qty) + Tax");
            System.out.println("2: ((Base * Qty) + Tax) - Discount");
            System.out.println("3: ((Base * Qty) * (1 - Discount%)) + Tax");
            System.out.println("4: Formula 2 + Shipping Fee");

            int choice = readInt("Choose formula (1-4): ", 1, 4);

            double result = 0;
            String formulaDescription = "";

            switch (choice) {
                case 1:
                    result = formula1.interpret(context);
                    formulaDescription = "(BASE_PRICE * QUANTITY) + TAX";
                    break;
                case 2:
                    result = formula2.interpret(context);
                    formulaDescription = "((BASE_PRICE * QUANTITY) + TAX) - DISCOUNT";
                    break;
                case 3:
                    result = formula3.interpret(context);
                    formulaDescription = "((BASE_PRICE * QUANTITY) * (1 - DISCOUNT_PERCENT/100)) + TAX";
                    break;
                case 4:
                    result = formula4.interpret(context);
                    formulaDescription = "Formula 2 + SHIPPING_FEE";
                    break;
                default:
                    formulaDescription = "Unknown formula";
                    break;
            }
            System.out.printf("\nFormula Used: %s\n", formulaDescription);
            System.out.printf("Total Price: %.2f\n\n", result);

            System.out.print("Do you want to calculate another item? (y/n): ");
            continueCalculating = scanner.nextLine().trim().equalsIgnoreCase("y");
        }

        System.out.println("Thank you for using the Pricing Calculator!");
        scanner.close();
    }

    // Helper methods to build ASTs (clean and reusable)
    private static Expression buildFormula1() {
        return new PlusExpression(
                new MultiplyExpression(
                        new VariableExpression("BASE_PRICE"),
                        new VariableExpression("QUANTITY")),
                new VariableExpression("TAX"));
    }

    private static Expression buildFormula2() {
        return new SubtractExpression(
                new PlusExpression(
                        new MultiplyExpression(
                                new VariableExpression("BASE_PRICE"),
                                new VariableExpression("QUANTITY")),
                        new VariableExpression("TAX")),
                new VariableExpression("DISCOUNT"));
    }

    private static Expression buildFormula3() {
        return new PlusExpression(
                new MultiplyExpression(
                        new MultiplyExpression(
                                new VariableExpression("BASE_PRICE"),
                                new VariableExpression("QUANTITY")),
                        new SubtractExpression(
                                new NumberExpression(1.0),
                                new DivideExpression(
                                        new VariableExpression("DISCOUNT_PERCENT"),
                                        new NumberExpression(100.0)))),
                new VariableExpression("TAX"));
    }

    private static Expression buildFormula4() {
        return new PlusExpression(
                buildFormula2(), // Reuse Formula 2!
                new VariableExpression("SHIPPING_FEE"));
    }

    // Safe input helpers
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Please enter a number between %d and %d.\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}