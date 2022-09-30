package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumbersTest")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumbersTest {

    @Nested
    @DisplayName("initialize")
    class InitializeTest {

        @Test
        void Number의_가변인수를_통해_초기화할_수_있다() {
            int limit = Numbers.limitSize();
            Number[] numbers = new Number[limit];

            for (int i = 0; i < limit; i++) {
                numbers[i] = Number.of(Number.min() + i);
            }

            assertDoesNotThrow(() -> Numbers.of(numbers));
        }

        @Test
        void 제한된_크기보다_더_많은_Number로_초기화하면_IllegalArgumentException을_던진다() {
            int limit = Numbers.limitSize() + 1;
            Number[] numbers = new Number[limit];

            for (int i = 0; i < limit; i++) {
                numbers[i] = Number.of(Number.min() + i);
            }

            assertThrows(IllegalArgumentException.class, () -> Numbers.of(numbers));
        }

        @Test
        void 제한된_크기보다_더_적은_Number로_초기화하면_IllegalArgumentException을_던진다() {
            int limit = Numbers.limitSize() - 1;
            Number[] numbers = new Number[limit];

            for (int i = 0; i < limit; i++) {
                numbers[i] = Number.of(Number.min() + i);
            }

            assertThrows(IllegalArgumentException.class, () -> Numbers.of(numbers));
        }
    }

    @Nested
    @DisplayName("equals")
    class EqualsTest {

        @Test
        void 같은_Number들로_초기화하면_동등하다() {
            Numbers compareLeft = Numbers.of(Number.of(1), Number.of(2), Number.of(3));
            Numbers compareRight = Numbers.of(Number.of(1), Number.of(2), Number.of(3));

            assertEquals(compareLeft, compareRight);
        }

        @Test
        void 다른_Number들로_초기화하면_동등하지_않다() {
            Numbers compareLeft = Numbers.of(Number.of(1), Number.of(2), Number.of(3));
            Numbers compareRight = Numbers.of(Number.of(1), Number.of(2), Number.of(4));

            assertNotEquals(compareLeft, compareRight);
        }
    }
}