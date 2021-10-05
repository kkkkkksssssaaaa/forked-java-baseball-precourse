package baseball;

import baseball.controller.ScoreController;
import baseball.model.ComputerPlayer;
import baseball.model.Player;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO UI 로직 분리 필요
        ComputerPlayer computer = new ComputerPlayer();
        ScoreController scoreController = new ScoreController();
        System.out.println("[TEST] print computer : " + computer.getNumbers());

        System.out.println("[TEST] 1부터 9까지의 중복되지 않은 숫자 세 개를 연속하여 입력해주세요.");

        String consoleInput = Console.readLine();
        Player player = new Player(consoleInput);

        while(player.getSize() == 0) {
            System.out.println("[TEST] 유효하지 않은 입력입니다. 다시 입력해주세요.");

            String retry = Console.readLine();
            player = new Player(retry);
        }

        System.out.println("[TEST] print player : " + player.getNumbers());

        boolean isPlaying = true;

        while(isPlaying) {
            if (scoreController.isNothing(player, computer)) {
                System.out.println("[TEST] 낫싱!");

                String retry = Console.readLine();
                player = new Player(retry);

                break;
            } else if (scoreController.isFourBall(player, computer)) {
                System.out.println("[TEST] 포볼!");

                String retry = Console.readLine();
                player = new Player(retry);

                break;
            }

            StringBuilder writeHint = new StringBuilder();
            Integer getStrikeCount = scoreController.getStrikeCount(player, computer);

            if (getStrikeCount > 0) {
                writeHint.append(getStrikeCount + " 스트라이크");
            }

            System.out.println(writeHint);

            String retry = Console.readLine();
            player = new Player(retry);
        }
    }
}
