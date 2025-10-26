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

                assertEquals("pobi,woni", inputResult.cars());
                assertEquals("1", inputResult.attemptCount());
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
