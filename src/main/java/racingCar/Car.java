package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int CAR_DRIVE = 4;

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

    public List<String> getWinners(List<Car> cars) {
        int winScore = getWinScore(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.position == winScore) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getWinScore(List<Car> cars) {
        int winScore = 0;
        for (Car car : cars) {
            if ( winScore < car.position) {
                winScore = car.position;
            }
        }
        return winScore;
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
