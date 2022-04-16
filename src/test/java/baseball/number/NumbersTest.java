package baseball.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void 길이가_3인_가변인수를_통해_인스턴스를_생성할_수_있다() {
        assertDoesNotThrow(() -> Numbers.of(1, 2, 3));
        assertDoesNotThrow(() -> Numbers.of(8, 7, 3));
        assertDoesNotThrow(() -> Numbers.of(8, 7, 4));
        assertDoesNotThrow(() -> Numbers.of(8, 7, 1));
        assertDoesNotThrow(() -> Numbers.of(9, 7, 1));
    }

    @Test
    void 길이가_3이_아닌_가변인수로_초기화한다면_IllegalArgumentException이_던져진다() {
        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2));

        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2, 5, 7));

        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1));
    }

    @Test
    void 가변인수_중_같은_숫자가_존재한다면_IllegalArgumentException이_던져진다() {
        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2, 2));

        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 2, 3, 3));

        assertThrows(IllegalArgumentException.class,
                () -> Numbers.of(1, 1, 2, 2, 3, 3));
    }

    @Test
    void 랜덤한_숫자들로_인스턴스를_초기화할_수_있다() {
        for (int i = 0; i < 1000; i++) {
            assertDoesNotThrow(Numbers::random);
        }
    }

}