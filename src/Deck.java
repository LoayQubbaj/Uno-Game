import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;
    private ArrayList<Card> cardPile = new ArrayList<>();

    public Deck() {

        deck = new ArrayList<Card>();
        String[] colors = {"red","blue","green","yellow"};
        int[] numbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //regular cards
        int[] specialnumbers = {2,2,4,4,6,6}; //special cards such as +2 and +4


        for(String c:colors) { //adding regular cards to the deck
            for(int i:numbers) {
                deck.add(new Card(i,c));
            }
        }


        for(int i:specialnumbers) {
            //adding special cards to the deck
            deck.add(new Card(i));
        }


    }


    public Deck(ArrayList<Card> c) {

        deck = c;
    }


    public boolean isEmpty() { //is deck empty?
         //Checks the size of the deck.

        if(deck.size()>0) {
            return false;
        }
        return true;
    }

    public void shuffle() {

        //  Shuffles the deck

        Collections.shuffle(deck);

    }

    public Card getTopCard() {

         // gets the topmost card

        return deck.remove(deck.size()-1);
    }

    public void reshuffle() {
        // Refill the deck with cards from the card pile
        deck.addAll(cardPile);

        // Clear the card pile
        cardPile.clear();

        // Shuffle the deck
        shuffle();
    }
    public void checkAndReshuffle() {
        if (isEmpty()) {
            System.out.println("Deck is empty. Reshuffling...");
            reshuffle();
        }
    }

    public Card peek() {

        return deck.get(deck.size()-1);
    }
}