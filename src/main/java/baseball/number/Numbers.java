package baseball.number;

import java.util.*;

public class Numbers {

    private final Set<Number> numbers;

    private static final int INDEX = 3;

    private Numbers(Number... numbers) {
        validate(numbers);

        this.numbers = new LinkedHashSet<>(Arrays.asList(numbers));
    }

    private Numbers() {
        this.numbers = new LinkedHashSet<>();

        while(this.numbers.size() != INDEX) {
            numbers.add(Number.random());
        }
    }

    public static Numbers of(Number... numbers) {
        return new Numbers(numbers);
    }

    public static Numbers random() {
        return new Numbers();
    }

    public Set<Number> get() {
        return this.numbers;
    }

    private void validate(Number... numbers) {
        HashSet<Number> toSet = new HashSet<>(Arrays.asList(numbers));

        if (toSet.size() != INDEX) {
            throw new IllegalArgumentException();
        }

        if (numbers.length != toSet.size()) {
            throw new IllegalArgumentException();
        }
    }

}
