import java.util.ArrayList;
import java.util.Scanner;


    public abstract class Game {

        protected Card current;
        protected Deck deck;
        protected ArrayList<Card> cardpile;
        protected int penalty;
        protected Scanner choice;
        protected ArrayList<Player> players;
        protected int currentPlayerIndex;

        protected Game(int numberOfPlayers) {
            choice = new Scanner(System.in);
            deck = new Deck();
            deck.shuffle();
            penalty = 0;
            current = getStartingCard();
            cardpile = new ArrayList<>();
            cardpile.add(current);
            players = new ArrayList<>();

            for (int i = 1; i <= numberOfPlayers; i++) {
                players.add(new Player("Player " + i));
            }

            currentPlayerIndex = 0;
            assignCards();
        }
        protected abstract void playGame(Player p);
        protected abstract boolean isAllowed(Player p, int choice);
        protected abstract void showBoard();
        private void assignCards() {
            for (int i = 0; i < 7; i++) {
                for (Player player : players) {
                    player.pickCards(deck.getTopCard());
                }
            }
        }

        public boolean winner() {
            for (Player player : players) {
                if (player.Won()) {
                    System.out.println("--------------------------------------------------");
                    System.out.println(player + " Won!!");
                    return true;
                }
            }
            return false;
        }

        public void design() {
            System.out.println("----------------------------------------------------------------------------------");
        }

        private Card getStartingCard() {
            Card temp = deck.peek();
            while (temp.isSpecial()) {
                deck.shuffle();
                temp = deck.peek();
            }
            return deck.getTopCard();
        }
    }

