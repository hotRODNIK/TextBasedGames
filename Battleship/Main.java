import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String input, name1, name2;
        boolean state = false;

        System.out.println("Welcome to Battleship\nPlease Make a Selection to Continue\n(N)ew Two Player Game\n(Q)uit");
        input = s.next().toUpperCase();

        while (!state){
            if (input.equals("N")){
                state = true;
            }
            else if (input.equals("Q")){
                state = true;
            }
            else{
                System.out.println("Invalid Input, Please Check Your Input String and Try Again");
                System.out.println("Welcome to Battleship\nPlease Make a Selection to Continue\n(N)ew Two-Player Game\n(Q)uit");
                input = s.next().toUpperCase();
            }
        }

        if (input.equals("N")){
            System.out.println("New Game Selected - Player One Please Enter Your Name => ");
            name1 = s.next();
            System.out.println("Welcome " + name1 + "!");
            System.out.println("Player Two Please Enter Your Name => ");
            name2 = s.next();
            System.out.println("Welcome " + name2 + "!\nGenerating Boards... ");

            // Player grids are generated randomly
            Grid pGrid = new Grid("PLAY");
            Grid cGrid = new Grid("PLAY");
            Grid pGrid2 = new Grid("HITSMISS");
            Grid cGrid2 = new Grid("HITSMISS");
            TimeUnit.SECONDS.sleep(2); // Fake processing time lol

            System.out.println("Boards Generated Successfully!");
            TimeUnit.SECONDS.sleep(1);

            while (!GameLogic.gameOver(cGrid2, pGrid2)){
                System.out.println(GameLogic.getSunk(name1, name2));
                System.out.println(pGrid);
                System.out.println(pGrid2);
                System.out.println(name1 + "'s turn\nPlease Enter a Valid Coordinate from the Grid to Attack");
                System.out.println("Coordinates Must be Entered in the Form of ab, Where a is the Vertical Coordinate and b is the Horizontal Coordinate");
                input = s.next().toUpperCase();

                while (!GameLogic.checkInput(input)) {
                    System.out.println("Invalid Coordinate");
                    System.out.println(name1 + "'s turn\nPlease Enter a Valid Coordinate from the Grid to Attack");
                    input = s.next().toUpperCase();
                }

                // Need to check if the entered move is valid
                System.out.println("Checking Move...");
                TimeUnit.SECONDS.sleep(1);
                GameLogic.checkMove(cGrid, pGrid2, input, 1); // Player one check move
                System.out.println(pGrid2);

                // Check that the game didn't end
                if (GameLogic.gameOver(cGrid2, pGrid2)){
                    System.out.println("Game Over");
                    System.exit(0);
                }

                // Player two's turn
                System.out.println(name1 + " switch with " + name2);
                TimeUnit.SECONDS.sleep(5);
                System.out.println(GameLogic.getSunk(name1, name2));
                System.out.println(cGrid);
                System.out.println(cGrid2);
                System.out.println(name2 + "'s turn\nPlease Enter a Valid Coordinate from the Grid to Attack");
                System.out.println("Coordinates Must be Entered in the Form of ab, Where a is the Vertical Coordinate and b is the Horizontal Coordinate");
                input = s.next().toUpperCase();

                while (!GameLogic.checkInput(input)) {
                    System.out.println("Invalid Coordinate");
                    System.out.println(name2 + "'s turn\nPlease Enter a Valid Coordinate from the Grid to Attack");
                    input = s.next().toUpperCase();
                }

                // Need to check if the entered move is valid
                System.out.println("Checking Move...");
                TimeUnit.SECONDS.sleep(1);
                GameLogic.checkMove(pGrid, cGrid2, input, 2); // Player two check move
                System.out.println(cGrid2);
                System.out.println(name2 + " switch with " + name1);
                TimeUnit.SECONDS.sleep(5);
            }

            System.out.println("Game Over");
        }
        else if (input.equals("Q")){
            System.out.println("Goodbye - End of Program");
        }
    }
}
