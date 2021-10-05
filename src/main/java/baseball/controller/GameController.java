package baseball.controller;

import baseball.model.ComputerPlayer;
import baseball.model.Player;

public class GameController extends AbstractGameController {

    @Override
    public Boolean isNothing(Player player, ComputerPlayer computer) {
        if (!super.isNotNull(player, computer)) {
            return false;
        }

        return super.checkNothing(player, computer);
    }

    @Override
    public Boolean isFourBall(Player player, ComputerPlayer computer) {
        if (!super.isNotNull(player, computer)) {
            return false;
        }

       return super.checkFourBall(player, computer);
    }

    @Override
    public Integer getStrikeCount(Player player, ComputerPlayer computer) {
        if (!super.isNotNull(player, computer)) {
            return 0;
        }

        return super.checkStrike(player, computer);
    }

    @Override
    public Integer getBallCount(Player player, ComputerPlayer computer) {
        if (!super.isNotNull(player, computer)) {
            return 0;
        }

        return super.checkBall(player, computer);
    }

}
