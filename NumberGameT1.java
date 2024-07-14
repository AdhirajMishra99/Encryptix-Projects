import java.util.Random;
import java.util.Scanner;

public class NumberGameT1 {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 10;
        int maxAttempts = 5;

        Random rand = new Random();
        Scanner scanner= new Scanner(System.in);
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean won = false;

            while (attempts < maxAttempts) {
                attempts++;
                System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ":");
                try {
                    int guess = scanner.nextInt();

                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("Invalid input. Please enter a number within the specified range.");
                        continue;
                    }

                    if (guess == secretNumber) {
                        System.out.println("Congratulations! You guessed the secret number in " + attempts + " attempts.");
                        won = true;
                        score++;
                        break;
                    } else if (guess < secretNumber) {
                        System.out.println("Too low, try again!");
                    } else {
                        System.out.println("Too high, try again!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); 
                }
            }

            if (!won) {
                System.out.println("Sorry, you ran out of attempts! The secret number is " + secretNumber + ".");
            }

            System.out.println("Your current score is " + score + ".");
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();

            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your score is " + score + ".");
    }
}