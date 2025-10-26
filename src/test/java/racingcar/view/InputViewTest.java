package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest extends NsTest {

    @Test
    void 사용자의_입력을_받을_수_있다() {
        assertSimpleTest(
            () -> {
                InputView inputView = new InputView();
                run("pobi,woni", "1");

                UserInput inputResult = inputView.readInput();

                assertEquals(inputResult.cars(), "pobi,woni");
                assertEquals(inputResult.attemptCount(), "1");
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
