package com.connor.games;
import java.util.Scanner;
import com.connor.games.Hangman;

public class HangmanController {

    Hangman hangman;

    
    public static void main(String[] args) {
        System.out.println("HEY");
        HangmanController controller = new HangmanController();
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String line = userInput.next();
            controller.gameTurn(line);
            if (controller.hangman.isGameOver()) {
                System.out.println(controller.hangman.compareMaskedWithActual());
                break;
            }
        }
    }

    private HangmanController() {
        this.hangman = new Hangman();        
    }

    private void gameTurn(String input) {
        if (this.parseInput(input)) {
            char letter = input.charAt(0);
            System.out.println(String.format("You guessed the letter %c", letter));
            if (this.hangman.guess(letter)) {
                System.out.println(String.format("Letter %c is in the word", letter));
            } else {
                System.out.println(String.format("Letter %c is not in the word", letter));
            }
            System.out.println(this.hangman.getMaskedWord());
            System.out.println(String.format("Remaining Guesses %d",this.hangman.getbadGuessesRemaining()));
        } else {
            System.out.println("invalid input");
        }


    }

    private boolean parseInput(String input) {
        if (input.length() > 1) {
            return false;
        } else if (Character.isLetter(input.charAt(0))) {
            if (Character.isLowerCase(input.charAt(0))) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}