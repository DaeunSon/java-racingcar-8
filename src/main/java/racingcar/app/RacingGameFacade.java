package racingcar.app;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.validator.AttemptValidator;
import racingcar.domain.validator.NameValidator;
import racingcar.infra.RandomMoveStrategy;
import racingcar.io.ConsoleInput;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameFacade {
    private final ConsoleInput consoleInput;

    public RacingGameFacade() {
        this.consoleInput = new ConsoleInput();
    }

    public void run(){
        List<String> carNames = getCarNames();
        int attempts = getAttempts();
        Cars winners = startRacing(carNames, attempts);
        
    }

    private List<String> getCarNames(){
        String input = consoleInput.readNames();
        return NameValidator.parseCarNames(input);
    }

    private int getAttempts(){
        int attempts = consoleInput.readAttempts();
        return AttemptValidator.validateAttempts(attempts);
    }

    private Cars startRacing(List<String> carNames, int attempts){
        Cars cars = Cars.fromNames(carNames);
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();
        for(int i =0;i<attempts;i++){
            cars.moveCars(cars, moveStrategy);
        }
        return getWinners(cars);
    }

    private Cars getWinners(Cars cars){
        return new Cars(cars.getWinners());
    }


}
