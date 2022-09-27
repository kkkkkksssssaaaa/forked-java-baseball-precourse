package baseball.user;

import baseball.number.Numbers;

public final class ComputerUser extends AbstractUser {

    private ComputerUser() {
        super(Numbers.random());
    }

    public static ComputerUser init() {
        return new ComputerUser();
    }

}
