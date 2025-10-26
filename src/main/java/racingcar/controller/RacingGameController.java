package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.parser.Parser;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.UserInput;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;
    private final Validator validator;
    private final RacingGame racingGame;

    public RacingGameController(
            InputView inputView,
            OutputView outputView,
            Parser parser,
            Validator validator,
            RacingGame racingGame
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.validator = validator;
        this.racingGame = racingGame;
    }

    public void run() {
        UserInput userInput = inputView.readInput();

        List<RacingCar> racingCars = this.parseAndValidateRacingCar(userInput.cars());
        int attemptCount = this.parseAndValidateAttemptCount(userInput.attemptCount());

        List<RacingCar> winCars = racingGame.start(racingCars, attemptCount);

        outputView.printRacingWinner(winCars);

        inputView.closeInput();
    }

    private List<RacingCar> parseAndValidateRacingCar(String cars) {
        List<String> carList = parser.parseCars(cars);
        validator.validateCarNames(carList);

        return carList.stream()
                .map(RacingCar::from)
                .toList();
    }

    private int parseAndValidateAttemptCount(String attemptCountString) {
        int attemptCount = parser.parseAttemptCount(attemptCountString);
        validator.validateAttemptCount(attemptCount);

        return attemptCount;
    }
}
