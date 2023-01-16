package com.snap.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {
    private CardGame game;

    @BeforeEach
    void setUp() {
        game = new CardGame("Adam");
    }

    @Test
    @DisplayName("Generates a deck of 52 Cards")
    void getDeck() {
        ArrayList<Card> deck = game.getDeck();
        assertEquals(deck.size(), 52);
    }

    @Test
    @DisplayName("Returns the name")
    void getName() {
        assertEquals("Adam", game.getName());
    }

    @Test
    @DisplayName("Returns the current shuffled deck")
    void getShuffledDeck() {
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();
        assertNotNull(shuffledDeck);
        assertEquals(shuffledDeck.size(), 52);

    }

    @Test
    @DisplayName("Should shuffle the deck")
    void sortDeckRandomShuffle() {
        ArrayList<Card> deck = game.getDeck();
        game.sortDeck(CardSorting.SHUFFLE);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();
        assertNotEquals(deck, shuffledDeck);
    }

    @Test
    @DisplayName("Should sort the deck by number")
    void sortDeckByNumber() {
        game.sortDeck(CardSorting.BY_NUMBER);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();

        assertEquals(2, shuffledDeck.get(0).getValue());
        assertEquals(3, shuffledDeck.get(4).getValue());
        assertEquals(4, shuffledDeck.get(8).getValue());
        assertEquals(5, shuffledDeck.get(12).getValue());
    }

    @Test
    @DisplayName("Should sort the deck by suit")
    void sortDeckBySuit() {
        game.sortDeck(CardSorting.BY_SUIT);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();

        // Asserts that the suits are in order. Each suit has thirteen cards.
        assertEquals(shuffledDeck.get(0).getSuit(), shuffledDeck.get(12).getSuit());
        assertEquals(shuffledDeck.get(13).getSuit(), shuffledDeck.get(25).getSuit());
        assertEquals(shuffledDeck.get(26).getSuit(), shuffledDeck.get(38).getSuit());
        assertEquals(shuffledDeck.get(39).getSuit(), shuffledDeck.get(51).getSuit());
    }

    @Test
    @DisplayName("Should sort the deck by suit and by number")
    void sortDeckBySuitAndNumbers() {
        game.sortDeck(CardSorting.BY_SUIT_AND_NUMBER);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();

        // Loops over the cards and asserts neighbour cards have the same suit and a value difference of 1.
        // Unless index 12,25 or 38 as these are where the suit changes happen.
        for (int i = 0; i < 51; i++) {
            if (i != 12 && i != 25 && i != 38) {
                assertEquals(shuffledDeck.get(i).getSuit(), shuffledDeck.get(i + 1).getSuit());
                assertEquals(shuffledDeck.get(i).getValue(), shuffledDeck.get(i + 1).getValue() - 1);
            }
        }
    }

    @Test
    @DisplayName("Should deal a card from the top of the deck")
    void dealCard() {
        game.sortDeck(CardSorting.SHUFFLE);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();

        Card topOfDeck = shuffledDeck.get(0);
        Card topOfDeckAfterOneDeal = shuffledDeck.get(1);
        Card dealtCard = game.dealCard();

        // Test for the top of the deck being drawn
        assertEquals(topOfDeck, dealtCard);

        Card cardTwo = game.dealCard();

        // Confirm the next card dealt is different and is the second card in the deck
        assertNotEquals(dealtCard, cardTwo);
        assertEquals(topOfDeckAfterOneDeal, cardTwo);
    }
}