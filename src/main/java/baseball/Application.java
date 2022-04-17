package baseball;

import baseball.game.GameController;

public class Application {
    public static void main(String[] args) {
        GameController.newGame().run();

        System.out.println("게임 종료");
    }
}
