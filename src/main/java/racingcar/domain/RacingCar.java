package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MIN_FORWARD_THRESHOLD = 4;

    private final String carName;
    private int distance;

    private RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public static RacingCar from(String carName) {
        return new RacingCar(carName);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getDistance() {
        return this.distance;
    }

    public void attemptMove() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);

        if (randomNumber >= MIN_FORWARD_THRESHOLD) {
            this.moveForward();
        }
    }

    private void moveForward() {
        distance++;
    }
}
