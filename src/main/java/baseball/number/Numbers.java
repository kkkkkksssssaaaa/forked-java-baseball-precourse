package baseball.number;

import java.util.*;

public class Numbers {

    private final List<Number> numbers;

    public static final int INDEX = 3;

    private Numbers(int... numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>();

        for (int i = 0; i < INDEX; i++) {
            this.numbers.add(Number.of(numbers[i]));
        }
    }

    private Numbers() {
        Set<Number> toSet = new LinkedHashSet<>();

        while(toSet.size() != INDEX) {
            toSet.add(Number.random());
        }

        this.numbers = new ArrayList<>(toSet);
    }

    public static Numbers of(int... intArray) {
        return new Numbers(intArray);
    }

    public static Numbers random() {
        return new Numbers();
    }

    public Number get(int idx) {
        return this.numbers.get(idx);
    }

    public boolean contain(int integer) {
        Number number = Number.of(integer);

        return contain(number);
    }

    public boolean contain(Number number) {
        return this.numbers.contains(number);
    }

    public boolean containsAll(Numbers numbers) {
        return this.numbers.containsAll(numbers.numbers);
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
