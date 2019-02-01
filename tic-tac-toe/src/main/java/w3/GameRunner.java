package w3;

public class GameRunner {

    private Board board;
    private HumanPlayer humanController = new HumanPlayer(board);
    private ComputerPlayer computerController = new ComputerPlayer();

    public GameRunner(Board board) {
        this.board = board;
    }

    private void takeTurn(PlayerController player) {
        int x;
        int y;
        switch (player) {
            case human:
                x = humanController.ChooseXCoord();
                y = humanController.ChooseYCoord();
                if (x < 3 && x > -1 && y < 3 && y > -1 && board.getBoardElement(x, y) == '-') {board.setBoardElement(x, y, humanController.token);}
                break;
            case computer:
                int[] coordinates = computerController.chooseCoordinates(board);
                x = coordinates[0];
                y = coordinates[1];
                if (x < 3 && x > -1 && y < 3 && y > -1 && board.getBoardElement(x, y) == '-') {board.setBoardElement(x, y, computerController.token);}
                break;
        }
    }

    public static void main(String[] args){
        System.out.println("Welcome to the game!");
        Board board = new Board();
        GameRunner GameRunner = new GameRunner(board);
        GameFinishState game = new GameFinishState(board);
        board.printBoard();
        PlayerController player = PlayerController.human;
        System.out.println("Player is " + player);

        while(true){
            System.out.println("It is "+ player + "'s Turn to move ");
            GameRunner.takeTurn(player);
            board.printBoard();
            player = player.switchPlayer(player);
            if (game.isGameWon()) {board.initialiseBoard();};

        }
    }
}
