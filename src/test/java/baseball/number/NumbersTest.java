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

    @Test
    void 정수를_입력받아_contain을_호출하여_해당_Number가_존재한다면_true를_반환한다() {
        Numbers numbers = Numbers.of(1, 2, 3);

        assertTrue(numbers.contain(1));
        assertTrue(numbers.contain(2));
        assertTrue(numbers.contain(3));
    }

    @Test
    void 정수를_입력받아_contain을_호출하여_해당_Number가_존재하지_않는다면_false를_반환한다() {
        Numbers numbers = Numbers.of(1, 2, 3);

        assertFalse(numbers.contain(4));
        assertFalse(numbers.contain(5));
        assertFalse(numbers.contain(6));
    }

    @Test
    void Numbers끼리_비교하여_모든_수를_포함하고_있는지_여부를_알_수_있다() {
        Numbers left = Numbers.of(1, 2, 3);

        assertTrue(left.containsAll(Numbers.of(3, 1, 2)));
        assertTrue(left.containsAll(Numbers.of(2, 1, 3)));
        assertTrue(left.containsAll(Numbers.of(1, 2, 3)));
    }

    @Test
    void Numbers끼리_비교하여_한_개의_수라도_다를_경우_containsAll에서_false_를_반환한다() {
        Numbers left = Numbers.of(1, 2, 3);

        assertFalse(left.containsAll(Numbers.of(3, 1, 4)));
        assertFalse(left.containsAll(Numbers.of(2, 1, 5)));
        assertFalse(left.containsAll(Numbers.of(1, 5, 6)));
    }

}