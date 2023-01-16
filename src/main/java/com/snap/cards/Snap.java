package com.snap.cards;

import com.snap.userInput.UserInput;

import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    private String response = null;
    private Card left = null;
    private Card right = null;
    private boolean running = true;
    private Player playerOne;
    private Player playerTwo;
    private int turn = 0;
    private Player currentPlayer;

    public Snap(String name) {
        super(name);
    }

    public void start() {
        UserInput scanner = new UserInput();

        System.out.println("🐊 Welcome to Snap 🐊");

        sortDeck(CardSorting.SHUFFLE);

        addPlayers();

        while (running) {
            currentPlayer = turn % 2 == 0 ? playerOne : playerTwo;
            System.out.println(currentPlayer.getName()  + "'s turn. Press enter to start");
            response = scanner.handleInput();

            if (response.equals("snap") && left != null && right != null) {
                if (isSnap()) {
                    running = true;
                    currentPlayer.setPoints(1);
                    System.out.println("Snap! " + currentPlayer.getName() + " has " + currentPlayer.getPoints() + " points");
                } else {
                    System.out.println("No snap");
                }
            }
            makeMove(dealCard());
            turn++;
        }

    }

    private void addPlayers() {
        UserInput scanner = new UserInput();

        System.out.println("Player One: Enter you name?");
        playerOne = new Player();
        playerOne.setName(scanner.getName());

        System.out.println("Player Two: Enter you name?");
        playerTwo = new Player();
        playerTwo.setName(scanner.getName());
    }

    private boolean isSnap() {
        return left.getSymbol().equals(right.getSymbol());
    }

    private void makeMove(Card card) {

        if (left == null) {
            left = card;
        } else if (right == null) {
            right = card;
        } else {
            left = right;
            right = card;
        }

        System.out.println("Left: " + left);
        System.out.println("Right: " + right);
    }
}
