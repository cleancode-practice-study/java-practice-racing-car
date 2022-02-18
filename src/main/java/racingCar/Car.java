package racingCar;

import utils.RandomUtils;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
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
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOrStop(int number) {
        if (number >= MOVING_STANDARD)
            this.position++;
    }

    public int getMoveCount(){
        int number = getNumber();
        moveOrStop(number);

        int moveCount = this.getPosition();

        return moveCount;
    }

    public String printMove(int count) {
        String move = "";
        char racePoint = '-';

        System.out.print(this.name + ":");
        for (int i = 0; i < count; i++) {
            move += racePoint;
            System.out.print("-");
        }
        return move;
    }
}