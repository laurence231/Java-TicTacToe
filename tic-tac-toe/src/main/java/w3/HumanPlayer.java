package w3;

import java.util.Scanner;

public class HumanPlayer implements Player {
    Board board;
    Scanner sc = new Scanner(System.in);
    static char token = 'x';
    public HumanPlayer(Board board){this.board = board;}


    public int ChooseXCoord(){
        System.out.println("Input x coordinate:");
        int x = sc.nextInt();
        return x;
    }

    public int ChooseYCoord(){
        System.out.println("Input y coordinate:");
        int y = sc.nextInt();
        return y;
    }
}
