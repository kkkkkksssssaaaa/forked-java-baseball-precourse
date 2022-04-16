package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 종료에 대한 모델-컨트롤러 구현
        Game.ofConsoleInput().run();

        int isEnd = Integer.parseInt(Console.readLine());

        if (isEnd == 1) {
            main(null);
        }

        if (isEnd == 2) {
            System.out.println("게임 종료");
        }
    }
}
