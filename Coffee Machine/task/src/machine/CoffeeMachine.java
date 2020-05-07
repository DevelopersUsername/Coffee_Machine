package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        getCurrentIngredients();
        calculateCupsOfCoffee();
    }
    static final int WATER = 200;
    static final int MILK = 50;
    static final int COFFEE_BEANS = 15;

    static int currentWater, currentMilk, currentCoffeeBeans;

    static void calculateIngredients() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.printf("For %d cups of coffee you will need: %n %d ml of water %n %d ml of milk %n %d g of coffee beans",
                count, count * WATER, count * MILK, count * COFFEE_BEANS);
    }

    static void calculateCupsOfCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int count = Integer.parseInt(scanner.nextLine());

        int possibleCupsOfCoffee = getPossibleCupsOfCoffee();
        if (possibleCupsOfCoffee == count) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCupsOfCoffee > count) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", possibleCupsOfCoffee - count);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", possibleCupsOfCoffee);
        }
    }

    static int getPossibleCupsOfCoffee() {
        return Math.min(Math.min(currentWater / WATER, currentMilk / MILK), currentCoffeeBeans / COFFEE_BEANS);
    }

    static void getCurrentIngredients() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        currentWater = Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk the coffee machine has: ");
        currentMilk = Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        currentCoffeeBeans = Integer.parseInt(scanner.nextLine());
    }
}
