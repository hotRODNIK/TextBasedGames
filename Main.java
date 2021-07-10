import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        String[] stuff = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        boolean[] availableMoves = {true, true, true, true, true, true, true, true, true};
        boolean validInput, end = false;
        int input;
        String in;

        System.out.println("Welcome to Tic-Tac-Toe v0.1\nYou may play a game against a friend\n(T)wo Player Game, (Q)uit");
        in = s.next().toUpperCase();

        if (in.equals("T")){
            System.out.println("Welcome Players - X will start first");

            while(!end){
                validInput = false;
                printBoard(stuff);
                System.out.println("X's turn\nPlease enter a board position to make a move (1-9)");
                input = s.nextInt();

                if (checkMove(input, availableMoves)) {
                    stuff[input - 1] = "X";
                    availableMoves[input - 1] = false;

                    if (gameOver(stuff).equals("X")) {
                        System.out.println("X Wins\n");
                        break;
                    }
                    else if (gameOver(stuff).equals("D")){
                        System.out.println("Draw\n");
                        break;
                    }

                    printBoard(stuff);

                    while (!validInput) {
                        System.out.println("O's turn\nPlease enter a board position to make a move (1-9)");
                        input = s.nextInt();

                        if (checkMove(input, availableMoves)) {
                            stuff[input - 1] = "O";
                            availableMoves[input - 1] = false;

                            if (gameOver(stuff).equals("O")) {
                                System.out.println("O Wins\n");
                                end = true;
                                break;
                            }
                            else if (gameOver(stuff).equals("D")){
                                System.out.println("Draw\n");
                                end = true;
                                break;
                            }
                            validInput = true;
                        } else {
                            System.out.println("That is not a valid move, please try again");
                        }
                    }
                }
                else{
                    System.out.println("That is not a vaild move, please try again");
                }
            }
            printBoard(stuff);
            System.out.println("Game Over");
        }
        else if (in.equals("Q")){
            System.out.println("User Quit");
        }
        else{
            System.out.println("Invalid Input");
        }
    }

    public static void printBoard(String [] stuff){
        System.out.println(stuff[0] + "|" + stuff[1] + "|" + stuff[2] + "\n"
                + "- - -\n"
                + stuff[3] + "|" + stuff[4] + "|" + stuff[5] + "\n"
                +"- - -\n"
                + stuff[6] + "|" + stuff[7] + "|" + stuff[8] + "\n");
    }

    public static boolean checkMove(int input, boolean[] availableMoves){
        return availableMoves[input - 1];
    }

    public static String gameOver(String [] stuff){
        boolean boardFull = true;

        for (String s : stuff) {
            if (s.equals(" ")) {
                boardFull = false;
                break;
            }
        }

        if (!boardFull) {
            if (stuff[0].equals("X") && stuff[1].equals("X") && stuff[2].equals("X")) {
                return "X";
            } else if (stuff[3].equals("X") && stuff[4].equals("X") && stuff[5].equals("X")) {
                return "X";
            } else if (stuff[6].equals("X") && stuff[7].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[0].equals("X") && stuff[3].equals("X") && stuff[6].equals("X")) {
                return "X";
            } else if (stuff[1].equals("X") && stuff[4].equals("X") && stuff[7].equals("X")) {
                return "X";
            } else if (stuff[2].equals("X") && stuff[5].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[2].equals("X") && stuff[4].equals("X") && stuff[6].equals("X")) {
                return "X";
            } else if (stuff[0].equals("X") && stuff[4].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[0].equals("O") && stuff[1].equals("O") && stuff[2].equals("O")) {
                return "O";
            } else if (stuff[3].equals("O") && stuff[4].equals("O") && stuff[5].equals("O")) {
                return "O";
            } else if (stuff[6].equals("O") && stuff[7].equals("O") && stuff[8].equals("O")) {
                return "O";
            } else if (stuff[0].equals("O") && stuff[3].equals("O") && stuff[6].equals("O")) {
                return "O";
            } else if (stuff[1].equals("O") && stuff[4].equals("O") && stuff[7].equals("O")) {
                return "O";
            } else if (stuff[2].equals("O") && stuff[5].equals("O") && stuff[8].equals("O")) {
                return "O";
            } else if (stuff[2].equals("O") && stuff[4].equals("O") && stuff[6].equals("O")) {
                return "O";
            } else if (stuff[0].equals("O") && stuff[4].equals("O") && stuff[8].equals("O")) {
                return "O";
            }
        }
        else {
            if (stuff[0].equals("X") && stuff[1].equals("X") && stuff[2].equals("X")) {
                return "X";
            } else if (stuff[3].equals("X") && stuff[4].equals("X") && stuff[5].equals("X")) {
                return "X";
            } else if (stuff[6].equals("X") && stuff[7].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[0].equals("X") && stuff[3].equals("X") && stuff[6].equals("X")) {
                return "X";
            } else if (stuff[1].equals("X") && stuff[4].equals("X") && stuff[7].equals("X")) {
                return "X";
            } else if (stuff[2].equals("X") && stuff[5].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[2].equals("X") && stuff[4].equals("X") && stuff[6].equals("X")) {
                return "X";
            } else if (stuff[0].equals("X") && stuff[4].equals("X") && stuff[8].equals("X")) {
                return "X";
            } else if (stuff[0].equals("O") && stuff[1].equals("O") && stuff[2].equals("O")) {
                return "O";
            } else if (stuff[3].equals("O") && stuff[4].equals("O") && stuff[5].equals("O")) {
                return "O";
            } else if (stuff[6].equals("O") && stuff[7].equals("O") && stuff[8].equals("O")) {
                return "O";
            } else if (stuff[0].equals("O") && stuff[3].equals("O") && stuff[6].equals("O")) {
                return "O";
            } else if (stuff[1].equals("O") && stuff[4].equals("O") && stuff[7].equals("O")) {
                return "O";
            } else if (stuff[2].equals("O") && stuff[5].equals("O") && stuff[8].equals("O")) {
                return "O";
            } else if (stuff[2].equals("O") && stuff[4].equals("O") && stuff[6].equals("O")) {
                return "O";
            } else if (stuff[0].equals("O") && stuff[4].equals("O") && stuff[8].equals("O")) {
                return "O";
            } else {
                return "D";
            }
        }
        return "";
    }
}
