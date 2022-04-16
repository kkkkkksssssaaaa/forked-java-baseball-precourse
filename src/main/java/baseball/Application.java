package baseball;

import baseball.number.Numbers;
import baseball.user.ComputerUser;
import baseball.user.PlayerUser;
import baseball.util.Integers;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ComputerUser computer = ComputerUser.init();

        String consoleInput = Console.readLine();

        Numbers playerNumbers = Numbers.of(
                Integers.toIntArray(consoleInput));

        PlayerUser player = PlayerUser.init(playerNumbers);
    }
}
