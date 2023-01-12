package com.snap.cards;

import java.util.Comparator;

public class SortDeckInNumberOrder implements Comparator<Card> {
    @Override
    public int compare(Card left, Card right) {
        return left.getValue() - right.getValue();
    }
}
