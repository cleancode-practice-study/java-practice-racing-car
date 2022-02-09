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

    public int getNumber() {
        return RandomUtils.nextInt(START_VALUE, END_VALUE);
    }

    public int isMove() {
        int number = getNumber();

        if (number >= MOVING_STANDARD)
            this.position++;

        return position;
    }

    public int getPosition() {
        return position;
    }

    public void race() {
        int location = isMove();

        System.out.print(this.name + ":");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}