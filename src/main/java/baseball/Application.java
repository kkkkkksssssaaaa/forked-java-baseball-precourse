package baseball;

import baseball.controller.GameController;
import baseball.model.AbstractPlayer;
import baseball.model.ComputerPlayer;
import baseball.model.GameStatus;
import baseball.model.Player;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO UI 로직 분리 필요
        ComputerPlayer computer = new ComputerPlayer();
        GameController gameController = new GameController();
        System.out.println("[TEST] print computer : " + computer.getNumbers());

        // initialize player logic
        System.out.println("[TEST] 1부터 9까지의 중복되지 않은 숫자 세 개를 연속하여 입력해주세요.");

        String consoleInput = Console.readLine();
        Player player = new Player(consoleInput);

        while(player.getSize() == 0) {
            System.out.println("[TEST] 유효하지 않은 입력입니다. 다시 입력해주세요.");

            String retry = Console.readLine();
            player = new Player(retry);
        }

        System.out.println("[TEST] print player : " + player.getNumbers());

        // game playing logic
        boolean isPlaying = true;

        while(isPlaying) {
            // check isNothing or isFourball
            if (gameController.isNothing(player, computer)) {
                System.out.println("낫싱");

                String retry = Console.readLine();
                player = new Player(retry);

                continue;
            } else if (gameController.isFourBall(player, computer)) {
                System.out.println("포볼");

                String retry = Console.readLine();
                player = new Player(retry);

                continue;
            }

            // strike and ball logic
            StringBuilder writeHint = new StringBuilder();
            Integer getStrikeCount = gameController.getStrikeCount(player, computer);
            Integer getBallCount = gameController.getBallCount(player, computer);

            if (getStrikeCount > 0) {
                writeHint.append(getStrikeCount + "스트라이크 ");
            }

            if (getBallCount > 0) {
                writeHint.append(getBallCount + "볼");
            }

            // restart logic
            if (getStrikeCount.equals(computer.getMaxSize())) {
                System.out.printf("[TEST] %d개의 숫자를 모두 맞히셨습니다! 게임 끝\n", computer.getMaxSize());
                System.out.printf("[TEST] 게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n",
                        GameStatus.RESTART.getValue(),
                        GameStatus.END_GAME.getValue());

                String restartInput = Console.readLine();

                GameStatus gameStatus = gameController.checkRestart(restartInput);

                if (gameStatus.equals(GameStatus.RESTART)) {
                    main(new String[] {});
                }

                if (gameStatus.equals(GameStatus.END_GAME)) {
                    System.exit(0);
                }

                if (gameStatus.equals(GameStatus.NOTHING)) {
                    System.out.printf("[ERROR] 잘못된 값을 입력했습니다! " +
                                    "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n",
                            GameStatus.RESTART.getValue(),
                            GameStatus.END_GAME.getValue());
                    // call restart logic
                }
            }

            System.out.println(writeHint);

            String retry = Console.readLine();
            player = new Player(retry);
        }
    }
}
