package com.connor.games;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import com.connor.games.HangmanLexicon;
/* Model in the MVC design pattern. Implements game logic */

public class Hangman {
    /* Instance variables */ 
    private String word;
    private ArrayList<Character> maskedLetters;
    private int badGuesses;
    private int guessesAllowed;
    private HashMap<Character,HashSet> letterLocations;
    private HashSet<Character> lettersGuessed;
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
        this.lettersGuessed = new HashSet<>();
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
        try {
            this.word = HangmanLexicon.getWord(3);
        } catch(Exception e) {
            System.exit(1);
        }
        this.prepareGame();
    }

    
    
    /* Returns true if letter is in word or false if not*/
    public boolean guess(char letter) {
        this.lettersGuessed.add(letter);
        if (this.letterLocations.keySet().contains(letter)) {
            HashSet<Integer> lettersUpdate = this.letterLocations.get(letter);
            for (Integer loc : lettersUpdate) {
                this.maskedLetters.set(loc,letter);
            }
            this.correctLettersGuessed.add(letter);
            return true;
        } else {
            this.badGuesses += 1;
            return false;
        }
    }

    public String getMaskedWord() {
        String result = "";
        for (int i = 0; i < this.maskedLetters.size(); i++) {
            result = result.concat(this.maskedLetters.get(i).toString());
            if (i != this.maskedLetters.size() - 1) {
                result += " ";
            }
        }
        return result;
    }

    public int getbadGuessesRemaining() {
        return this.guessesAllowed - this.badGuesses;
    }

    public boolean isGameOver() {
        return getbadGuessesRemaining() <= 0 || this.letterLocations.keySet().equals(this.lettersGuessed);
    }

    public boolean gameOutcome() {
        return this.letterLocations.keySet().equals(this.lettersGuessed);
    }

    public String compareMaskedWithActual() {
        return String.format("Masked: %s, Actual: %s", getMaskedWord(), this.word);
    }
}
