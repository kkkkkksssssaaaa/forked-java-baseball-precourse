package baseball.game;

import baseball.number.Numbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private final Numbers mockComputerNumbers = Numbers.of(1, 2, 3);

    @Test
    void 숫자가_모두_포함되나_자리가_모두_다른_경우_포볼이다() {
        assertTrue(isFourBall(Numbers.of(3, 1, 2)));
        assertTrue(isFourBall(Numbers.of(2, 3, 1)));
    }

    @Test
    void 숫자가_한_자리라도_같으면_포볼이_아니다() {
        assertFalse(isFourBall(Numbers.of(3, 2, 1)));
        assertFalse(isFourBall(Numbers.of(2, 1, 3)));
    }

    private boolean isFourBall(Numbers compared) {
        List<Boolean> checks = new ArrayList<>();

        for (int i = 0; i < Numbers.INDEX; i++) {
            checks.add(
                    mockComputerNumbers.get(i)
                            .equals(compared.get(i)));
        }

        return !checks.contains(Boolean.TRUE);
    }

}