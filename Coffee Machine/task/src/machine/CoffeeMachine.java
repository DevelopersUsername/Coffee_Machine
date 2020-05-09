package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        setInitialIngredients();
        processAction();
    }

    static Scanner scanner = new Scanner(System.in);
    static int currentWater, currentMilk, currentCoffeeBeans, currentDisposableCups, currentMoney;
    static boolean machineWorked;

    static void setInitialIngredients() {
        currentWater = 400;
        currentMilk = 540;
        currentCoffeeBeans = 120;
        currentDisposableCups = 9;
        currentMoney = 550;
        machineWorked = true;
    }

    static void processAction() {
        while (machineWorked) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
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
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    System.out.println("Unknown action");
            }
        }
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.nextLine()) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                processAction();
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    static void makeCoffee(int water, int milk, int coffeeBeans, int money) {

        if (currentWater < water) {
            System.out.println("Sorry, not enough water!");
        } else if (currentMilk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (currentCoffeeBeans < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (currentDisposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {

            System.out.println("I have enough resources, making you a coffee!");

            currentWater -= water;
            currentMilk -= milk;
            currentCoffeeBeans -= coffeeBeans;
            currentMoney += money;
            currentDisposableCups--;
        }
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

    static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", currentWater);
        System.out.printf("%d of milk%n", currentMilk);
        System.out.printf("%d coffee beans%n", currentCoffeeBeans);
        System.out.printf("%d of disposable cups%n", currentDisposableCups);
        System.out.printf("%d of money%n", currentMoney);
    }

    static void exit() {
        machineWorked = false;
    }
}
