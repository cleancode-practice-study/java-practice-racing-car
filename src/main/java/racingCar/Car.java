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

    public int getNumber() {
        return RandomUtils.nextInt(START_VALUE, END_VALUE);
    }

    public int getPosition() {
        int number = getNumber();

        if (number >= MOVING_STANDARD)
            this.position++;

        return position;
    }

    public void printResult() {
        int location = getPosition();

        System.out.print(this.name + ":");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}