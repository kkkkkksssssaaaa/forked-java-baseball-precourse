package baseball.number;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Numbers {

    private final Set<Number> numbers;

    private static final int INDEX = 3;

    private Numbers(Number... numbers) {
        this.numbers = new LinkedHashSet<>(Arrays.asList(numbers));

        validate();
    }

    public static Numbers of(Number... numbers) {
        return new Numbers(numbers);
    }

    public Set<Number> get() {
        return this.numbers;
    }

    private void validate() {
        if (this.numbers.size() != INDEX) {
            throw new IllegalArgumentException();
        }
    }

}
