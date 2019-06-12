package com.connor.games;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Random;
/* Model in the MVC design pattern. Implements game logic */

public class Hangman {
    /* Instance variables */ 
    private String word;
    private ArrayList<Character> maskedLetters;
    private int badGuesses;
    private int guessesAllowed;
    private HashMap<Character,HashSet<Integer>> letterLocations;
    private LinkedHashSet<Character> incorrectLettersGuessed;
    private HashSet<Character> correctLettersGuessed;

    private void buildLetterLocations() {
        this.letterLocations = new HashMap<>();
        for (int i = 0; i < this.word.length(); i++) {
            char letter = this.word.charAt(i);
            if (!(this.letterLocations.containsKey(letter))) {
                this.letterLocations.put(letter,new HashSet<Integer>());
            }
            this.letterLocations.get(letter).add(i);
        }
    }

    private void buildLettersGuessed() {
        this.incorrectLettersGuessed = new LinkedHashSet<>();
        this.correctLettersGuessed = new HashSet<>();
    }
    
    private void buildMaskedLetters() {
        this.maskedLetters = new ArrayList<>();
        for (int i = 0; i < this.word.length(); i++) {
            char underScore = '_';
            this.maskedLetters.add(underScore);
        }
    }

    private void prepareGame() {
        buildLetterLocations();
        buildLettersGuessed();
        this.guessesAllowed = 8;
        this.badGuesses = 0;
        buildMaskedLetters();
    }

    public Hangman() {
        Random random = new Random();
        int wordChoice = random.nextInt(10);
        try {
            this.word = HangmanLexicon.getWord(wordChoice);
        } catch(Exception e) {
            System.exit(1);
        }
        this.prepareGame();
    }

    /* Handles a guess. Returns true if letter is in word or false if not*/
    public boolean guess(char letter) {

        if (this.letterLocations.keySet().contains(letter)) {
            // correct guess
            HashSet<Integer> lettersUpdate = this.letterLocations.get(letter);
            for (Integer loc : lettersUpdate) {
                this.maskedLetters.set(loc,letter);
            }
            this.correctLettersGuessed.add(letter);
            return true;
        } else if (this.correctLettersGuessed.contains(letter)) {
            // do nothing
            return true;
        } else if (this.incorrectLettersGuessed.contains(letter)){
            // do nothing
            return false;
        } else {
            this.badGuesses += 1;
            this.incorrectLettersGuessed.add(letter);
            return false;
        }
    }

    /* Returns the masked word with spaces for printing purposes (e.g. looks like this _ _ D _ _ A _ */ 
    public String printMaskedWord() {
        String result = "";
        for (int i = 0; i < this.maskedLetters.size(); i++) {
            result = result.concat(this.maskedLetters.get(i).toString());
            if (i != this.maskedLetters.size() - 1) {
                result += " ";
            }
        }
        return result;
    }

    public String getMaskedWord() {
        String result = "";
        for (int i = 0; i < this.maskedLetters.size(); i++) {
            result = result.concat(this.maskedLetters.get(i).toString());
        }
        return result;
    }

    public String getWord() {
        return this.word;
    }
 
    public int getBadGuessesRemaining() {
        return this.guessesAllowed - this.badGuesses;
    }
    
    public int getBadGuesses() {
        return this.badGuesses;
    }

    /* Game is over and returns true if no more incorrect guesses remaining or player has correctly guessed the word, otherwise retursn false*/
    public boolean isGameOver() {
        return getBadGuessesRemaining() <= 0 || this.letterLocations.keySet().equals(this.correctLettersGuessed);
    }

    /* Returns true (i.e. wins game) if all the letters in the word and guessed, otherwise false*/ 
    public boolean wonGame() {
        return this.letterLocations.keySet().equals(this.correctLettersGuessed);
    }

    public String compareMaskedWithActual() {
        return String.format("Masked: %s, Actual: %s", getMaskedWord(), this.word);
    }

    public LinkedHashSet<Character> getIncorrectLettersGuessed() {
        return this.incorrectLettersGuessed;
    }

}
