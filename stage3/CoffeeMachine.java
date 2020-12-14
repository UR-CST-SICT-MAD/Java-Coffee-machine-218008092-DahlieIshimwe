package machine;
import java.util.Scanner;



public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();

        cupCalculator(water, milk, beans, cups);
    }

    public static void cupCalculator(int water, int milk, int beans, int cups){
        int water_cups = water / 200;
        int milk_cups = milk / 50;
        int beans_cups = beans / 15;
        int min_cups = water_cups;
        if (milk_cups < min_cups && beans_cups > milk_cups){
            min_cups = milk_cups;
        }
        else if (milk_cups > min_cups && beans_cups < milk_cups){
            min_cups = beans_cups;
        }
        if (min_cups == cups){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if(min_cups < cups){
            System.out.format("No, I can make only %d cup(s) of coffee\n", min_cups);
        }
        else if(min_cups > cups){
            System.out.format("Yes, I can make that amount of coffee (and even %d more than that)", min_cups - cups);
        }
    }
}
