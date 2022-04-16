package baseball.game;

import baseball.user.ComputerUser;
import baseball.user.PlayerUser;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final ComputerUser computerUser;
    private final PlayerUser playerUser;

    private Game(String consoleInput) {
        this.computerUser = ComputerUser.init();
        this.playerUser = PlayerUser.init(consoleInput);
    }

    public static Game ofConsoleInput() {
        return new Game(Console.readLine());
    }

}
