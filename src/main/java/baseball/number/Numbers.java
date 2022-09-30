package baseball.number;

import baseball.util.CheckNull;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Numbers {

    private static final int LIMIT = 3;
    private final Set<Number> numbers;

    private Numbers(Number... numbers) {
        checkSize(numbers);

        this.numbers = toLinkedHashSet(numbers);
    }

    public static Numbers of(Number... numbers) {
        return new Numbers(numbers);
    }

    public static int limitSize() {
        return LIMIT;
    }

    public Set<Number> toCollection() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object object) {
        CheckNull.one(object);

        if (object.getClass().equals(Numbers.class)) {
            return object.hashCode() == this.hashCode();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private void checkSize(Number... numbers) {
        if (toLinkedHashSet(numbers).size() != limitSize()) {
            throw new IllegalArgumentException();
        }
    }

    private Set<Number> toLinkedHashSet(Number... numbers) {
        return new LinkedHashSet<>(Arrays.asList(numbers));
    }
}
