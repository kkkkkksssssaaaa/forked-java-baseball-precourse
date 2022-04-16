package baseball.user;

import baseball.number.Numbers;

public class PlayerUser extends AbstractUser {

    private PlayerUser(Numbers numbers) {
        super(numbers);
    }

    public static PlayerUser init(Numbers numbers) {
        return new PlayerUser(numbers);
    }

}
