package com.snap.cards;

public enum Suits {
    HEARTS("♥"), DIAMONDS("♦"), SPADES("♠"), CLUBS("♣");
    private final String suit;

    Suits(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
}