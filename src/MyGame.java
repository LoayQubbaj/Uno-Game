public class MyGame extends Game {

    public MyGame(int numberOfPlayers) {
        super(numberOfPlayers);
    }

    @Override
    protected void playGame(Player p) {
        design();
        System.out.println(p + " It is your turn\nThe current card is:\n" + current.formatCard());
        design();
        showBoard();
        design();

        if (current.isSpecial()) {
            penalty += current.getValue();
            Card pick;
            if (!canBePlayed(p)) {
                System.out.println("You don't have a card to place.");
                for (int i = 0; i < penalty; i++) {
                    if (deck.isEmpty()) {
                        deck = new Deck(cardpile);
                        deck.checkAndReshuffle();
                    }
                    pick = deck.getTopCard();
                    p.pickCards(pick);
                    System.out.println("You received: \n" + pick.formatCard());
                    pause();
                }
                penalty = 0;
                current = deck.getTopCard();
                System.out.println("The new current card is: \n" + current.formatCard());
                System.out.println("Your cards after the update: ");
                p.showCards();
            }
        }

        if (!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
            Card pick = null;
            System.out.println("You do not have a valid card to play, so you have to pick a card from the deck.");
            while (!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
                pause();
                pick = deck.getTopCard();
                p.pickCards(pick);
                System.out.println("You received:\n" + pick.formatCard());
                deck.checkAndReshuffle();
            }
            System.out.println("You received a valid card!");
            pause();
            System.out.println("You have these following cards: ");
            p.showCards();
        }

        System.out.println("Please pick a card:");
        int pick = choice.nextInt() - 1;

        while (!isAllowed(p, pick)) {
            System.out.println("Invalid pick. Please pick another card.");
            pick = choice.nextInt() - 1;
        }


        Card play = p.throwCard(pick);
        p.oneCard();
        current = play;
        cardpile.add(current);
        System.out.println("Your current cards: ");
        p.showCards();
    }
    public void game() {
        int turn = 0;
        while (!winner()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            playGame(currentPlayer);
            turn++;
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
    @Override
    protected boolean isAllowed(Player p, int choice) {//checks if the card picked is valid and can be played
        if (choice >= 0 && choice < p.PlayerCards().size()) {
                if ((p.PlayerCards().get(choice).getColor().equals(current.getColor()) ||
                                p.PlayerCards().get(choice).getValue() == current.getValue() ||
                                p.PlayerCards().get(choice).isSpecial())) {
                    return true;
                }
            }

        return false;
    }



    @Override
    protected void showBoard() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("                " + currentPlayer);
        currentPlayer.showCards();
        System.out.println();
    }

    private void pause() {
        System.out.println("Press enter to continue......");
        choice.nextLine();
    }

    private boolean hasColor(Player p) {
        for (Card c : p.PlayerCards()) {
            if (c.getColor().equals(current.getColor())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValue(Player p) {
        for (Card c : p.PlayerCards()) {
            if (c.getValue() == current.getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecial(Player p) {
        for (Card c : p.PlayerCards()) {
            if (c.isSpecial()) {
                return true;
            }
        }
        return false;
    }


    private boolean canBePlayed(Player p) {//checks if the card can be played.
        for (Card c : p.PlayerCards()) {
            if (c.isSpecial()) {
                if (c.getValue() >= current.getValue()) {
                    return true;
                }
            }
        }
        return false;
    }
}
