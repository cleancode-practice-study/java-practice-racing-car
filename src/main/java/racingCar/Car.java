package racingCar;

import utils.RandomUtils;

public class Car {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_NUM = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void canDrive() {//전진할 지 안할 지 결정 후 포지션 변경
        int driveNum = RandomUtils.nextInt(RANDOM_START, RANDOM_END);

        if (driveNum >= MOVE_NUM) {
            position++;
        }
    }

    public void showResult() {
        System.out.print(name + " : ");
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
