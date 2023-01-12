package com.snap.cards;

import java.util.Comparator;

public class SortByDeckAndNumbers implements Comparator<Card> {
    private final SortDeckIntoSuits sortBySuit = new SortDeckIntoSuits();
    private final SortDeckInNumberOrder sortByValue = new SortDeckInNumberOrder();

    @Override
    public int compare(Card left, Card right) {
//        return left.getSuit().compareTo(right.getSuit());

        int suitComparison = sortBySuit.compare(left, right);
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return sortByValue.compare(left, right);
        }
    }
}
