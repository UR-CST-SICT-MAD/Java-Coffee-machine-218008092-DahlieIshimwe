package machine;
import java.util.HashMap;
import java.util.Scanner;
public class CoffeeMachine {
    private static final HashMap recipes = new HashMap() {{
        put(1, new HashMap<String, Integer>() {{
            put("water", 250);
            put("beans", 16);
            put("milk", 0);
            put("cost", 4);
        }});
        put(2, new HashMap<String, Integer>() {{
            put("water", 350);
            put("beans", 20);
            put("milk", 75);
            put("cost", 7);
        }});
        put(3, new HashMap<String, Integer>() {{
            put("water", 200);
            put("beans", 12);
            put("milk", 100);
            put("cost", 6);
        }});
    }};
    private static int hasMoney = 550;
    private static int hasWater = 400;
    private static int hasMilk = 540;
    private static int hasCoffeeBeans = 120;
    private static int hasCups = 9;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String action;
            while (true) {
                printActions();
                action = scanner.nextLine().toLowerCase();
                if (action.equals("exit")) return;
                doAction(action, scanner);
            }
        }
    }
    private static void doAction(String action, Scanner scanner) {
        System.out.println();
        switch (action) {
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - " +
                        "cappuccino, back - to main menu:");
                String choice = scanner.nextLine().toLowerCase();
                if (choice.equals("back")) return;
                HashMap<String, Integer> recipe =
                        (HashMap<String, Integer>) recipes.get(Integer.valueOf(choice));
                if (hasMilk < recipe.get("milk")) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (hasWater < recipe.get("water")) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (hasCoffeeBeans < recipe.get("beans")) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    hasCups -= 1;
                    hasMoney += recipe.get("cost");
                    hasMilk -= recipe.get("milk");
                    hasWater -= recipe.get("water");
                    hasCoffeeBeans -= recipe.get("beans");
                }
                break;
            }
            case "fill": {
                System.out.println("Write how many ml of water do you want to add:");
                hasWater += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                hasMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                hasCoffeeBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to " +
                        "add: ");
                hasCups += scanner.nextInt();
                break;
            }
            case "take": {
                System.out.printf("I gave you $%d\n", hasMoney);
                hasMoney = 0;
                break;
            }
            case "remaining": {
                printMachineHasTotal();
                break;
            }
        }
    }
    private static void printActions() {
        System.out.print("Write action (buy, fill, take, remaining, exit):");
    }
    private static void printMachineHasTotal() {
        System.out.println(String.format("The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                        "$%d of money\n",
                hasWater, hasMilk, hasCoffeeBeans, hasCups, hasMoney));
        System.out.println("Hello World!");
    }
}