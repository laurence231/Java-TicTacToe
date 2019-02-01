package w3;

public class Board {
    private char[][] board;
    private char player;

    public Board() {
        board = new char[3][3];
        initialiseBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i]);
        }
    }

    public char getBoardElement(int i, int j) {
        return board[i][j];
    }

    public char getPlayer() {
        System.out.println("The player is: " + player);
        return player;
    }

    public void initialiseBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void setBoardElement(int i, int j, char p) {
        board[i][j] = p;
    }


}
