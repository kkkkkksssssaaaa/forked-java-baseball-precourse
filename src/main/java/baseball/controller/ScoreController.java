package baseball.controller;

import baseball.model.ComputerPlayer;
import baseball.model.Player;

import java.util.List;
import java.util.Optional;

public class ScoreController extends AbstractScoreController {

    @Override
    public Boolean isNothing(Player player, ComputerPlayer computer) {
        if (!super.checkValid(player, computer)) {
            return false;
        }

        if (!super.checkNotContainsAll(player, computer)) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean isFourBall(Player player, ComputerPlayer computer) {
        if (!super.checkValid(player, computer)) {
            return false;
        }

        if (!super.checkContainsAll(player, computer)) {
            return false;
        }

        if (!super.checkNotSamePlace(player, computer)) {
            return false;
        }

        return true;
    }

    @Override
    public Integer getStrikeCount(Player player, ComputerPlayer computer) {
        if (!super.checkValid(player, computer)) {
            return 0;
        }

        int getCount = 0;

        for (int i = 0; i < computer.getSize(); i++) {
            getCount += checkSamePlace(player.getNumbers().get(i), computer.getNumbers().get(i));
        }

        return getCount;
    }

    @Override
    public Integer getBallCount(Player player, ComputerPlayer computer) {
        return 0;
    }

}
