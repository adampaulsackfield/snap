package com.snap.cards;

import java.util.ArrayList;

public class CardGame {
    ArrayList<Card> deck = new ArrayList<>();

    private String name;

    public CardGame(String name) {
        this.name = name;

        for (int i = 2; i <= 14; i++) {
            String symbol;

            switch (i){
                case 11:
                    symbol = "J";
                    break;
                case 12:
                    symbol = "Q";
                    break;
                case 13:
                    symbol = "K";
                    break;
                case 14:
                    symbol = "A";
                    break;
                default:
                    symbol = Integer.toString(i);
            }

            deck.add(new Card(Suits.hearts.getSuit(), symbol, i));
            deck.add(new Card(Suits.diamonds.getSuit(), symbol, i));
            deck.add(new Card(Suits.clubs.getSuit(), symbol, i));
            deck.add(new Card(Suits.spades.getSuit(), symbol, i));
        }
    }

    public void getDeck() {
        for (Card card: deck) {
            System.out.println(card.toString());
        }
    }

    public String getName() {
        return name;
    }
}
