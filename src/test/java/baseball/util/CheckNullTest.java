package baseball.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CheckNullTest")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CheckNullTest {

    @Nested
    @DisplayName("one")
    class OneTest {

        @Test
        void 단건의_객체에_대해_Null을_체크할_수_있다() {
            assertDoesNotThrow(() -> CheckNull.one(""));
        }

        @Test
        void 단건의_객체가_Null이면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class, () -> CheckNull.one(null));
        }
    }

    @Nested
    @DisplayName("multiple")
    class MultipleTest {

        @Test
        void 여러_건의_객체에_대해_Null을_체크할_수_있다() {
            assertDoesNotThrow(() -> CheckNull.multiple(""));
            assertDoesNotThrow(() -> CheckNull.multiple("", 0, 1, new Object()));
        }

        @Test
        void 여러_건의_객체_중_Null이_포함되었다면_IllegalArgumentException을_던진다() {
            assertThrows(IllegalArgumentException.class,
                    () -> CheckNull.multiple("", null));
        }
    }
}