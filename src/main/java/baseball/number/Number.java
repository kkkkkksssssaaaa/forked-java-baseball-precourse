package baseball.number;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int num;

    private Number(int num) {
        validate(num);

        this.num = num;
    }

    public static Number of(int num) {
        return new Number(num);
    }

    private void validate(int num) {
        if (num < MIN) {
            throw new IllegalArgumentException();
        }

        if (num > MAX) {
            throw new IllegalArgumentException();
        }
    }

}
