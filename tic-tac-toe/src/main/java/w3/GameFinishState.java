package w3;

public class GameFinishState {
    Board board;
    HumanPlayer human;

    public GameFinishState(Board board){ this.board = board;}

    public boolean isGameWon(){
        boolean rows_comp = isGameWonRows(ComputerPlayer.token);
        boolean rows_hum = isGameWonRows(human.token);
        boolean cols_comp = isGameWonCols(ComputerPlayer.token);
        boolean cols_hum = isGameWonCols(human.token);
        boolean diag_comp = isGameWonRows(ComputerPlayer.token);
        boolean diag_hum = isGameWonRows(human.token);
        boolean stale = isStalemate();

        if (rows_comp) {return true;}
        else if (rows_hum) {return true;}
        else if (cols_comp) {return true;}
        else if (cols_hum) {return true;}
        else if (diag_comp) {return true;}
        else if (diag_hum) {return true;}
        else if (stale) {return true;}
        else return false;
    }

    private boolean isGameWonRows(char p) {
        for (int i = 0; i < 3; i++) {
            if (board.getBoardElement(i, 0) == p && board.getBoardElement(i, 1) == p && board.getBoardElement(i, 2) == p) {
                System.out.println(p + "Player wins!!");
                return true;
            }
        }
        return false;
    }

    private boolean isGameWonCols(char p) {
        for (int j = 0; j < 3; j++) {
            if (board.getBoardElement(0, j) == p && board.getBoardElement(1, j) == p && board.getBoardElement(2, j) == p) {
                System.out.println(p + "Player wins!!");
                return true;
            }
        }
        return false;
    }


    private boolean isGameWonDiag(char p) {
        if (board.getBoardElement(0, 0) == p && board.getBoardElement(1, 1) == p && board.getBoardElement(2, 2) == p) {
            System.out.println(p + "Player wins!!");
            return true;
        } else if (board.getBoardElement(2, 0) == p && board.getBoardElement(1, 1) == p && board.getBoardElement(0, 2) == p) {
            System.out.println(p + "Player wins!!");
            return true;
        }
        return false;
    }

    private boolean isStalemate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoardElement(i,j) == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
