import com.snap.cards.Card;
import com.snap.cards.CardGame;
import com.snap.cards.CardSorting;
import com.snap.cards.Snap;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame("Adam");

        List<Card> deck = game.getDeck();

//        System.out.println("Deal: " + game.dealCard());
//        System.out.println("Deal: " + game.dealCard());

//        game.sortDeck(CardSorting.SHUFFLE);

//        System.out.println("Shuffled: " + game.getShuffledDeck());

//        game.sortDeck(CardSorting.BY_NUMBER);
//
//        System.out.println("Sorted: byNumber " + game.getShuffledDeck());

//        game.sortDeck(CardSorting.BY_SUIT);
//
//        System.out.println("Sorted: bySuit " + game.getShuffledDeck());

        game.sortDeck(CardSorting.BY_SUIT_AND_NUMBER);
//
        System.out.println("Sorted: bySuitAndValue " + game.getShuffledDeck());

        Snap snap = new Snap("Ollie");

        snap.test();
    }
}
