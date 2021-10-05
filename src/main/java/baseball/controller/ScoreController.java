package baseball.controller;

import baseball.model.ComputerPlayer;
import baseball.model.Player;

import java.util.List;
import java.util.Optional;

public class ScoreController {

    public Boolean isNothing(Player player, ComputerPlayer computer) {
        if (!checkValid(player, computer)) {
            return false;
        }

        if (!checkNotContainsAll(player, computer)) {
            return false;
        }

        return true;
    }

    public Boolean isFourBall(Player player, ComputerPlayer computer) {
        if (!checkValid(player, computer)) {
            return false;
        }

        if (!checkContainsAll(player, computer)) {
            return false;
        }

        if (!checkNotSamePlace(player, computer)) {
            return false;
        }

        return true;
    }

    private Boolean checkValid(Player player, ComputerPlayer computer) {
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

    private Boolean checkPresent(Player player, ComputerPlayer computer) {
        if (!Optional.ofNullable(player).isPresent()) {
            return false;
        }

        if (!Optional.ofNullable(computer).isPresent()) {
            return false;
        }

        return true;
    }

    private Boolean checkPresentNumbers(List<Integer> numbers) {
        if (!Optional.ofNullable(numbers).isPresent()) {
            return false;
        }

        if (numbers.size() == 0) {
            return false;
        }

        return true;
    }

    private Boolean checkContainsAll(Player player, ComputerPlayer computer) {
        boolean checkContainsAll = true;
        int i = 0;

        while(checkContainsAll && i < player.getSize()) {
            checkContainsAll = computer.getNumbers().contains(player.getNumbers().get(i));

            i++;
        }

        return checkContainsAll;
    }

    private Boolean checkNotContainsAll(Player player, ComputerPlayer computer) {
        boolean checkIsNotContainsAll = true;
        int i = 0;

        while(checkIsNotContainsAll && i < player.getSize()) {
            checkIsNotContainsAll = !computer.getNumbers().contains(player.getNumbers().get(i));

            i++;
        }

        return checkIsNotContainsAll;
    }

    private Boolean checkNotSamePlace(Player player, ComputerPlayer computer) {
        boolean checkIsSamePlace = true;
        int i = 0;

        while (checkIsSamePlace && i < player.getSize()) {
            checkIsSamePlace = !computer.getNumbers().get(i).equals(player.getNumbers().get(i));

            i++;
        }

        return checkIsSamePlace;
    }

}
