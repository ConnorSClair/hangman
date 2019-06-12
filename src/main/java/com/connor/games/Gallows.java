package com.connor.games;

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
        String result = "";
        int count = 0;
        // add parts until count reaches badGuesses
        for (int line = 0; line < baseLines.length; line++) {
            // e.g. new String[][]{new String[]{"_____"},...,new String[]{".","    ","m"}}
            result += baseLines[line];
            for (int i = 0; i < parts[line].length; i++) {
                if (count < badGuesses) {
                    result += parts[line][i];
                    count += 1;
                } else {
                    break;
                }
            }
            result += "\n";
        }
        System.out.println(result);
    }


}