package baseball.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void 세_개의_Number로_인스턴스를_생성할_수_있다() {
        assertDoesNotThrow(() -> Numbers.of(
                Number.of(1), Number.of(2), Number.of(3)));
    }

    @Test
    void 세_개의_이상의_Number로_초기화한다면_IllegalArgumentException을_던져진다() {
        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(
                        Number.of(1), Number.of(2), Number.of(3), Number.of(4)));
    }

    @Test
    void 랜덤한_숫자들로_인스턴스를_초기화할_수_있다() {
        for (int i = 0; i < 1000; i++) {
            assertDoesNotThrow(Numbers::random);
        }
    }

}