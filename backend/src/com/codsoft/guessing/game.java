package com.codsoft.guessing;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Let's play guessing game");
        System.out.print("Enter range (e.g., 100): ");
        int range = obj.nextInt();
        int guess_num = (int) (Math.log(range) / Math.log(2));
        int target = (int)(Math.random() * range);

        for (int i = 0; i < guess_num; i++) {
            System.out.print("Guess the number: ");
            int usernum = obj.nextInt();
            if (usernum > target) {
                System.out.println("Too high.");
            } else if (usernum < target) {
                System.out.println("Too low.");
            } else {
                System.out.println("🎉 Correct! You win.");
                return;
            }
        }

        System.out.println("❌ Out of guesses. The number was: " + target);
        System.out.println("Thanks for playing!");
    }
}
