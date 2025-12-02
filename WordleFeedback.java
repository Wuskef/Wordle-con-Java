/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
class WordleFeedback {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GRAY = "\u001B[37m"; 
    private static int WORD_LENGTH;



    private static String applyColor(String letter, String color) {
        return color + letter + ANSI_RESET;
    }

    public static String feedBackString(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder();
        int wordLength = guess.length();

        for (int i = 0; i < WORD_LENGTH; i++) {
            char letter = guess.charAt(i);
            
            if (letter == secretWord.charAt(i)) {
                feedback.append(applyColor(String.valueOf(letter), ANSI_GREEN));
            }
            else if (secretWord.contains(String.valueOf(letter))) {
                feedback.append(applyColor(String.valueOf(letter), ANSI_YELLOW));
            }
            else {
                feedback.append(applyColor(String.valueOf(letter), ANSI_GRAY));
            }
        }
        
        return feedback.toString();
    }
    }

