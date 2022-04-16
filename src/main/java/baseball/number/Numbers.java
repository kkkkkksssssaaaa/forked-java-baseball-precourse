package baseball.number;

import java.util.*;

public class Numbers {

    private final Set<Number> numbers;

    private static final int INDEX = 3;

    private Numbers(int... numbers) {
        validate(numbers);

        this.numbers = new LinkedHashSet<>();

        for (int i = 0; i < INDEX; i++) {
            this.numbers.add(Number.of(numbers[i]));
        }
    }

    private Numbers() {
        this.numbers = new LinkedHashSet<>();

        while(this.numbers.size() != INDEX) {
            numbers.add(Number.random());
        }
    }

    public static Numbers of(int... intArray) {
        return new Numbers(intArray);
    }

    public static Numbers random() {
        return new Numbers();
    }

    public Set<Number> get() {
        return this.numbers;
    }

    private void validate(int... intArray) {
        HashSet<Number> toSet = new HashSet<>(Arrays.asList(toNumberArray(intArray)));

        if (toSet.size() != INDEX) {
            throw new IllegalArgumentException();
        }

        if (intArray.length != toSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private Number[] toNumberArray(int... intArray) {
        Number[] toNumber = new Number[intArray.length];

        for (int i = 0; i < toNumber.length; i++) {
            toNumber[i] = Number.of(intArray[i]);
        }

        return toNumber;
    }

}
