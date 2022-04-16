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
        return !Hint.THREE_STRIKE.equals(hint());
    }

    private Hint hint() {
        if (isNothing()) return Hint.NOTHING;
        if (isFourBall()) return Hint.FOUR_BALL;
        if (isBall()) return Hint.BALL;
        if (isStrike()) return Hint.STRIKE;
        if (isThreeStrike()) return Hint.THREE_STRIKE;

        throw new IllegalArgumentException();
    }

    private boolean isNothing() {
        return true;
    }

    private boolean isFourBall() {
        return true;
    }

    private boolean isBall() {
        return true;
    }

    private boolean isStrike() {
        return true;
    }

    private boolean isThreeStrike() {
        return true;
    }

}
