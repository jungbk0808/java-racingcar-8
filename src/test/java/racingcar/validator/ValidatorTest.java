package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 정상적으로_검증을_통과한다() {
        List<String> carNames = List.of("pobi", "woni");

        assertDoesNotThrow(() -> validator.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름은_2개_이상이어야_한다() {
        List<String> carNames = List.of("pobi");

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNames(carNames)
        );
    }

    @Test
    void 자동차_이름이_중복되면_예외를_발생한다() {
        List<String> carNames = List.of("pobi", "pobi");

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNames(carNames)
        );
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        List<String> carNames = List.of("pobi", "javaji");

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNames(carNames)
        );
    }

    @Test
    void 자동자_이름이_공백이면_예외를_발생한다() {
        List<String> carNames = List.of("pobi", "");

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNames(carNames)
        );
    }

    @Test
    void 자동차_이름에_줄바꿈이_있으면_예외를_발생한다() {
        List<String> carNames = List.of("pobi", "ja\nva");

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCarNames(carNames)
        );
    }
}
