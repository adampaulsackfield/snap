package com.snap.cards;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    private final ArrayList<Card> deck = new ArrayList<>();

    private final String name;

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

            deck.add(new Card(Suits.HEARTS.getSuit(), symbol, i));
            deck.add(new Card(Suits.DIAMONDS.getSuit(), symbol, i));
            deck.add(new Card(Suits.CLUBS.getSuit(), symbol, i));
            deck.add(new Card(Suits.SPADES.getSuit(), symbol, i));
        }
    }

    public ArrayList<Card> getDeck() {
        for (Card card: deck) {
            System.out.println(card.toString());
        }

        return deck;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> shuffleCards() {

        ArrayList<Card> shuffledDeck = (ArrayList<Card>) deck.clone();

        Collections.shuffle(shuffledDeck);

        return shuffledDeck;
    }
}
