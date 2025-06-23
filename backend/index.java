import java.awt.*;
import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Lets play guessing game");
        System.out.println("Type the range from 0 to ");
        int range = obj.nextInt();
        System.out.println("the system has chosen a number from 0 to "+range+". Now guess the number");
        int guess_num = (int) (Math.log(range)/Math.log(2));
        int target = (int)(Math.random()*range);
        for(int i = 0; i < guess_num; i++) {
            System.out.println("guess the number:");
            int usernum = obj.nextInt();
            if (usernum > target) {
                System.out.println("target is lesser than your number.");
            } else if (target > usernum) {
                System.out.println("target is greater than guessed number");
            } else{
                System.out.println("yayyy! you have found the number");
                break;
            }
        }
        System.out.println("oops! you ran out of guesses. The answer is "+target);
        System.out.println("thank you for playing");
    }
}