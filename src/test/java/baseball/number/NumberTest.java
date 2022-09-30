package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumberTest")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberTest {

    @Nested
    @DisplayName("initialize")
    class InitializeTest {

        @Test
        void 정수_리터럴로_초기화할_수_있다() {
            assertDoesNotThrow(() -> Number.of(1));
        }

        @Test
        void 최소값으로_초기화할_수_있다() {
            assertDoesNotThrow(() -> Number.of(Number.min()));
        }

        @Test
        void 최대값으로_초기화할_수_있다() {
            assertDoesNotThrow(() -> Number.of(Number.max()));
        }

        @Test
        void 최소값_이하로_초기화하면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> Number.of(Number.min() - 1));
        }

        @Test
        void 최대값_이상으로_초기화하면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> Number.of(Number.max() + 1));
        }
    }

    @Nested
    @DisplayName("equals")
    class EqualsTest {

        @Test
        void 동일한_숫자로_초기화한_객체와는_동등하다() {
            assertEquals(Number.of(1), Number.of(1));
        }

        @Test
        void 다른_숫자로_초기화한_객체와는_동등하지_않다() {
            assertNotEquals(Number.of(1), Number.of(2));
        }
    }
}