package CODESOFT;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7; // You can change this
        int lowerBound = 1;
        int upperBound = 100;
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            totalRounds++;
            System.out.println("\n🔢 Round " + totalRounds + " begins!");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Please enter a valid number.");
                    continue;
                }

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("⚠️ Your guess is out of range!");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("📈 Too low!");
                } else {
                    System.out.println("📉 Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("😞 You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n📊 Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thank you for playing! 🎮");

        scanner.close();
    }
}

