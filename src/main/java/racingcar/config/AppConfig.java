package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGame;
import racingcar.parser.Parser;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final Parser PARSER = new Parser();
    private static final Validator VALIDATOR = new Validator();
    private static final RacingGame RACING_GAME = new RacingGame(OUTPUT_VIEW);

    public static RacingGameController createController() {
        return new RacingGameController(
                INPUT_VIEW,
                OUTPUT_VIEW,
                PARSER,
                VALIDATOR,
                RACING_GAME
        );
    }
}
