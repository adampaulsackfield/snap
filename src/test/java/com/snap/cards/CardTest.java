package com.snap.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CardTest {
    private Card card;

    @BeforeEach
    void setup() {
        card = new Card("hearts", "J", 11);
    }

    @Test
    void getSuit() {
        assertEquals(card.getSuit(), "hearts");
    }

    @Test
    void getSymbol() {
        assertEquals(card.getSymbol(), "J");
    }

    @Test
    void getValue() {
        assertEquals(card.getValue(), 11);
    }

    @Test
    void testToString() {
        assertEquals(card.toString(), "Card{suit=hearts, symbol='J', value=11}");
    }
}