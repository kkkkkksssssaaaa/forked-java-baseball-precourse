package baseball.game;

import baseball.number.Numbers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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

    public Hint hint() {
        if (isNothing()) return Hint.NOTHING;
        if (isFourBall()) return Hint.FOUR_BALL;
        if (isBall()) return Hint.BALL;
        if (isStrike()) return Hint.STRIKE;
        if (isThreeStrike()) return Hint.THREE_STRIKE;

        throw new IllegalArgumentException();
    }

    private boolean isNothing() {
        if (!game.computerNumbers().containsAny(game.playerNumbers())) {
            System.out.println("낫싱");

            return true;
        }

        return false;
    }

    private boolean isFourBall() {
        List<Boolean> checks = new ArrayList<>();

        for (int i = 0; i < Numbers.INDEX; i++) {
            checks.add(
                    game.computerNumbers().get(i)
                            .equals(game.playerNumbers().get(i)));
        }

        return !checks.contains(Boolean.TRUE);
    }

    private boolean isBall() {
        return true;
    }

    private boolean isStrike() {
        for (int i = 0; i < Numbers.INDEX; i++) {

        }

        return true;
    }

    private boolean isThreeStrike() {
        return true;
    }

}
