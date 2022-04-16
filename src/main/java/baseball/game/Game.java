package baseball.game;

import baseball.number.Numbers;
import baseball.user.ComputerUser;
import baseball.user.PlayerUser;

public class Game {

    private final ComputerUser computerUser;
    private final PlayerUser playerUser;

    private Game(Numbers playerNumbers) {
        this.computerUser = ComputerUser.init();
        this.playerUser = PlayerUser.init(playerNumbers);
    }

    public static Game of(Numbers playerNumbers) {
        return new Game(playerNumbers);
    }

}
