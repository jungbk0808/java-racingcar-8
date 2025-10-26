package racingcar.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    void 자동차_이름은_쉼표로_분리할_수_있다() {
        String cars = "pobi,woni";

        List<String> carNames = parser.parseCars(cars);

        assertEquals(carNames, List.of("pobi", "woni"));
    }

    @Test
    void 자동차_이름은_앞뒤_공백을_제거한다() {
        String cars = "  pobi  ,  woni  ,   ";

        List<String> carNames = parser.parseCars(cars);

        assertEquals(carNames, List.of("pobi", "woni", ""));
    }

    @Test
    void 자동차_이름_중간의_공백을_통일한다() {
        String cars = "po\tbi,wo\f ni";

        List<String> carNames = parser.parseCars(cars);

        assertEquals(carNames, List.of("po bi", "wo  ni"));
    }


}
