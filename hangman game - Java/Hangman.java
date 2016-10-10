/*
 * Author: Eric Petryshyn
 * File: Hangman.java
 * 
 * Purpose: To play the game hangman 
 */

import java.util.*;
import java.io.*;

public class Hangman{
  
  public static void main(String[] args)throws IOException{
    
    String word = "";
    String guess = "";
    String wrongs = "";
    int successSum = 0;
    int play = 1;
    int strikes = 0;
    int strikePossibility = 0;
    int currentSize = 0;
    int number;
    int choice;
    
    Random rnd = new Random();
    Scanner fileScan1 =  new Scanner(new File("Animals.txt"));
    Scanner fileScan2 = new Scanner(new File("Sports.txt"));
    Scanner scan = new Scanner(System.in);
    
    String[] words = new String[100]; 
    
    // Welcomes player and takes in category
    System.out.println("Welcome to Hangman!\n\nChoose a category by entering a number\n\n1 - Animals\n2 - Sports & Activities");
    choice = scan.nextInt();
    
    // Chooses an animal from text file to be answer
    if(choice == 1){
      while(fileScan1.hasNextLine() && currentSize < 100){
        words[currentSize] = fileScan1.nextLine();
        currentSize++;
      }
      number = rnd.nextInt(25);
      word = words[number];
    }
    // Chooses a sport from text file to be answer
    else if(choice == 2){
      while(fileScan2.hasNextLine() && currentSize < 100){
        words[currentSize] = fileScan2.nextLine();
        currentSize++;
      }
      number = rnd.nextInt(20);
      word = words[number];
    }
    
    System.out.println("Rules: You have 7 strikes. The stars down below each\n       represent a letter of the word you must guess.\n       Good luck!\n\n");
    
    int wordLength = word.length();
    String[] character = new String[20];
    int[] success = new int[20];
    
    for(int i=0; i<wordLength; i++){
      String letter = word.substring(i,(i+1));
      character[i] = letter;   
    }
    
    for(int i=0; i<wordLength; i++){
      System.out.print("*");     
    }
    
    // Keep playing game until player chooses to stop
    while(play == 1){
      // Keep playing current game until too many wrong guesses are made
      while(successSum != wordLength && strikes != 7){
        successSum = 0;
        strikePossibility = 0;
        System.out.println("\n");
        // Displays hangman visual
        switch (strikes){
          case 0:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
            break;
          case 1: 
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
            break;
          case 2:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |       |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
            break;
          case 3:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |       |");
            System.out.println("  |       |");
            System.out.println("  |");
            System.out.println("__|__");
            break;
          case 4:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |       |");
            System.out.println("  |       |");
            System.out.println("  |      /");
            System.out.println("__|__");
            break;
          case 5:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |       |");
            System.out.println("  |       |");
            System.out.println("  |      / \\");
            System.out.println("__|__");
            break;
          case 6:
            System.out.println("  _________");
            System.out.println("  |       |");
            System.out.println("  |       O");
            System.out.println("  |      /|");
            System.out.println("  |       |");
            System.out.println("  |      / \\");
            System.out.println("__|__");
            break;
        }
        // Displays wrong answer list
        if(wrongs != ""){
          System.out.println("\nWrong answers:" + wrongs);
        }
        
        // Enter guess
        System.out.println("\n\nEnter a guess: ");
        guess = scan.next();
        // Instant win if answer is same as guess
        if(guess.equalsIgnoreCase(word)){
          for(int i=0; i<wordLength; i++){
            success[i] = 1;
          }
        }
        else
          // Calclates successful letter
          for(int i=0; i<wordLength; i++){
          if(guess.equalsIgnoreCase(character[i])){
            success[i] = 1;
            System.out.print(character[i]);
          }
          // Diplays current correct letters 
          else if(success[i] == 1){
            System.out.print(character[i]);
            strikePossibility++;
          }
          else{
            // Displays asterisk in place of current unguessed letters
            System.out.print("*");
            strikePossibility++;
          }   
        }
        // Calculates success
        for(int i=0; i<wordLength; i++){
          successSum += success[i];
        }
        // Gives strike if guess is wrong
        if(strikePossibility == wordLength){
          strikes++;
          wrongs += " " + guess;
        }
      }
      
      // Victory condition
      if(successSum == wordLength){
        System.out.println("\n\nCongratulations! You Win!\n\nPlay Again(0 for no, 1 for yes)?");
        play = scan.nextInt();
        if(play == 1){
          for(int i=0; i<wordLength; i++){
            success[i] = 0;
          }
          successSum = 0;
          strikes = 0;
          wrongs = "";
          number = rnd.nextInt(25) + 1;
          word = words[number];
          wordLength = word.length();
          
          for(int i=0; i<wordLength; i++){
            String letter = word.substring(i,(i+1));
            character[i] = letter;   
          }
          for(int i=0; i<wordLength; i++){
            System.out.print("*"); 
          }
        }
      }
      
      // Loss condition
      if(strikes == 7){
        System.out.println("  _________");
        System.out.println("  |       |");
        System.out.println("  |       O");
        System.out.println("  |      /|\\");
        System.out.println("  |       |");
        System.out.println("  |      / \\");
        System.out.println("__|__");
        System.out.println("\n\nGame over! The answer was " + word + "!\n\nPlay Again(0 for no, 1 for yes)?");
        play = scan.nextInt();
        if(play == 1){
          for(int i=0; i<wordLength; i++){
            success[i] = 0;
          }
          successSum = 0;
          strikes = 0;
          wrongs = "";
          number = rnd.nextInt(25) + 1;
          word = words[number];
          wordLength = word.length();
          
          for(int i=0; i<wordLength; i++){
            String letter = word.substring(i,(i+1));
            character[i] = letter;   
          }
          for(int i=0; i<wordLength; i++){
            System.out.print("*"); 
          }
        }
      }
    }
  }
}
    
    
    
    
    
    
    