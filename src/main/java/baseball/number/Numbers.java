package baseball.number;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Numbers {

    private final Set<Number> numbers;

    private static final int INDEX = 3;

    private Numbers(Number... numbers) {
        validate(numbers);

        this.numbers = new LinkedHashSet<>(Arrays.asList(numbers));
    }

    public static Numbers of(Number... numbers) {
        return new Numbers(numbers);
    }

    private void validate(Number... numbers) {
        if (numbers.length != INDEX) {
            throw new IllegalArgumentException();
        }
    }

}
