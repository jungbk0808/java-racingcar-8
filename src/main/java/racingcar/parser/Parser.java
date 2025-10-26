package racingcar.parser;

import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static racingcar.exception.ExceptionMessage.ONLY_ALLOW_INTEGER;

public class Parser {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final Pattern WHITE_SPACE_PATTERN = Pattern.compile("[\\t\\f]");
    private static final String NORMALIZED_SPACE = " ";

    public List<String> parseCars(String cars) {
        String[] carArray = cars.split(CAR_NAME_DELIMITER);

        return Arrays.stream(carArray)
                .map(String::strip)
                .map(name -> WHITE_SPACE_PATTERN.matcher(name).replaceAll(NORMALIZED_SPACE))
                .toList();
    }

    public int parseAttemptCount(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw UserInputException.from(ONLY_ALLOW_INTEGER);
        }
    }
}
