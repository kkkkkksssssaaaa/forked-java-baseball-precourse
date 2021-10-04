package baseball;

import baseball.model.ComputerPlayer;
import baseball.model.Player;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO UI 로직 분리 필요
        ComputerPlayer computer = new ComputerPlayer();

        System.out.println("[TEST] 1부터 9까지의 중복되지 않은 숫자 세 개를 연속하여 입력해주세요.");

        String consoleInput = Console.readLine();
        Player player = new Player(consoleInput);

        while(player.getSize() == 0) {
            System.out.println("[TEST] 유효하지 않은 입력입니다. 다시 입력해주세요.");

            String retry = Console.readLine();
            player = new Player(retry);
        }

        System.out.println("print player : " + player.getNumbers());
        System.out.println("print computer : " + computer.getNumbers());
    }
}
