package racingcar.validator;

import racingcar.exception.UserInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.exception.ExceptionMessage.*;

public class Validator {
    private static final int CAR_LIST_MIN_LENGTH = 2;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final Pattern LINE_TERMINATOR_PATTERN = Pattern.compile("[\n\r\u0085\u2028\u2029]");

    public void validateCarNames(List<String> carNames) {
        validateListLength(carNames);
        validateConflict(carNames);

        carNames.forEach(carName -> {
            validateNameLength(carName);
            validateLineTerminator(carName);
        });
    }

    private void validateListLength(List<String> carNames) {
        if (carNames.size() < CAR_LIST_MIN_LENGTH) {
            throw UserInputException.from(INVALID_CAR_LIST_SIZE);
        }
    }

    private void validateConflict(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() < carNames.size()) {
            throw UserInputException.from(DUPLICATE_CAR_NAME);
        }
    }

    private void validateNameLength(String carName) {
        if (carName.isEmpty()) {
            throw UserInputException.from(EMPTY_CAR_NAME);
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw UserInputException.from(EXCEEDED_CAR_NAME_MAX_LENGTH);
        }
    }

    private void validateLineTerminator(String carName) {
        if (LINE_TERMINATOR_PATTERN.matcher(carName).find()) {
            throw UserInputException.from(CAR_NAME_CONTAINS_LINE_TERMINATOR);
        }
    }
}
