package racingcar.exception;

public enum ExceptionMessage {
    ONLY_ALLOW_INTEGER("시도할 횟수는 정수만 입력해야 합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_CAR_LIST_SIZE("자동차는 2대 이상이어야 합니다."),
    EMPTY_CAR_NAME("자동차 이름이 비어있습니다."),
    EXCEEDED_CAR_NAME_MAX_LENGTH("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_CONTAINS_LINE_TERMINATOR("자동차 이름은 줄바꿈을 포함할 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
