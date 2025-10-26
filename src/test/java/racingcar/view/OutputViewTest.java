package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.RacingCar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest extends NsTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }


    @Test
    void 전진하는_자동차를_출력한다() {
        RacingCar racingCar = RacingCar.from("pobi");

        outputView.printRacingCarDistance(racingCar);

        assertEquals("pobi :", output());
    }

    @Test
    void 자동차_경주_게임의_우승자를_출력한다() {
        RacingCar racingCar = RacingCar.from("pobi");
        List<RacingCar> winners = List.of(racingCar);

        outputView.printRacingWinner(winners);

        assertEquals("최종 우승자 : pobi", output());
    }

    @Test
    void 자동차_경주_게임의_여러_우승자를_출력한다() {
        RacingCar pobi = RacingCar.from("pobi");
        RacingCar woni = RacingCar.from("woni");
        List<RacingCar> winners = List.of(pobi, woni);

        outputView.printRacingWinner(winners);

        assertEquals("최종 우승자 : pobi, woni", output());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
