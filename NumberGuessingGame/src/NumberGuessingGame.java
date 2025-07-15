import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create Scanner object
        Random myRandom = new Random(); // create Random object

        int number = myRandom.nextInt(101); // Random number between 0–100
        int attempts = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Type a number between 0 and 100, or type 'quit' to exit.");

        while (true) { // We use an infinite loop
            System.out.print("Choose a number: ");
            String userInput = input.next(); // Read as String first

            if (userInput.equalsIgnoreCase("quit")) { // If the user enter quit the game stops
                System.out.println("Game exiting...");
                break;
            }

            try {
                int enteredNumber = Integer.parseInt(userInput); // Convert our String to number
                attempts++;

                if (enteredNumber == number) { // This will display if the user choose the correct number
                    System.out.println("✅ Correct guess! 🎉");
                    System.out.println("You got it in " + attempts + " tries.");
                    break;
                } else {
                    System.out.println("❌ Wrong Guess!"); // This will display if the user choose the wrong number

                    if (enteredNumber > number) {
                        System.out.println("📉 Too high");
                    } else {
                        System.out.println("📈 Too low");
                    }

                    System.out.println("🔁 Let's try again!");
                }
                // This handles an error if the user entered invalid input
                // For example a letter instead of a number
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a number or type 'quit'.");
            }
        }

        input.close();
    }
}
