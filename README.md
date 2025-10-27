# java-racingcar-precourse
🏎️ 자동차 경주 게임

## 기능 요구사항
### 입력
- [x]  사용자는 자동차 이름을 입력할 수 있어야 한다.
    - [x]  자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        - 5자 이하 기준은 앞뒤 공백을 제거한 후 판별한다.
    - [x]  이름은 줄바꿈을 제외한 모든 문자가 가능하다.
        - 출력이 뒤틀릴 수 있음을 방지하기 위함이다.
    - [x]  공백만 존재하는 이름과 중복되는 이름은 불가능하다.
        - 각 자동차를 구분하기 위함이다.
        - 중복의 기준은 앞뒤 공백을 제거하고 남은 문자열의 완전한 일치이다. 중간 공백의 개수가 다른 것은 중복이 아닌 것으로 취급한다.
    - [x]  자동차 이름은 2개 이상 입력해야 한다.
        - 자동차 경주를 하기 위해서는 2대 이상의 자동차가 필요하다.
- [x]  사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - [x]  시도할 횟수는 자연수만 가능하다.
- [x]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 자동차 경주 게임
- [x]  주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x]  전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
### 출력
- [x]  전진하는 자동차를 출력할 때, `[자동차 이름] : [전진한 수]` 형식으로 출력한다.
    - [x]  자동차 이름은 앞 뒤 공백을 제거하고 사용한다.
    - [x]  전진한 수는 `-`의 개수를 사용하여 출력한다. 예를 들어, 전진한 수가 2일 경우 `--`으로 출력한다.
- [x]  자동차 경주 게임을 완료한 후 누가 우승했는지를 `최종 우승자 : [우승자]` 형식으로 출력한다.
    - [x]  우승자는 자동차 이름으로 출력하며, 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

## 패키지 구조 및 클래스
```text
src.main.java.racingcar
⎿ config
    ⎿ AppConfig.java
⎿ controller
    ⎿ RacingGameController.java
⎿ domain
    ⎿ RacingCar.java
    ⎿ RacingGame.java
⎿ exception
    ⎿ ExceptionMessage.java
    ⎿ UserInputException.java
⎿ parser
    ⎿ Parser.java
⎿ validator
    ⎿ Validator.java
⎿ view
    ⎿ InputView.java
    ⎿ OutputView.java
⎿ Application.java
```
`config` 패키지는 설정과 관련한 클래스가 모여있다.
- `AppConfig` 클래스
  - controller의 생성을 맡음으로써, 의존성을 설정하는 역할을 한다. 

`controller` 패키지는 controller 클래스가 모여있다.
- `RacingGameController` 클래스
  - 사용자 입력과 출력 및 자동차 경주 게임의 전체 흐름을 총괄하는 controller이다.

`domain` 패키지는 자동차 경주 게임의 비즈니스 로직으로써 핵심인 부분이 모여있다.
- `RacingCar` 클래스
  - 경주에 참여하는 자동차이다. 이름과 거리를 가지고 있다.
- `RacingGame` 클래스
  - 자동차 경주 게임의 진행을 담당한다.

`exception` 패키지는 Exception을 관리하기 위한 클래스가 모여있다.
- `ExceptionMessage` enum
  - Exception이 발생할 때의 메시지 상수를 관리하기 위한 enum 클래스
- `UserInputException` 클래스
  - `IllegalArgumentException`을 상속받아 사용자의 입력에 관한 예외를 정의한다.
  - `ExceptionMessage`를 인자로 받는 생성자가 있다.

`parser` 패키지는 파싱에 관한 클래스가 모여있다.
- `Parser` 클래스
  - 입력받은 문자열을 파싱하는 역할을 한다.

`validator` 패키지는 검증에 관한 클래스가 모여있다.
- `Validator` 클래스
  - 파싱한 문자열을 검증하는 역할을 한다.

`view` 패키지는 사용자가 직접 사용하는 입출력에 관한 클래스가 모여있다.
- `InputView` 클래스
  - 사용자 입력에 관한 것을 담당한다.
- `OutputView` 클래스
  - 자동차 경주 게임의 진행이나 결과를 출력하는 것을 담당한다.
- `UserInput` 클래스
  - 사용자의 입력 데이터를 저장하고 전달하는 객체이다.

`Application` 클래스
- 해당 프로그램 전체의 시작점인 main 함수를 가지고 있다.
- `AppConfig`을 통해 controller를 생성하고 실행한다.
