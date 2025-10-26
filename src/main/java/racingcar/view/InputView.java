package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CARS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public UserInput readInput() {
        printInputMessage(CARS_INPUT_MESSAGE);
        String cars = Console.readLine();

        printInputMessage(ATTEMPT_COUNT_INPUT_MESSAGE);
        String attemptCount = Console.readLine();

        return UserInput.from(cars, attemptCount);
    }

    private void printInputMessage(String message) {
        System.out.println(message);
    }

    public void closeInput() {
        Console.close();
    }
}
