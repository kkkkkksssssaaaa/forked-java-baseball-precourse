package baseball.game;

final class GameViewer {

    static void printRun() {
        System.out.println("숫자를 입력해주세요");
    }

    static void printIsReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static void printThreeStrike() {
        System.out.println("3스트라이크");
    }

    static void printNothing() {
        System.out.println("낫싱");
    }

    static void printFourBall() {
        System.out.println("포볼");
    }

    static void printBallAndStrike(int ballCount, int strikeCount) {
        String formattedString =
                String.format(
                        "%d볼 %d스트라이크",
                        ballCount,
                        strikeCount);

        System.out.println(formattedString);
    }

    static void printStrike(int strikeCount) {
        String formattedString =
                String.format(
                        "%d스트라이크",
                        strikeCount);

        System.out.println(formattedString);
    }

    static void printBall(int ballCount) {
        String formattedString =
                String.format(
                        "%d볼",
                        ballCount);

        System.out.println(formattedString);
    }

}
