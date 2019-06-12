package com.connor.games;
import java.util.Scanner;

public class HangmanController {
    Hangman hangman;

    public static void main(String[] args) {
       playHangman();
    }

    private HangmanController() {
        this.hangman = new Hangman();        
    }

    private static void playHangman() {
        System.out.println("Welcome to Hangman!");
        HangmanController controller = new HangmanController();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            Gallows.view(controller.hangman.getBadGuesses());
            System.out.println(String.format("The word now looks like this: %s",controller.hangman.printMaskedWord()));
            System.out.println(String.format("You have %d guesses left.", controller.hangman.getBadGuessesRemaining()));
            controller.gameTurn(userInput);
            if (controller.hangman.isGameOver()) {
                if (controller.hangman.wonGame()) {
                    System.out.println(String.format("You guessed the word: %s",controller.hangman.getMaskedWord()));
                    System.out.println("You win.");
                } else {
                    Gallows.view(controller.hangman.getBadGuesses());
                    System.out.println("You're completely hung.");
                    System.out.println(String.format("The word was: %s",controller.hangman.getWord()));
                    System.out.println("You lose.");
                }
                userInput.close();
                break;
            }
        }
    }

    private void gameTurn(Scanner userInput) {
        System.out.println("Your guess: ");
        String line = userInput.next();
        if (this.parseInput(line)) {
            char letter = Character.toUpperCase(line.charAt(0));
            if (this.hangman.guess(letter)) {
                System.out.println(String.format("That guess is correct.", letter));
            } else {
                System.out.println(String.format("There are no %c's in this word.", letter));
            }
        } else {
            System.out.println("invalid guess");
        }
    }

    private boolean parseInput(String input) {
        if (input.length() > 1) {
            return false;
        } else if (Character.isLetter(input.charAt(0))) {
                return true;
        } else {
            return false;
        }
    }

}