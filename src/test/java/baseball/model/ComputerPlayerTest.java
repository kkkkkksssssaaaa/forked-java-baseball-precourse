package baseball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    void 중복되지_않은_숫자로_이루어진_배열을_리턴한다() {
        int testCount = 1000;

        for (int i = 0; i < testCount; i++) {
            ComputerPlayer number = new ComputerPlayer();

            assertEquals(number.getNumbers().size(), 3);

            System.out.println("print number : " + number.getNumbers());
        }
    }

}