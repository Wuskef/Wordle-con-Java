/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11;
import java.io.*; 
import java.util.*;
/**
 *
 * @author User
 */
public class WordleGame {
    private static final int MAX_TRIES = 6;
    private static final int WORD_LENGTH = 5;
    private List<String> fileWords;
    private String secretWord;
    private int remainingAttempts;
    private List<String> triesHistory;

    public WordleGame(String[] fileWords) {
        this.fileWords = Arrays.asList(fileWords);
        this.secretWord = selectRandomWord(this.fileWords);
        this.remainingAttempts = MAX_TRIES;
        this.triesHistory = new ArrayList<>();
    }

    WordleGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Wordle!");
        
        while (remainingAttempts > 0) {
            showTriesHistory();
            String userInput = getUserInput(scanner);
            triesHistory.add(userInput);
            
            if (userInput.equalsIgnoreCase(secretWord)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + secretWord);
                return;
            } else {
                remainingAttempts--;
                System.out.println("Intento incorrecto. Te quedan " + remainingAttempts + " intentos.");
                System.out.println(feedBackString(userInput));
            }
        }
        
        System.out.println("¡Se han agotado los intentos! La palabra era: " + secretWord);
    }

    private void showTriesHistory() {
        System.out.println("Historial de intentos: " + triesHistory);
    }

    private String selectRandomWord(List<String> words) {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    private String getUserInput(Scanner scanner) {
        String input;
        do {
            System.out.print("Ingresa una palabra de " + WORD_LENGTH + " letras: ");
            input = scanner.nextLine().trim();
            
            if (input.length() != WORD_LENGTH) {
                System.out.println("Error: La palabra debe tener exactamente " + WORD_LENGTH + " letras.");
            }
        } while (input.length() != WORD_LENGTH);
        
        return input;
    }
    
    private String feedBackString(String userInput) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < WORD_LENGTH; i++) {
            char letter = userInput.charAt(i);
            if (letter == secretWord.charAt(i)) {
                feedback.append(applyColor(String.valueOf(letter), WordleFeedback.ANSI_GREEN));
            } else if (secretWord.contains(String.valueOf(letter))) {
                feedback.append(applyColor(String.valueOf(letter), WordleFeedback.ANSI_YELLOW));
            } else {
                feedback.append(applyColor(String.valueOf(letter), WordleFeedback.ANSI_GRAY));
            }
        }
        return feedback.toString();
    }

    private String applyColor(String letter, String color) {
        return color + letter + WordleFeedback.ANSI_RESET;
    }
}

