/*
 * Author: Eric Petryshyn
 * File: Guessing_Game.java
 * 
 * Purpose: To play game until there are 3 wrong guesses in a row 
 */

import java.util.*;

public class Guessing_Game{

  public static void main(String[] args){

    int answer, guess, level, strikes;
    answer = 0;
    level = 1;
    strikes = 0;

    Scanner scan = new Scanner(System.in);
    Random generator = new Random();

    System.out.println("Welcome to the Guessing Game!");

    while(strikes < 3){
      System.out.println("\nEnter a number between 1 and " + (level + 1) + ": ");
      guess = scan.nextInt();
      
      answer = generator.nextInt(level + 1) + 1;

      if (guess != answer){
        System.out.println("Wrong! The answer was " + answer + ". Try again.");
        strikes++;
      }

      if (guess == answer){
        System.out.println("Congratulations! You advance to the next level!");
        level++;
        strikes = 0;
      }
    }
    
    if (strikes == 3){
      System.out.println("\nYou Suck! The answer was " + answer + "! Game Over!");
    }
  }
}