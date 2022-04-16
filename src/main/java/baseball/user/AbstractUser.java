package baseball.user;

import baseball.number.Numbers;

public abstract class AbstractUser {

    private final Numbers numbers;

    protected AbstractUser(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers numbers() {
        return this.numbers;
    }

}
