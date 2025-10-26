package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constant.TestConstants.MOVING_FORWARD;
import static racingcar.constant.TestConstants.STOP;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.from("pobi");
    }

    @Test
    void 자동차는_전진할_수_있다() {
        assertRandomNumberInRangeTest(
            () -> {
                racingCar.attemptMove();
                assertEquals(1, racingCar.getDistance());
            }, MOVING_FORWARD
        );
    }

    @Test
    void 자동차는_멈출_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.attemptMove();
                    assertEquals(0, racingCar.getDistance());
                }, STOP
        );
    }
}
