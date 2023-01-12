package com.snap.cards;

import java.util.Comparator;

public class SortDeckIntoSuits implements Comparator<Card> {
    @Override
    public int compare(Card left, Card right) {
        return left.getSuit().compareTo(right.getSuit());
    }
}
