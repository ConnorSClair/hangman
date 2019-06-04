package com.connor.games;
import java.util.Scanner;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Hangman h = new Hangman();
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String stuff = s.next();
            System.out.println(stuff);
        }
    }
}
