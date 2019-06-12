package com.connor.games;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.lang.Iterable;

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

    public static void IncorrectLetters(LinkedHashSet<Character> letters) {
        String output = "";
        int strikeThrough = 0x0338;
        Iterator<Character> iterator = letters.iterator();
        while (true) {
            if (iterator.hasNext()) {
                char letter = iterator.next();
                output += String.format("%c%c",letter,(char)strikeThrough);
                if (iterator.hasNext()) {
                    output += " ";
                } 
            } else {
                break;
            }
        }
        System.out.println(output);
    }


}