package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars fromNames(List<String> names){
        return new Cars(
                names.stream()
                        .map(name -> new Car(name, 0))
                        .collect(Collectors.toList())
        );
    }

    public void moveCars(Cars cars, MoveStrategy moveStrategy){
        for(Car car : cars.values){
            if(car.isAbleToMove(moveStrategy)){
                car.moveCar(car.getName());
            }
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public List<Car> getWinners(){
        int maxPosition = values.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return values.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getValues(){
        return values;
    }
}
