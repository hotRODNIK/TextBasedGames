import java.util.Random;

public class Grid {
    private Cell[][] grid;
    String type;

    public Grid(String type){
        if (type.equals("PLAY")) {
            this.type = type;
            Random r = new Random();
            this.grid = new Cell[10][10];

            // Create grid
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j] = new Cell(" ");
                }
            }

            // Randomly generate pieces on the grid
            // Place carrier, battleship, cruiser, sub and destroyer
            String piece = "C";
            int direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
            int x = r.nextInt(11);
            int y = r.nextInt(11);

            while (!checkRandom(x, y, direction, piece)) {
                direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
                x = r.nextInt(11);
                y = r.nextInt(11);
            }

            if (direction == 0) {
                for (int i = 0; i < 5; i++) {
                    this.grid[x][y + i].setState("C");
                }
            } else if (direction == 1) {
                for (int i = 0; i < 5; i++) {
                    this.grid[x + i][y].setState("C");
                }
            }

            piece = "B";
            direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
            x = r.nextInt(11);
            y = r.nextInt(11);

            while (!checkRandom(x, y, direction, piece)) {
                direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
                x = r.nextInt(11);
                y = r.nextInt(11);
            }

            if (direction == 0) {
                for (int i = 0; i < 4; i++) {
                    this.grid[x][y + i].setState("B");
                }
            } else if (direction == 1) {
                for (int i = 0; i < 4; i++) {
                    this.grid[x + i][y].setState("B");
                }
            }

            piece = "Cr";
            direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
            x = r.nextInt(11);
            y = r.nextInt(11);

            while (!checkRandom(x, y, direction, piece)) {
                direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
                x = r.nextInt(11);
                y = r.nextInt(11);
            }

            if (direction == 0) {
                for (int i = 0; i < 3; i++) {
                    this.grid[x][y + i].setState("Cr");
                }
            } else if (direction == 1) {
                for (int i = 0; i < 3; i++) {
                    this.grid[x + i][y].setState("Cr");
                }
            }

            piece = "S";
            direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
            x = r.nextInt(11);
            y = r.nextInt(11);

            while (!checkRandom(x, y, direction, piece)) {
                direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
                x = r.nextInt(11);
                y = r.nextInt(11);
            }

            if (direction == 0) {
                for (int i = 0; i < 3; i++) {
                    this.grid[x][y + i].setState("S");
                }
            } else if (direction == 1) {
                for (int i = 0; i < 3; i++) {
                    this.grid[x + i][y].setState("S");
                }
            }

            piece = "D";
            direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
            x = r.nextInt(11);
            y = r.nextInt(11);

            while (!checkRandom(x, y, direction, piece)) {
                direction = r.nextInt(2); // 0 is vertical, 1 is horizontal
                x = r.nextInt(11);
                y = r.nextInt(11);
            }

            if (direction == 0) {
                for (int i = 0; i < 2; i++) {
                    this.grid[x][y + i].setState("D");
                }
            } else if (direction == 1) {
                for (int i = 0; i < 2; i++) {
                    this.grid[x + i][y].setState("D");
                }
            }
        }
        else if (type.equals("HITSMISS")){
            this.type = type;
            this.grid = new Cell[10][10];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j] = new Cell(" ");
                }
            }
        }
    }

    private boolean checkRandom(int x, int y, int direction, String type){
        if (type.equals("C")){
            if (direction == 0) {
                if (x > 5){
                    return false;
                }
                else if (y > 5){
                    return false;
                }
                else{
                    int count = 0;

                    while (count != 5) {
                        if (!this.grid[x][y + count].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
            else if (direction == 1){
                if (x > 5){
                    return false;
                }
                else if (y > 5){
                    return false;
                }
                else {
                    int count = 0;

                    while (count != 5) {
                        if (!this.grid[x + count][y].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
        }
        else if (type.equals("B")){
            if (direction == 0) {
                if (x > 6){
                    return false;
                }
                else if (y > 6){
                    return false;
                }
                else{
                    int count = 0;

                    while (count != 4) {
                        if (!this.grid[x][y + count].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
            else if (direction == 1){
                if (x > 6){
                    return false;
                }
                else if (y > 6){
                    return false;
                }
                else {
                    int count = 0;

                    while (count != 4) {
                        if (!this.grid[x + count][y].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
        }
        else if (type.equals("Cr")){
            if (direction == 0) {
                if (x > 7){
                    return false;
                }
                else if (y > 7){
                    return false;
                }
                else{
                    int count = 0;

                    while (count != 3) {
                        if (!this.grid[x][y + count].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
            else if (direction == 1){
                if (x > 7){
                    return false;
                }
                else if (y > 7){
                    return false;
                }
                else {
                    int count = 0;

                    while (count != 3) {
                        if (!this.grid[x + count][y].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
        }
        else if (type.equals("S")){
            if (direction == 0) {
                if (x > 7){
                    return false;
                }
                else if (y > 7){
                    return false;
                }
                else{
                    int count = 0;

                    while (count != 3) {
                        if (!this.grid[x][y + count].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
            else if (direction == 1){
                if (x > 7){
                    return false;
                }
                else if (y > 7){
                    return false;
                }
                else {
                    int count = 0;

                    while (count != 3) {
                        if (!this.grid[x + count][y].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
        }
        else if (type.equals("D")){
            if (direction == 0) {
                if (x > 8){
                    return false;
                }
                else if (y > 8){
                    return false;
                }
                else{
                    int count = 0;

                    while (count != 2) {
                        if (!this.grid[x][y + count].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
            else if (direction == 1){
                if (x > 8){
                    return false;
                }
                else if (y > 8){
                    return false;
                }
                else {
                    int count = 0;

                    while (count != 2) {
                        if (!this.grid[x + count][y].getState().equals(" ")) {
                            return false;
                        }
                        count++;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.type.equals("PLAY")) {
            StringBuilder s = new StringBuilder();
            s.append("PIECES BOARD\n");
            s.append("\t").append("0").append("\t").append("1").append("\t").append("2").append("\t").append("3").append("\t").append("4").append("\t")
                    .append("5").append("\t").append("6").append("\t").append("7").append("\t").append("8").append("\t").append("9").append("\n");

            for (int i = 0; i < 10; i++) {
                s.append(i).append("\t");
                for (int j = 0; j < 10; j++) {
                    s.append(this.grid[i][j].getState()).append("\t");
                }
                s.append("\n");
            }

            return s.toString();
        }
        else{
            StringBuilder s = new StringBuilder();
            s.append("HITS AND MISS BOARD\n");
            s.append("\t").append("0").append("\t").append("1").append("\t").append("2").append("\t").append("3").append("\t").append("4").append("\t")
                    .append("5").append("\t").append("6").append("\t").append("7").append("\t").append("8").append("\t").append("9").append("\n");

            for (int i = 0; i < 10; i++) {
                s.append(i).append("\t");
                for (int j = 0; j < 10; j++) {
                    s.append(this.grid[i][j].getState()).append("\t");
                }
                s.append("\n");
            }

            return s.toString();
        }
    }

    public String getState(int x, int y){
        return this.grid[x][y].getState();
    }

    public void updateState(int x, int y, String state){
        this.grid[x][y].setState(state);
    }
}
