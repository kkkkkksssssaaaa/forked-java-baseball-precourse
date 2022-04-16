package baseball.game;

public class GameController {

    private final Game game;

    private GameController(Game game) {
        this.game = game;
    }

    public static GameController of(Game game) {
        return new GameController(game);
    }

    public boolean continueGame() {
        return !Hints.THREE_STRIKE.equals(hint());
    }

    private Hints hint() {
        return Hints.THREE_STRIKE;
    }

    enum Hints {
        BALL,
        STRIKE,
        FOUR_BALL,
        NOTHING,
        THREE_STRIKE
        ;
    }

}
