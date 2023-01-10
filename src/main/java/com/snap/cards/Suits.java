package com.snap.cards;

public enum Suits {
    hearts("♥"), diamonds("♦"), spades("♠"), clubs("♣");
    String suit;

    Suits(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
}