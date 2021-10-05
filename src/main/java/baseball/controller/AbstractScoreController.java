package baseball.controller;

import baseball.model.ComputerPlayer;
import baseball.model.Player;

import java.util.List;
import java.util.Optional;

public abstract class AbstractScoreController {

    public abstract Boolean isNothing(Player player, ComputerPlayer computer);
    public abstract Boolean isFourBall(Player player, ComputerPlayer computer);
    public abstract Integer getStrikeCount(Player player, ComputerPlayer computer);
    public abstract Integer getBallCount(Player player, ComputerPlayer computer);

    protected Boolean checkValid(Player player, ComputerPlayer computer) {
        if (!checkPresent(player, computer)) {
            return false;
        }

        if (!checkPresentNumbers(player.getNumbers())) {
            return false;
        }

        if (!checkPresentNumbers(computer.getNumbers())) {
            return false;
        }

        return true;
    }

    protected Boolean checkPresent(Player player, ComputerPlayer computer) {
        if (!Optional.ofNullable(player).isPresent()) {
            return false;
        }

        if (!Optional.ofNullable(computer).isPresent()) {
            return false;
        }

        return true;
    }

    protected Boolean checkPresentNumbers(List<Integer> numbers) {
        if (!Optional.ofNullable(numbers).isPresent()) {
            return false;
        }

        if (numbers.size() == 0) {
            return false;
        }

        return true;
    }

    protected Boolean checkContainsAll(Player player, ComputerPlayer computer) {
        boolean checkContainsAll = true;
        int i = 0;

        while(checkContainsAll && i < player.getSize()) {
            checkContainsAll = computer.getNumbers().contains(player.getNumbers().get(i));

            i++;
        }

        return checkContainsAll;
    }

    protected Boolean checkNotContainsAll(Player player, ComputerPlayer computer) {
        boolean checkIsNotContainsAll = true;
        int i = 0;

        while(checkIsNotContainsAll && i < player.getSize()) {
            checkIsNotContainsAll = !computer.getNumbers().contains(player.getNumbers().get(i));

            i++;
        }

        return checkIsNotContainsAll;
    }

    protected Integer checkSamePlace(Integer playerNumber, Integer computerNumber) {
        if (computerNumber.equals(playerNumber)) {
            return 1;
        }

        return 0;
    }

    protected Boolean checkNotSamePlace(Player player, ComputerPlayer computer) {
        boolean checkNotSamePlace = true;
        int i = 0;

        while (checkNotSamePlace && i < player.getSize()) {
            checkNotSamePlace = !computer.getNumbers().get(i).equals(player.getNumbers().get(i));

            i++;
        }

        return checkNotSamePlace;
    }

}
