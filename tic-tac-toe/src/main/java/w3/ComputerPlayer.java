package w3;

public class ComputerPlayer implements Player {
    static char token = 'o';

    public ComputerPlayer() {
    }

    public int[] chooseCoordinates(Board board) {
        int[] comp_rows = isCloseRows(token, board);
        int[] comp_cols = isCloseCols(token, board);
        int[] comp_diag = isCloseDiag(token, board);

        int[] rows = isCloseRows(HumanPlayer.token, board);
        int[] cols = isCloseCols(HumanPlayer.token, board);
        int[] diag = isCloseDiag(HumanPlayer.token, board);

        if (comp_rows != null) {return comp_rows;}
        else if (comp_cols != null) {return comp_cols;}
        else if (comp_diag != null) {return comp_diag;}
        else if (rows != null) {return rows;}
        else if (cols != null) {return cols;}
        else if (diag != null) {return diag;}
        else {return chooseRandom(board);}
    }

    private int[] isCloseRows(char p, Board board) {
        int[] coordinates = new int[2];
        for (int i = 0; i < 3; i++) {
            {
                if (board.getBoardElement(i, 0) == p && board.getBoardElement(i, 1) == p && board.getBoardElement(i, 2) == '-') {
                    System.out.println("Choose coord " + i + "," + 2);
                    coordinates[0] = i;
                    coordinates[1] = 2;
                    return coordinates;
                }
                if (board.getBoardElement(i, 0) == p && board.getBoardElement(i, 2) == p && board.getBoardElement(i, 1) == '-') {
                    System.out.println("Choose coord " + i + "," + 1);
                    coordinates[0] = i;
                    coordinates[1] = 1;
                    return coordinates;

                }
                if (board.getBoardElement(i, 1) == p && board.getBoardElement(i, 2) == p && board.getBoardElement(i, 0) == '-') {
                    System.out.println("Choose coord " + i + "," + 0);
                    coordinates[0] = i;
                    coordinates[1] = 0;
                    return coordinates;
                }
            }
        }
        return null;
    }

    private int[] isCloseCols(char p, Board board) {
        int[] coordinates = new int[2];
        for (int i = 0; i < 3; i++) {
            {
                if (board.getBoardElement(0, i) == p && board.getBoardElement(1, i) == p && board.getBoardElement(2, i) == '-') {
                    System.out.println("Choose coord " + 2 + "," + i);
                    coordinates[0] = 2;
                    coordinates[1] = i;
                    return coordinates;
                }
                if (board.getBoardElement(0, i) == p && board.getBoardElement(2, i) == p && board.getBoardElement(1, i) == '-') {
                    System.out.println("Choose coord " + 1 + "," + i);
                    coordinates[0] = 1;
                    coordinates[1] = i;
                    return coordinates;
                }
                if (board.getBoardElement(1, i) == p && board.getBoardElement(2, i) == p && board.getBoardElement(0, i) == '-') {
                    System.out.println("Choose coord " + 0 + "," + i);
                    coordinates[0] = 0;
                    coordinates[1] = i;
                    return coordinates;
                }
            }
        }
        return null;
    }

    private int[] isCloseDiag(char p, Board board) {
        int[] coordinates = new int[2];
        if (board.getBoardElement(0, 0) == p && board.getBoardElement(1, 1) == p && board.getBoardElement(2, 2) == '-') {
            System.out.println("Choose coord 2, 2");
            coordinates[0] = 2;
            coordinates[1] = 2;
            return coordinates;
        }
        if (board.getBoardElement(0, 0) == p && board.getBoardElement(1, 1) == '-' && board.getBoardElement(2, 2) == p) {
            System.out.println("Choose coord 1, 1");
            coordinates[0] = 1;
            coordinates[1] = 1;
            return coordinates;
        }
        if (board.getBoardElement(0, 0) == '-' && board.getBoardElement(1, 1) == p && board.getBoardElement(2, 2) == p) {
            System.out.println("Choose coord 0, 0");
            coordinates[0] = 0;
            coordinates[1] = 0;
            return coordinates;
        }
        return null;
    }

    private int[] chooseRandom(Board board) {
        int[] coordinates = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoardElement(i, j) == '-') {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    return coordinates;
                }
            }
        }
   return null; }
}


