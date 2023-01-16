package com.snap.cards;

import com.snap.userInput.Messages;
import com.snap.userInput.UserInput;

public class Snap extends CardGame {
    private Card left = null;
    private Card right = null;
    private boolean running = true;
    private Player playerOne;
    private Player playerTwo;
    private int turn = 0;

    public Snap(String name) {
        super(name);
    }

    public void start() {
        UserInput scanner = new UserInput();

        System.out.println(Messages.WELCOME.showMessage());

        sortDeck(CardSorting.SHUFFLE);

        addPlayers();

        while (running) {
            Player currentPlayer = turn % 2 == 0 ? playerOne : playerTwo;

            System.out.println(Messages.PLAYER_MESSAGE.showPlayerMessage(currentPlayer.getName()));

            String response = scanner.handleInput();

            if (response.equals("snap") && left != null && right != null) {
                if (isSnap()) {
                    currentPlayer.setPoints(1);
                    System.out.println(Messages.SNAP_MESSAGE.showSnapMessage(currentPlayer.getName()));
                } else {
                    System.out.println(Messages.NO_SNAP.showMessage());
                }
            }

            Card currentCard = dealCard();

            if (currentCard != null) {
                makeMove(currentCard);
                turn++;
                System.out.println("Left: " + left);
                System.out.println("Right: " + right);
            } else {
                if (playerOne.getPoints() > playerTwo.getPoints()) {
                    System.out.println(Messages.PLAYER_WIN.showWinner(playerOne, playerTwo));
                } else if (playerOne.getPoints() < playerTwo.getPoints()) {
                    System.out.println(Messages.PLAYER_WIN.showWinner(playerTwo, playerOne));
                } else {
                    System.out.println(Messages.DRAW.showMessage());
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
    }
}
