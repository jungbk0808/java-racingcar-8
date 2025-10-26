package racingcar.exception;

public class UserInputException extends IllegalArgumentException {
    public UserInputException(String message) {
        super(message);
    }

    public static UserInputException from(ExceptionMessage exceptionMessage) {
        return new UserInputException(exceptionMessage.message());
    }
}
