package baseball.user;

import baseball.number.Number;
import baseball.number.Numbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerUserTest {

    @Test
    void 세_개의_서로_다른_숫자로_인스턴스화할_수_있다() {
        assertDoesNotThrow(() ->
                PlayerUser.init(
                        Numbers.of(Number.of(1), Number.of(2), Number.of(3))));
    }

    @Test
    void 유효하지_않은_숫자로_인스턴스를_생성하면_IllegalArgumentException이_던져진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init(
                        Numbers.of(Number.of(1), Number.of(2), Number.of(3), Number.of(3))));

        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init(
                        Numbers.of(Number.of(1), Number.of(2), Number.of(3), Number.of(4))));

        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init(
                        Numbers.of(Number.of(1), Number.of(2))));
    }

}