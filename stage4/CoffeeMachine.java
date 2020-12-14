package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int money = 550;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cups = 9;

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        coffeeMachineState();

        System.out.println("Write action (buy, fill, take)");
        String action = scanner.nextLine();

        switch (action) {
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

    public static void take() {
        System.out.println("I gave you " + money);
        money = 0;
        coffeeMachineState();
    }


    public static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
        coffeeMachineState();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2- latte, 3 - cappuccino");
        int action = scanner.nextInt();

        switch (action) {
            case 1:
                makeEspresso();
                break;

            case 2:
                makeLatte();
                break;

            case 3:
                makeCappuccino();
                break;
        }
    }

    public static void makeCappuccino() {
        water -= 200;
        milk -= 100;
        coffee -= 12;
        cups -= 1;
        money += 6;
        coffeeMachineState();
    }

    public static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffee -= 20;
        cups -= 1;
        money += 7;
        coffeeMachineState();
    }

    public static void makeEspresso() {
        water -= 250;
        coffee -= 16;
        cups -= 1;
        money += 4;
        coffeeMachineState();
    }

    public static void coffeeMachineState() {
        System.out.println("The coffee machine has: \n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffee + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money\n");

    }



}
