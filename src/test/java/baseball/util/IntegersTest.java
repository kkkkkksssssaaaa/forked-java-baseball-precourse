package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegersTest {

    @Test
    void 콘솔에서_입력받은_문자열을_숫자_배열로_변환할_수_있다() {
        String consoleInput = "123";

        int[] toIntArray = Integers.toIntArray(consoleInput);

        assertEquals(toIntArray[0], 1);
        assertEquals(toIntArray[1], 2);
        assertEquals(toIntArray[2], 3);
    }

    @Test
    void 콘솔에서_입력받은_문자열을_숫자_배열로_변환할_수_없다면_IllegalArgumentException이_던져진다() {
        String consoleInput = "123ㅁ";

        assertThrows(IllegalArgumentException.class,
                () -> Integers.toIntArray(consoleInput));
    }

}