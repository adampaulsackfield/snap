package com.snap.cards;

public class Card {
    private final String suit;

    private final String symbol;

    private final int value;

    protected Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    protected String getSuit() {
        return suit;
    }

    protected String getSymbol() {
        return symbol;
    }

    protected int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
