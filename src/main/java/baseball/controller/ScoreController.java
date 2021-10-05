package baseball.controller;

import baseball.model.AbstractPlayer;
import baseball.model.ComputerPlayer;
import baseball.model.Player;

import java.util.List;
import java.util.Optional;

public class ScoreController {

    public Boolean isNothing(Player player, ComputerPlayer computer) {
        if (!isValid(player, computer)) {
            return false;
        }

        boolean checkNothing = true;
        int i = 0;

        while(checkNothing && i < player.getSize()) {
            checkNothing = !computer.getNumbers().contains(player.getNumbers().get(i));

            i++;
        }

        return checkNothing;
    }

    public Boolean isFourBall(Player player, ComputerPlayer computer) {
        if (!isValid(player, computer)) {
            return false;
        }

        return false;
    }

    private Boolean isValid(Player player, ComputerPlayer computer) {
        if (!isPresent(player, computer)) {
            return false;
        }

        if (!isPresentNumbers(player.getNumbers())) {
            return false;
        }

        if (!isPresentNumbers(computer.getNumbers())) {
            return false;
        }

        return true;
    }

    private Boolean isPresent(Player player, ComputerPlayer computer) {
        if (!Optional.ofNullable(player).isPresent()) {
            return false;
        }

        if (!Optional.ofNullable(computer).isPresent()) {
            return false;
        }

        return true;
    }

    private Boolean isPresentNumbers(List<Integer> numbers) {
        if (!Optional.ofNullable(numbers).isPresent()) {
            return false;
        }

        if (numbers.size() == 0) {
            return false;
        }

        return true;
    }

}
