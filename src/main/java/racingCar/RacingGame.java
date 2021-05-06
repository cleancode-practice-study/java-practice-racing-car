package racingCar;

import java.util.Scanner;

public class RacingGame {
    private String carName;
    private int repeatNum;

    private String[] carList;
    private Car[] cars;

    private void setupData() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        this.carName = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        this.repeatNum = scanner.nextInt();
        System.out.println();

        this.carList = carName.split(",");
    }

    private void setCars() {
        cars = new Car[carList.length];

        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i]);
        }
    }

    private void raceGame() {
        for (int i = 0; i < carList.length; i++) {
            cars[i].race();
        }
        System.out.println();
    }

    private void winnerName() {
        int maxPosition = 0;
        int index = -1;

        for (int i = 0; i < carList.length; i++) {
            if (maxPosition <= cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
                index = i;
            }
        }
        System.out.print("최종 우승자: ");
        System.out.println(carList[index]);
    }

    public void start() {
        setupData();
        setCars();

        System.out.println("실행 결과");

        for (int i = 0; i < this.repeatNum; i++) {
            raceGame();
        }
        winnerName();
    }
}
