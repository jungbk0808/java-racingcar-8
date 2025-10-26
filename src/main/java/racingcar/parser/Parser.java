package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

}
