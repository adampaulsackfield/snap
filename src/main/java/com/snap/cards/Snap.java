package com.snap.cards;

import com.snap.userInput.Messages;
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

        System.out.println(Messages.WELCOME.showMessage());
        ;

        sortDeck(CardSorting.SHUFFLE);

        addPlayers();

        while (running) {
            currentPlayer = turn % 2 == 0 ? playerOne : playerTwo;
            System.out.println(Messages.PLAYER_MESSAGE.showPlayerMessage(currentPlayer.getName()));
            ;
            response = scanner.handleInput();

            if (response.equals("snap") && left != null && right != null) {
                if (isSnap()) {
                    running = true;
                    currentPlayer.setPoints(1);
                    System.out.println(Messages.SNAP_MESSAGE.showSnapMessage(currentPlayer.getName()));
                    ;
                } else {
                    System.out.println(Messages.NO_SNAP.showMessage());
                }
            }

            Card currentCard = dealCard();
            if (currentCard != null) {
                makeMove(currentCard);
                turn++;
            } else {
                if (playerOne.getPoints() > playerTwo.getPoints()) {
                    System.out.println(Messages.PLAYER_WIN.showWinner(playerOne, playerTwo));
                } else if(playerOne.getPoints() < playerTwo.getPoints()) {
                    System.out.println(Messages.PLAYER_WIN.showWinner(playerTwo, playerOne));;
                } else{
                    System.out.println("It's a draw, can you believe it.");
                }
                System.exit(0);
            }
        }

    }
    private void addPlayers() {
        UserInput scanner = new UserInput();

        System.out.println(Messages.PLAYER_NAME.showNamePrompt("Player one"));
        playerOne = new Player();
        playerOne.setName(scanner.getName());

        System.out.println(Messages.PLAYER_NAME.showNamePrompt("Player two"));
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
