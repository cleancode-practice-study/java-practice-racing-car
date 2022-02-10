package racingCar;

public class Car {
    private static int CAR_DRIVE = 4;

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

    public void move(int randomNum) {
        if (randomNum >= CAR_DRIVE) {
            this.position++;
        }
    }

    // 현재 포지션 만큼 결과 출력
    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name + " : ");

        stringBuilder.append(printProgress(position));

        return stringBuilder.toString();
    }

    private String printProgress(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

}
