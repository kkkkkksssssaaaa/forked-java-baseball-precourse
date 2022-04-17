package baseball.game;

import baseball.number.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

    private final Game game;

    private GameController(Game game) {
        this.game = game;
    }

    public static GameController newGame() {
        return new GameController(
                Game.ofConsoleInput());
    }

    public void run() {
        while (continueGame()) {
            game.reInitializePlayer();
        }
    }

    public boolean continueGame() {
        return !Hint.THREE_STRIKE.equals(hint());
    }

    // TODO 콘솔 출력 viewer 에서 제어
    public Hint hint() {
        if (isThreeStrike()) {
            System.out.println("3스트라이크");
            return Hint.THREE_STRIKE;
        }
        if (isNothing()) {
            System.out.println("낫싱");
            return Hint.NOTHING;
        }
        if (isFourBall()) {
            System.out.println("포볼");
            return Hint.FOUR_BALL;
        }
        if (isBallAndStrike()) {
            String formattedString = String.format("%d볼 %d스트라이크", ballCount(), strikeCount());
            System.out.println(formattedString);
            return Hint.BALL_AND_STRIKE;
        }
        if (isStrike()) {
            String formattedString = String.format("%d스트라이크", strikeCount());
            System.out.println(formattedString);
            return Hint.STRIKE;
        }
        if (isBall()) {
            String formattedString = String.format("%d볼", ballCount());
            System.out.println(formattedString);
            return Hint.BALL;
        }

        throw new IllegalArgumentException();
    }

    private boolean isNothing() {
        return !game.computerNumbers()
                .containsAny(game.playerNumbers());
    }

    private boolean isFourBall() {
        return ballCount() == Numbers.INDEX;
    }

    private boolean isBallAndStrike() {
        return isBall() && isStrike();
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
