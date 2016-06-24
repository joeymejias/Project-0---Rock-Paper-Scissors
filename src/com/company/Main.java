package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Requirements

 Your work must:

 Have a main menu with options to enter "play" or "history":
 If the user enters "play", they should be able to play Rock Paper Scissors against the computer
 If the user enters "history", the program should display previous game history
 Handle invalid user input
 Use Arrays or ArrayLists to store game history
 Bonus:

 Handle incorrect capitalization of otherwise valid user input (rock, Rock, RoCk, ROCK, etc.)
 Store game history across sessions
 */

public class Main {
    static final List<String> gameHistory = new ArrayList<>();

    public static void main(String[] args) {
        newGame();
    }

    public static void newGame(){
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("=========");
        System.out.println("1. Type \'play\' to play");
        System.out.println("2. Type \'history\' to view your game history");
        System.out.println("3. Type \'quit\' to stop playing");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        String mainMenu = scanner.nextLine();

        if (mainMenu.equalsIgnoreCase("play")){
            System.out.println("");
            System.out.println("Type in \'rock\' \'paper\' or \'scissors\' to play.");
            System.out.println("");

            String gamePlay = scanner.nextLine();
            int gamePlayInt = 0;
            while(!gamePlay.equalsIgnoreCase("rock") ||
                    !gamePlay.equalsIgnoreCase("paper")||
                    !gamePlay.equalsIgnoreCase("scissors")){
                if (gamePlay.equalsIgnoreCase("rock")){
                    gamePlayInt = 1;
                } else if(gamePlay.equalsIgnoreCase("paper")) {
                    gamePlayInt = 2;
                } else if(gamePlay.equalsIgnoreCase("scissors")){
                    gamePlayInt = 3;
                } else {
                    System.out.println("That's not a move...Try again.");
                    gamePlay = scanner.nextLine();
                }
            }

            String computerMove = null;
            Random randomMove = new Random();
            int newRandomMove = randomMove.nextInt(3) + 1;

            if (newRandomMove == 1){
                computerMove = "rock";
            } else if (newRandomMove == 2){
                computerMove = "paper";
            } else if (newRandomMove == 3){
                computerMove = "scissors";
            }

            String gameResult = null;
            if((newRandomMove == 1 && gamePlayInt == 1) ||
               (newRandomMove == 2 && gamePlayInt == 2) ||
               (newRandomMove == 3 && gamePlayInt == 3)){
                gameResult = "It's a tie!";
            } else if(newRandomMove == 1 && gamePlayInt == 2){
                gameResult = "Paper covers rock! You win!";
            } else if(newRandomMove == 1 && gamePlayInt == 3){
                gameResult = "Rock breaks scissors! You lose!";
            } else if(newRandomMove == 2 && gamePlayInt == 1){
                gameResult = "Paper covers rock! You lose!";
            } else if(newRandomMove == 2 && gamePlayInt == 3){
                gameResult = "Scissors cuts paper! You win!";
            } else if(newRandomMove == 3 && gamePlayInt == 1){
                gameResult = "Rock breaks scissors! You win!";
            } else if(newRandomMove == 3 && gamePlayInt == 2){
                gameResult = "Scissors cuts paper! You lose!";
            }

            if (gamePlay.equalsIgnoreCase("rock") ||
                gamePlay.equalsIgnoreCase("paper") ||
                gamePlay.equalsIgnoreCase("scissors")){
                System.out.println("");
                System.out.println("Computer picked: " + computerMove);
                System.out.println("You picked: " + gamePlay);
                System.out.println(gameResult);
                System.out.println("Thanks for playing!");
                System.out.println("");
                gameHistory.add("Computer picked: " + computerMove + "\n" +
                                "You picked: " + gamePlay + "\n" +
                                 gameResult + "\n");
            }

        } else if(mainMenu.equalsIgnoreCase("quit")){
                System.exit(0);
        } else if(mainMenu.equalsIgnoreCase("history")){
                System.out.println("");
                int i;
                for(i = 0; i <= gameHistory.size() - 1; i++){
                System.out.println(gameHistory.get(i));
                }
                System.out.println("");
        } else{
            System.out.println("");
            System.out.println("Invalid text. Please try again.");
            System.out.println("");
        }
            newGame();
        }
}

