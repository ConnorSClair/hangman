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
        String[] base = new String[]{".","|","|","|","|","|__________"};
        String[] parts = new String[]{"_______","      |","     \\o/","      I","     / \\",""};
        
        String result = "";
        for (int i = 0; i < base.length; i++) {
            // if badGuesses is 0 I want for ALL i append ""
            // if badGuesses is 1, I want i = 0 
            // if badGuesses is 2, I want i = 0 and i = 1
            if (i < badGuesses) {
                result += String.join("",base[i],parts[i],"\n");
            } else {
                result += String.join("",base[i],"\n");
            }
        }
        System.out.println(result);
    }


}