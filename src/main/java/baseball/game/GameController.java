package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private Game game;
    private HintController hint;

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
        this.hint = HintController.of(this.game);
    }

    private boolean running() {
        return !Hint.THREE_STRIKE.equals(hint.hint());
    }

}
