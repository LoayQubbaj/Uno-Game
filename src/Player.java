import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private ArrayList<Card> playercards;
    private String name;

    public Player(String name) {
        playercards = new ArrayList<Card>();
        this.name = name;
    }



    public ArrayList<Card> PlayerCards() {
        return playercards;
    }

    public void pickCards(Card c) {
        playercards.add(c);

    }

    public Card throwCard(int c) {
        return playercards.remove(c);
    }

    public void oneCard() {
        Scanner s = new Scanner(System.in);
        if (playercards.size() == 1) {
            System.out.println("Uno");
            System.out.println("Press Enter...");
            s.nextLine();
        }
    }

    public void showCards() {
        for (Card card : playercards) {
            System.out.print(card.formatCard() + " ");
        }
        System.out.println();
    }

    public boolean Won() {
        if(playercards.isEmpty()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name;
    }
}
