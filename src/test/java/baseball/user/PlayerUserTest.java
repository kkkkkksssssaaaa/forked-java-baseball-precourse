package baseball.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerUserTest {

    @Test
    void 세_개의_서로_다른_숫자로_인스턴스화할_수_있다() {
        assertDoesNotThrow(() ->
                PlayerUser.init("123"));
    }

    @Test
    void 유효하지_않은_숫자로_인스턴스를_생성하면_IllegalArgumentException이_던져진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init("1233"));

        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init("1234"));

        assertThrows(
                IllegalArgumentException.class,
                () -> PlayerUser.init("12"));
    }

}