package baseball.controller;

import baseball.model.ComputerPlayer;
import baseball.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreControllerTest {

    ScoreController scoreController = new ScoreController();
    ComputerPlayer computer = new ComputerPlayer();

    @Nested
    @DisplayName("낫싱 테스트")
    class NothingTest {

        @Test
        void Null을_인자로_받으면_false를_반환한다() {
            Boolean isNothing = scoreController.isNothing(null, null);

            assertFalse(isNothing);
        }

        @Test
        void 인자_중_한_개라도_Null이_포함_되어_있다면_false를_반환한다() {
            Boolean isNothing = scoreController.isNothing(null, computer);

            assertFalse(isNothing);
        }

        @Test
        void 두_컬렉션을_비교하여_같은_요소가_존재한다면_false를_반환한다() {
            StringBuilder getNumbers = new StringBuilder();

            for (int i = 0; i < computer.getSize(); i++) {
                getNumbers.append(computer.getNumbers().get(i));
            }

            getNumbers.reverse();

            Player player = new Player(getNumbers.toString());

            Boolean isNothing = scoreController.isNothing(player, computer);

            assertFalse(isNothing);
        }


    }

}