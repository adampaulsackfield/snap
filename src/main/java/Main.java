import com.snap.cards.CardGame;

public class Main {
    public static void main(String[] args) {

        CardGame deck = new CardGame("Adam");

        deck.getDeck();

        System.out.println(deck.shuffleCards());

    }
}
