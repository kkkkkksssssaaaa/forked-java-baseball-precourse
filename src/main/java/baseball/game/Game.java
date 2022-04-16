package baseball.game;

import baseball.number.Numbers;
import baseball.user.ComputerUser;
import baseball.user.PlayerUser;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final ComputerUser computerUser;
    private PlayerUser playerUser;

    private Game(String consoleInput) {
        this.computerUser = ComputerUser.init();
        this.playerUser = PlayerUser.init(consoleInput);
    }

    public static Game ofConsoleInput() {
        return new Game(Console.readLine());
    }

    public void run() {
        // reInitializePlayer();
    }

    public ComputerUser computer() {
        return this.computerUser;
    }

    public PlayerUser player() {
        return this.playerUser;
    }

    public Numbers computerNumbers() {
        return this.computerUser.numbers();
    }

    public Numbers playerNumbers() {
        return this.playerUser.numbers();
    }

    private void reInitializePlayer() {
        this.playerUser = PlayerUser.init(Console.readLine());
    }

}
