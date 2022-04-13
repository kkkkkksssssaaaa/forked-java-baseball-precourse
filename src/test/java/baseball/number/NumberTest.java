package baseball.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void 지정된_범위의_숫자가_아니라면_Number인스턴스를_만들_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> Number.of(Integer.MIN_VALUE));
        assertThrows(IllegalArgumentException.class, () -> Number.of(-1));
        assertThrows(IllegalArgumentException.class, () -> Number.of(0));
        assertThrows(IllegalArgumentException.class, () -> Number.of(10));
        assertThrows(IllegalArgumentException.class, () -> Number.of(Integer.MAX_VALUE));
    }

    @Test
    void 지정된_범위의_숫자로_Number인스턴스를_만들_수_있다() {
        assertDoesNotThrow(() -> Number.of(1));
        assertDoesNotThrow(() -> Number.of(5));
        assertDoesNotThrow(() -> Number.of(9));
    }

}