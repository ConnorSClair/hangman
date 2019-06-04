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
        Scanner s = new Scanner(System.in);
        String stuff = s.next();
        System.out.println(stuff);
    }
}
