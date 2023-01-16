package com.snap.userInput;

import com.snap.cards.Player;

public enum Messages {
    WELCOME("🐊 Welcome to Snap 🐊"), PLAYER_MESSAGE("'s turn. Press enter to start"), SNAP_MESSAGE("SNAP! One point scored by "), NO_SNAP("No snap"), PLAYER_NAME(": Enter you name?"), PLAYER_WIN("The winner is ");
    final String message;

    Messages(String message) {
        this.message = message;
    }

    public String showMessage() {
        return this.message;
    }

    public String showPlayerMessage(String name) {
        return name  + this.message;
    }

    public String showSnapMessage(String name) {
        return this.message + name;
    }

    public String showNamePrompt(String player) {
        return player + this.message;
    }

    public String showWinner(Player winner, Player loser) {
        return this.message + winner.getName() + " and you finished on " + winner.getPoints() + " points. " + loser.getName() + " had " +loser.getPoints() + " points";
    }
}