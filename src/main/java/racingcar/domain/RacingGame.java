package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final OutputView outputView;

    public RacingGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<RacingCar> start(List<RacingCar> racingCars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            this.attemptMoveRacingCars(racingCars);
        }

        return this.getWinnerCars(racingCars);
    }

    private void attemptMoveRacingCars(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            racingCar.attemptMove();
            outputView.printRacingCarDistance(racingCar);
        });
    }

    private List<RacingCar> getWinnerCars(List<RacingCar> racingCars) {
        int max = 0;
        List<RacingCar> winCars = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() < max) {
                continue;
            }

            if (racingCar.getDistance() > max) {
                max = racingCar.getDistance();
                winCars = new ArrayList<>();
            }
            winCars.add(racingCar);
        }

        return winCars;
    }
}
