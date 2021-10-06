package baseball;

import baseball.model.ComputerPlayer;
import baseball.model.GameStatus;
import baseball.view.PlayerView;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        PlayerView playerView = new PlayerView();

        gameView.printStart();

        GameStatus status = GameStatus.PLAYING;
        ComputerPlayer computer = playerView.initializeComputer();

        while(status.equals(GameStatus.PLAYING)) {
            status = gameView.playGame(computer);
        }

        checkGameStatus(status);
    }

    private static void checkGameStatus(GameStatus gameStatus) {
        if (gameStatus.equals(GameStatus.RESTART)) {
            main(new String[] {});
        }

        if (gameStatus.equals(GameStatus.END_GAME)) {
            System.exit(0);
        }
    }
}
