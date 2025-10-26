package racingcar.exception;

public enum ExceptionMessage {
    ONLY_ALLOW_INTEGER("시도할 횟수는 정수만 입력해야 합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
