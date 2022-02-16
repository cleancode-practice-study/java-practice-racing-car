package racingCar;

import utils.RandomUtils;

public class Car {
    private static final int START_VALUE = 0;
    private static final int END_VALUE = 9;
    private static final int MOVING_STANDARD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private int getNumber() {
        return RandomUtils.nextInt(START_VALUE, END_VALUE);
    }

    public int getPosition() {
        return this.position;
    }

    private void moveOrStop() {
        int number = getNumber();

        if (number >= MOVING_STANDARD)
            this.position++;
    }

    public int getMoveCount(){
        moveOrStop();
        int moveCount = this.getPosition();

        return moveCount;
    }

    public void printMove(int count) {
        System.out.print(this.name + ":");
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}