package baseball.game;

import baseball.number.Numbers;
import baseball.user.ComputerUser;
import baseball.user.PlayerUser;
import camp.nextstep.edu.missionutils.Console;

final class Game {

    private final ComputerUser computerUser;
    private PlayerUser playerUser;

    private Game(String consoleInput) {
        this.computerUser = ComputerUser.init();
        this.playerUser = PlayerUser.init(consoleInput);
    }

    static Game ofConsoleInput() {
        return new Game(Console.readLine());
    }

    Numbers computerNumbers() {
        return this.computerUser.numbers();
    }

    Numbers playerNumbers() {
        return this.playerUser.numbers();
    }

    void reInitializePlayer() {
        this.playerUser = PlayerUser.init(Console.readLine());
    }

}
