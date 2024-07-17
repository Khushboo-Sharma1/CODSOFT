import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_NUMBER = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        
        do {
            int generatedNumber = random.nextInt(MAX_NUMBER) + 1;
            int attempts = 0;
            boolean isGuessed = false;
            System.out.println("I have generated a number between 1 and " + MAX_NUMBER + ". Can you guess it?");
            
            while (attempts < MAX_ATTEMPTS && !isGuessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    isGuessed = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!isGuessed) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The number was: " + generatedNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
