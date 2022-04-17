package baseball.game;

public enum RunningStatus {

    RE_START("1"),
    END("2")
    ;

    private final String code;

    RunningStatus(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

    public RunningStatus fromCode(String code) {
        if (code.equals(RE_START.code())) {
            return RE_START;
        }

        if (code.equals(END.code())) {
            return END;
        }

        throw new IllegalArgumentException("Invalid running status code");
    }

}
