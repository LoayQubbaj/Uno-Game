import java.util.Scanner;

public class GameDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players (2-10): ");
        int numberOfPlayers=scanner.nextInt();


        while(numberOfPlayers < 2 || numberOfPlayers > 10){
            System.out.println("Invalid number of players. Exiting...");
            numberOfPlayers=scanner.nextInt();
        }

        MyGame game = new MyGame(numberOfPlayers);

        game.game();
    }
}
