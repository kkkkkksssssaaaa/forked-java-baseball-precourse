package baseball.number;

import baseball.util.CheckNull;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private final int primitiveInteger;

    private Number(int primitiveInteger) {
        verifyInRange(primitiveInteger);

        this.primitiveInteger = primitiveInteger;
    }

    public static Number of(int primitiveInteger) {
        return new Number(primitiveInteger);
    }

    public static int min() {
        return MIN;
    }

    public static int max() {
        return MAX;
    }

    public int getPrimitive() {
        return this.primitiveInteger;
    }

    @Override
    public boolean equals(Object object) {
        CheckNull.one(object);

        if (object.getClass().equals(Number.class)) {
            return this.hashCode() == object.hashCode();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.getPrimitive();
    }

    private void verifyInRange(int primitiveInteger) {
        verifyGreaterThenMinimum(primitiveInteger);
        verifyLessThenMaximum(primitiveInteger);
    }

    private void verifyGreaterThenMinimum(int primitiveInteger) {
        if (primitiveInteger < min()) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyLessThenMaximum(int primitiveInteger) {
        if (primitiveInteger > max()) {
            throw new IllegalArgumentException();
        }
    }
}
