package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isAbleToMove(MoveStrategy moveStrategy) {
        return moveStrategy.canMove();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveCar(String name){
        this.position += 1;
    }

}
