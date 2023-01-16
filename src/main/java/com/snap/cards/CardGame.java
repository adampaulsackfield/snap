package com.snap.cards;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    private final ArrayList<Card> deck = new ArrayList<>();
    private final ArrayList<Card> shuffledDeck;
    private final String name;

    public CardGame(String name) {
        this.name = name;

        for (int i = 2; i <= 14; i++) {
            String symbol;

            switch (i) {
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

        shuffledDeck = (ArrayList<Card>) deck.clone();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getShuffledDeck() {
        return shuffledDeck;
    }

    public Card dealCard () {
        try {
            return shuffledDeck.remove(0);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("You have reached the end of the deck");
        }
        return null;
    }

    public void sortDeck(CardSorting cardSorting) {
        switch (cardSorting) {
            case SHUFFLE:
                Collections.shuffle(shuffledDeck);
                break;
            case BY_NUMBER:
                shuffledDeck.sort(new SortDeckInNumberOrder());
                break;
            case BY_SUIT:
                shuffledDeck.sort(new SortDeckIntoSuits());
                break;
            case BY_SUIT_AND_NUMBER:
                shuffledDeck.sort(new SortByDeckAndNumbers());
                break;
            default:
                System.out.println("Invalid Sort");
        }
    }
}
