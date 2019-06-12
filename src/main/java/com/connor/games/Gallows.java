package com.connor.games;

import java.util.ArrayList;
import java.util.Hashtable;

public class Gallows {


    /*  ._______
        |      |
        |     \o/
        |      I
        |     / \
        |__________"*/
    public static void view(int badGuesses) {
        String[] baseLines = new String[]{".","|","|","|","|","|__________"};
        String[][] parts = new String[][]{new String[]{"_______"},new String[]{"      |"},
            new String[]{"     \\","o","/"},new String[]{"      I"},new String[]{"     /"," \\"}, new String[]{}};
        String output = "";
        int count = 0;
        // add parts until count reaches badGuesses
        for (int line = 0; line < baseLines.length; line++) {
            // e.g. new String[][]{new String[]{"_____"},...,new String[]{".","    ","m"}}
            output += baseLines[line];
            for (int i = 0; i < parts[line].length; i++) {
                if (count < badGuesses) {
                    output += parts[line][i];
                    count += 1;
                } else {
                    break;
                }
            }
            if (line < baseLines.length - 1) {
                output += "\n";
            }
        }
        System.out.println(output);
    }

    public static void IncorrectLetters(ArrayList<Character> letters) {
        String output = "";
        int strikeThrough = 0x0338;
        for (int i = 0; i < letters.size(); i++) {
            char letter = letters.get(i);
            output += String.format("%c%c",letters.get(i),(char)strikeThrough);
            if (i < letters.size() - 1) {
                output += " ";
            }
        }
        System.out.println(output);
    }


}