package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_SYMBOL = "-";
    private static final String CAR_NAME_SEPARATOR = ", ";

    public void printRacingCarDistance(RacingCar racingCar) {
        String output = racingCar.getCarName() + " : " +
                DISTANCE_SYMBOL.repeat(racingCar.getDistance());

        this.printOutput(output);
    }

    public void printRacingWinner(List<RacingCar> winners) {
        StringBuilder output = new StringBuilder("최종 우승자 : ");

        winners.forEach(racingCar -> {
            output.append(racingCar.getCarName());
            output.append(CAR_NAME_SEPARATOR);
        });

        output.setLength(output.length() - CAR_NAME_SEPARATOR.length());

        this.printOutput(output.toString());
    }

    private void printOutput(String output) {
        System.out.println(output);
    }
}
