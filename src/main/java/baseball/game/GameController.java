package baseball.game;

import baseball.number.Numbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

    private Game game;

    private GameController() {
        createNewGame();
    }

    public static GameController newGame() {
        return new GameController();
    }

    public void run() {
        GameViewer.printRun();

        while (running()) {
            game.reInitializePlayer();
        }

        isReStart();
    }

    private void isReStart() {
        GameViewer.printIsReStart();

        Running.Status status = Running.fromCode(Console.readLine());

        if (status.equals(Running.Status.RE_START)) {
            createNewGame();
            run();
        }
    }

    private void createNewGame() {
        this.game = Game.ofConsoleInput();
    }

    // TODO 힌트 부분 클래스 분리
    private Hint hint() {
        if (isThreeStrike()) return Hint.THREE_STRIKE;
        if (isNothing()) return Hint.NOTHING;
        if (isFourBall()) return Hint.FOUR_BALL;
        if (isBallAndStrike()) return Hint.BALL_AND_STRIKE;
        if (isStrike()) return Hint.STRIKE;
        if (isBall()) return Hint.BALL;

        throw new IllegalArgumentException();
    }

    private boolean running() {
        return !Hint.THREE_STRIKE.equals(hint());
    }

    private boolean isNothing() {
        if (!game.computerNumbers()
                .containsAny(game.playerNumbers())) {
            GameViewer.printNothing();

            return true;
        }

        return false;
    }

    private boolean isFourBall() {
        if (ballCount() == Numbers.INDEX) {
            GameViewer.printFourBall();

            return true;
        }

        return false;
    }

    private boolean isBallAndStrike() {
        if (isBall() && isStrike()) {
            GameViewer.printBallAndStrike(ballCount(), strikeCount());

            return true;
        }

        return false;
    }

    private boolean isBall() {
        if (ballCount() > 0) {
            GameViewer.printBall(ballCount());

            return true;
        }

        return false;
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
        if (strikeCount() == Numbers.INDEX) {
            GameViewer.printThreeStrike();
            GameViewer.printGameEnd();

            return true;
        }

        return false;
    }

    private boolean isStrike() {
        if (strikeCount() > 0) {
            GameViewer.printStrike(strikeCount());

            return true;
        }

        return false;
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
