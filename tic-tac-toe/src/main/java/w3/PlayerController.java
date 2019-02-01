package w3;

public enum PlayerController {
    human, computer;


    public PlayerController switchPlayer(PlayerController player) {
        switch (player) {
            case human:
                return computer;
            case computer:
                return human;
            default: throw new RuntimeException("Not valid player");
        }
    }
}
