package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        setInitialIngredients();
        getCurrentState();
        processAction();
        getCurrentState();
    }
    static final int WATER = 200;
    static final int MILK = 50;
    static final int COFFEE_BEANS = 15;

    static Scanner scanner = new Scanner(System.in);
    static int currentWater, currentMilk, currentCoffeeBeans, currentDisposableCups, currentMoney;

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

    static void setInitialIngredients() {
        currentWater = 400;
        currentMilk = 540;
        currentCoffeeBeans = 120;
        currentDisposableCups = 9;
        currentMoney = 550;
    }

    static void getCurrentState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", currentWater);
        System.out.printf("%d of milk%n", currentMilk);
        System.out.printf("%d coffee beans%n", currentCoffeeBeans);
        System.out.printf("%d of disposable cups%n", currentDisposableCups);
        System.out.printf("%d of money%n", currentMoney);
    }

    static void processAction() {
        System.out.println("Write action (buy, fill, take):");
        switch (scanner.nextLine()) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }

    static void makeCoffee(int water, int milk, int coffeeBeans, int money) {
        currentWater -= water;
        currentMilk -= milk;
        currentCoffeeBeans -= coffeeBeans;
        currentMoney += money;
        currentDisposableCups--;
    }

    static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        currentWater += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk do you want to add");
        currentMilk += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans do you want to add:");
        currentCoffeeBeans += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        currentDisposableCups += Integer.parseInt(scanner.nextLine());
    }

    static void take() {
        currentMoney = 0;
        System.out.printf("I gave you $%d%n", currentMoney);
    }
}
