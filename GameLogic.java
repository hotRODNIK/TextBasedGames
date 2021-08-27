public class GameLogic {
    private static boolean dSunk = false;
    private static boolean bSunk = false;
    private static boolean crSunk = false;
    private static boolean cSunk = false;
    private static boolean sSunk = false;

    // The implementation of these functions are shit - you know it and I know it
    // But hey, at least they work, albeit terribly :P
    public static boolean gameOver(Grid cGrid, Grid pGrid){
        int cHitsCount = 0, pHitsCount = 0;

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
               if (cGrid.getState(i, j).equals("H")){
                   cHitsCount++;
               }
               if (pGrid.getState(i, j).equals("H")){
                   pHitsCount++;
               }
            }
        }

        if (cHitsCount == 17){
            return true;
        }
        else return pHitsCount == 17;
    }

    public static boolean checkInput(String input){
        try{
            int num = Integer.parseInt(input);
            if (num <= 99){
                if (num >= 0){
                    return true;
                }
            }
        }
        catch (NumberFormatException e){
            return false;
        }
        return false;
    }

    // Need to update the pieces board as well
    // Keep track of which pieces have been sunk by using a brute force search
    // and keeping track with boolean variables
    public static void checkMove(Grid cGrid, Grid pGrid2, String coords){
        // Okay because input is cleansed in main()
        // Correction: Good in most cases
        int x = Integer.parseInt(String.valueOf(coords.charAt(0)));
        int y = Integer.parseInt(String.valueOf(coords.charAt(1)));

        if (cGrid.getState(x, y).equals("C")){
            pGrid2.updateState(x, y, "H");
            cGrid.updateState(x, y, "H");
            System.out.println("Hit!\n");

            if (!cSunk){
                // Check to see if the piece has been sunk
                int count = 0;

                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++){
                        if (cGrid.getState(i, j).equals("C")){
                            count++;
                        }
                    }
                }

                if (count == 0){
                    System.out.println("Carrier sunk!");
                    cSunk = true;
                }
            }
        }
        else if (cGrid.getState(x, y).equals("B")){
            pGrid2.updateState(x, y, "H");
            cGrid.updateState(x, y, "H");
            System.out.println("Hit!\n");

            if (!bSunk){
                // Check to see if the battleship has been sunk
                int count = 0;

                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++){
                        if (cGrid.getState(i, j).equals("B")){
                            count++;
                        }
                    }
                }

                if (count == 0){
                    System.out.println("Battleship sunk!");
                    bSunk = true;
                }
            }
        }
        else if (cGrid.getState(x, y).equals("Cr")){
            pGrid2.updateState(x, y, "H");
            cGrid.updateState(x, y, "H");
            System.out.println("Hit!\n");

            if (!crSunk){
                // Check to see it the cruiser has been sunk
                int count = 0;

                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++){
                        if (cGrid.getState(i, j).equals("Cr")){
                            count++;
                        }
                    }
                }

                if (count == 0){
                    System.out.println("Cruiser sunk!");
                    crSunk = true;
                }
            }
        }
        else if (cGrid.getState(x, y).equals("S")){
            pGrid2.updateState(x, y, "H");
            cGrid.updateState(x, y, "H");
            System.out.println("Hit!\n");

            if (!sSunk){
                // Check to see if the submarine has been sunk
                int count = 0;

                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++){
                        if (cGrid.getState(i, j).equals("S")){
                            count++;
                        }
                    }
                }

                if (count == 0){
                    System.out.println("Submarine sunk!");
                    sSunk = true;
                }
            }
        }
        else if (cGrid.getState(x, y).equals("D")){
            pGrid2.updateState(x, y, "H");
            cGrid.updateState(x, y, "H");
            System.out.println("Hit!\n");

            if (!dSunk){
                // Check to see if the destroyer has been sunk
                int count = 0;

                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++){
                        if (cGrid.getState(i, j).equals("D")){
                            count++;
                        }
                    }
                }

                if (count == 0){
                    System.out.println("Destoyer sunk!");
                    dSunk = true;
                }
            }
        }
        else{
            pGrid2.updateState(x, y, "M");
            cGrid.updateState(x, y, "M");
            System.out.println("Miss\n");
        }
    }
}
