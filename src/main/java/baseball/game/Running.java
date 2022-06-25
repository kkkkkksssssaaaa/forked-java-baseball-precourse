package baseball.game;

public class Running {

    public static Status fromCode(String code) {
        if (code.equals(Status.RE_START.code())) {
            return Status.RE_START;
        }

        if (code.equals(Status.END.code())) {
            return Status.END;
        }

        throw new IllegalArgumentException("Invalid running status code");
    }

    public enum Status {
        RE_START("1"),
        END("2")
        ;

        private final String code;

        Status(String code) {
            this.code = code;
        }

        public String code() {
            return this.code;
        }
    }

}
