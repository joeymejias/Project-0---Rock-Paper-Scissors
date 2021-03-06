package com.company;

import java.io.*;
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
    static String historyFile = "history.txt";
    static List<String> mGameHistory;

    public static void main(String[] args) {
        newGame();
    }

    public static void newGame() {
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

        if (mainMenu.equalsIgnoreCase("play")) {
            System.out.println("");
            System.out.println("Which game mode would you like to play?" + "\n" +
                               "Single player or multi-player?");
            System.out.println("");

            String gameType = scanner.nextLine();

            if (gameType.equalsIgnoreCase("Single player")) {
                singlePlayer();
            } else if(gameType.equalsIgnoreCase("multi-player")) {
                multiPlayer();
            }

        } else if (mainMenu.equalsIgnoreCase("quit")) {
            System.out.println("Bai!");
            System.exit(0);
        } else if (mainMenu.equalsIgnoreCase("history")) {
            try{
                BufferedReader in = new BufferedReader(new FileReader(historyFile));

                String line;
                while((line = in.readLine()) != null)
                {
                    System.out.println(line);
                }
                in.close();
            } catch(IOException e){
                e.printStackTrace();
            }

        } else {
            System.out.println("");
            System.out.println("Invalid text. Please try again.");
            System.out.println("");
        }
        newGame();
    }

    private static void multiPlayer() {
        System.out.println("Player 1, choose your weapon! Rock, paper, or scissors!");
        Scanner scanner = new Scanner(System.in);
        String gamePlay1 = scanner.nextLine();
        int gamePlayInt1 = 0;

            if (gamePlay1.equalsIgnoreCase("rock")) {
                gamePlayInt1 = 1;
            } else if (gamePlay1.equalsIgnoreCase("paper")) {
                gamePlayInt1 = 2;
            } else if (gamePlay1.equalsIgnoreCase("scissors")) {
                gamePlayInt1 = 3;
            } else {
                System.out.println("That's not a move... Get it right or I won't play with you.");
                gamePlay1 = scanner.nextLine();
                if (gamePlay1.equalsIgnoreCase("rock")) {
                    gamePlayInt1 = 1;
                } else if (gamePlay1.equalsIgnoreCase("paper")) {
                    gamePlayInt1 = 2;
                } else if (gamePlay1.equalsIgnoreCase("scissors")) {
                    gamePlayInt1 = 3;
                } else {
                    System.out.println("Ugh... Stupid human!");
                    System.exit(0);
                }

            }


        System.out.println("Player 2, choose your weapon! Rock, paper, or scissors!");
        String gamePlay2 = scanner.nextLine();
        int gamePlayInt2 = 0;

            if (gamePlay2.equalsIgnoreCase("rock")) {
                gamePlayInt2 = 1;
            } else if (gamePlay2.equalsIgnoreCase("paper")) {
                gamePlayInt2 = 2;
            } else if (gamePlay2.equalsIgnoreCase("scissors")) {
                gamePlayInt2 = 3;
            } else {
                System.out.println("That's not a move... Get it right or I won't play with you.");
                gamePlay2 = scanner.nextLine();
                if (gamePlay2.equalsIgnoreCase("rock")) {
                    gamePlayInt2 = 1;
                } else if (gamePlay2.equalsIgnoreCase("paper")) {
                    gamePlayInt2 = 2;
                } else if (gamePlay2.equalsIgnoreCase("scissors")) {
                    gamePlayInt2 = 3;
                } else {
                    System.out.println("Ugh... Stupid human!");
                    System.exit(0);
                }

            }


        String gameResult = null;
        if ((gamePlayInt2 == 1 && gamePlayInt1 == 1) ||
                (gamePlayInt2 == 2 && gamePlayInt1 == 2) ||
                (gamePlayInt2 == 3 && gamePlayInt1 == 3)) {
            gameResult = "It's a tie!";
        } else if (gamePlayInt2 == 1 && gamePlayInt1 == 2) {
            gameResult = "Paper covers rock! Player 2 wins!";
        } else if (gamePlayInt2 == 1 && gamePlayInt1 == 3) {
            gameResult = "Rock breaks scissors! Player 2 wins!";
        } else if (gamePlayInt2 == 2 && gamePlayInt1 == 1) {
            gameResult = "Paper covers rock! Player 2 wins!";
        } else if (gamePlayInt2 == 2 && gamePlayInt1 == 3) {
            gameResult = "Scissors cuts paper! Player 1 wins!";
        } else if (gamePlayInt2 == 3 && gamePlayInt1 == 1) {
            gameResult = "Rock breaks scissors! Player 1 win!";
        } else if (gamePlayInt2 == 3 && gamePlayInt1 == 2) {
            gameResult = "Scissors cuts paper! Player 2 wins!";
        }

        if (gamePlay2.equalsIgnoreCase("rock") ||
                gamePlay2.equalsIgnoreCase("paper") ||
                gamePlay2.equalsIgnoreCase("scissors")) {
            System.out.println("");
            System.out.println("Player 1 picked: " + gamePlay1);
            System.out.println("Player 2 picked: " + gamePlay2);
            System.out.println(gameResult);
            System.out.println("Thanks for playing!");
            System.out.println("");

            try(FileWriter fw = new FileWriter(historyFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println("Player 1 picked " + gamePlay1 + "\n" +
                        "Player 2 picked: " + gamePlay2 + "\n" +
                        gameResult + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        newGame();
    }

    private static void singlePlayer() {
        System.out.println("");
        System.out.println("Type in \'rock\' \'paper\' or \'scissors\' to play.");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        String gamePlay = scanner.nextLine();
        int gamePlayInt = 0;
        while(gamePlayInt == 0) {
            if (gamePlay.equalsIgnoreCase("rock")) {
                gamePlayInt = 1;
            } else if (gamePlay.equalsIgnoreCase("paper")) {
                gamePlayInt = 2;
            } else if (gamePlay.equalsIgnoreCase("scissors")) {
                gamePlayInt = 3;
            } else {
                System.out.println("That's not a move... Get it right or I won't play with you.");
                gamePlay = scanner.nextLine();
                if (gamePlay.equalsIgnoreCase("rock")) {
                    gamePlayInt = 1;
                } else if (gamePlay.equalsIgnoreCase("paper")) {
                    gamePlayInt = 2;
                } else if (gamePlay.equalsIgnoreCase("scissors")) {
                    gamePlayInt = 3;
                } else {
                    System.out.println("Ugh... Stupid human!");
                    System.exit(0);
                }

            }
        }

        String computerMove = null;
        Random randomMove = new Random();
        int newRandomMove = randomMove.nextInt(3) + 1;

        if (newRandomMove == 1) {
            computerMove = "rock";
        } else if (newRandomMove == 2) {
            computerMove = "paper";
        } else if (newRandomMove == 3) {
            computerMove = "scissors";
        }

        String gameResult = null;
        if ((newRandomMove == 1 && gamePlayInt == 1) ||
                (newRandomMove == 2 && gamePlayInt == 2) ||
                (newRandomMove == 3 && gamePlayInt == 3)) {
            gameResult = "It's a tie!";
        } else if (newRandomMove == 1 && gamePlayInt == 2) {
            gameResult = "Paper covers rock! You win!";
        } else if (newRandomMove == 1 && gamePlayInt == 3) {
            gameResult = "Rock breaks scissors! You lose!";
        } else if (newRandomMove == 2 && gamePlayInt == 1) {
            gameResult = "Paper covers rock! You lose!";
        } else if (newRandomMove == 2 && gamePlayInt == 3) {
            gameResult = "Scissors cuts paper! You win!";
        } else if (newRandomMove == 3 && gamePlayInt == 1) {
            gameResult = "Rock breaks scissors! You win!";
        } else if (newRandomMove == 3 && gamePlayInt == 2) {
            gameResult = "Scissors cuts paper! You lose!";
        }

        if (gamePlay.equalsIgnoreCase("rock") ||
                gamePlay.equalsIgnoreCase("paper") ||
                gamePlay.equalsIgnoreCase("scissors")) {
            System.out.println("");
            System.out.println("Computer picked: " + computerMove);
            System.out.println("You picked: " + gamePlay);
            System.out.println(gameResult);
            System.out.println("Thanks for playing!");
            System.out.println("");

            mGameHistory = new ArrayList<>();
            mGameHistory.add(gameResult);
            try(FileWriter fw = new FileWriter(historyFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println("Computer picked: " + computerMove + "\n" +
                        "You picked: " + gamePlay + "\n" +
                        gameResult + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

