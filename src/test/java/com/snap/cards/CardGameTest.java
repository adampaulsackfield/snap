package com.snap.cards;

import org.junit.jupiter.api.BeforeEach;
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
    void getDeck() {
        ArrayList<Card> deck = game.getDeck();
        assertEquals(deck.size(), 52);
    }

    @Test
    void getName() {
        assertEquals("Adam", game.getName());
    }

    @Test
    void shuffleCards() {
        ArrayList<Card> deck = game.getDeck();
        game.sortDeck(CardSorting.SHUFFLE);
        ArrayList<Card> shuffledDeck = game.getShuffledDeck();
        assertNotEquals(deck, shuffledDeck);
    }

    @Test
    void dealCard() {

    }
}