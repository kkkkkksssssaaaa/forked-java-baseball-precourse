package baseball.user;

import baseball.number.Numbers;
import baseball.util.Integers;

public final class PlayerUser extends AbstractUser {

    private PlayerUser(Numbers numbers) {
        super(numbers);
    }

    public static PlayerUser init(String consoleInput) {
        Numbers numbers = Numbers.of(
                Integers.toIntArray(consoleInput));

        return new PlayerUser(numbers);
    }

}
