package racingcar.view;

public record UserInput(
    String cars,
    String attemptCount
) {
    public static UserInput from(String cars, String attemptCount) {
        return new UserInput(cars, attemptCount);
    }
}
