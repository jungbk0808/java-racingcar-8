package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constant.TestConstants.MOVING_FORWARD;
import static racingcar.constant.TestConstants.STOP;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new OutputView());
    }

    @Test
    void 자동차_경주_게임의_결과로_우승자가_한_명_결정된다() {
        assertRandomNumberInRangeTest(
            () -> {
                RacingCar pobi = RacingCar.from("pobi");
                RacingCar woni = RacingCar.from("woni");
                List<RacingCar> racingCars = List.of(pobi, woni);
                int attemptCount = 1;

                List<RacingCar> winCars = racingGame.start(racingCars, attemptCount);

                assertEquals(List.of(pobi), winCars);
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차_경주_게임의_결과로_우승자가_여러_명_결정된다() {
        assertRandomNumberInRangeTest(
            () -> {
                RacingCar pobi = RacingCar.from("pobi");
                RacingCar woni = RacingCar.from("woni");
                List<RacingCar> racingCars = List.of(pobi, woni);
                int attemptCount = 1;

                List<RacingCar> winCars = racingGame.start(racingCars, attemptCount);

                assertEquals(List.of(pobi, woni), winCars);
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
