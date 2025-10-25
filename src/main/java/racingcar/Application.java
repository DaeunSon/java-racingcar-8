package racingcar;

import racingcar.app.RacingGameFacade;

public class Application {
    public static void main(String[] args) {

        RacingGameFacade racingGame = new RacingGameFacade();
        racingGame.run();

    }
}
