package baseball.util;

import java.util.Optional;

public class CheckNull {

    private CheckNull() { }

    public static void one(Object object) {
        new CheckNull().checkObject(object);
    }

    public static void multiple(Object... objects) {
        new CheckNull().checkObjects(objects);
    }

    private void checkObjects(Object... objects) {
        for (Object object : objects) {
            checkObject(object);
        }
    }

    private void checkObject(Object object) {
        Optional<Object> optionalObject = Optional.ofNullable(object);

        if (!optionalObject.isPresent()) {
            throw new IllegalArgumentException();
        }
    }
}
