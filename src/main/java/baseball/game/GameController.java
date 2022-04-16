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
        return !game.computerNumbers()
                .containsAny(game.playerNumbers());
    }

    private boolean isFourBall() {
        return ballCount() == Numbers.INDEX;
    }

    private boolean isBall() {
        return ballCount() > 0;
    }

    private int ballCount() {
        List<Boolean> checks = new ArrayList<>();

        for (int i = 0; i < Numbers.INDEX; i++) {
            checks.add(containAndNotEquals(i));
        }

        return Collections.frequency(checks, Boolean.TRUE);
    }

    private boolean containAndNotEquals(int idx) {
        return game.computerNumbers()
                .contain(game.playerNumbers().get(idx))
                && !game.computerNumbers().get(idx)
                .equals(game.playerNumbers().get(idx));
    }

    private boolean isThreeStrike() {
        return strikeCount() == Numbers.INDEX;
    }

    private boolean isStrike() {
        return strikeCount() > 0;
    }

    private int strikeCount() {
        List<Boolean> checks = new ArrayList<>();

        for (int i = 0; i < Numbers.INDEX; i++) {
            checks.add(
                    game.computerNumbers().get(i)
                            .equals(game.playerNumbers().get(i)));
        }

        return Collections.frequency(checks, Boolean.TRUE);
    }

}
