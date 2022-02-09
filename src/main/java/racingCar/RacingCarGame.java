package racingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGame {
    final Scanner scanner = new Scanner(System.in);
    ArrayList<String> winner = new ArrayList<String>();

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = inputCarNames();
        ArrayList<Car> carList = createCar(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        int tryNumber = getTryNumber();

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            printOneRaceResult(carList);
        }

        System.out.print("최종 우승자: ");
        int maxPositionIdx = getMaxPositionIdx(carList);
        isEqualMaxPosition(carList, maxPositionIdx);
        printRaceWinner(winner);
    }

    public int getTryNumber() {
        int tryNumber = scanner.nextInt();

        return tryNumber;
    }

    public String[] inputCarNames() {
        String carNames = scanner.next();
        String[] carName = carNames.split(",");

        return carName;
    }

    public ArrayList<Car> createCar(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    public void raceResult(ArrayList<Car> carLists) {
        for (int i = 0; i < carLists.size(); i++) {
            carLists.get(i).race();
            System.out.println("");
        }
    }

    public void printOneRaceResult(ArrayList<Car> carList) {
        raceResult(carList);
        System.out.println("");
    }

    public int getMaxPositionIdx(ArrayList<Car> carLists) {
        int maxPositionIdx = 0;
        int maxPosition = carLists.get(0).getPosition();

        for (int i = 0; i < carLists.size(); i++) {
            int position = carLists.get(i).getPosition();

            if (maxPosition < position) {
                maxPosition = position;
                maxPositionIdx = i;
            }
        }

        addWinner(carLists, winner, maxPositionIdx);

        return maxPositionIdx;
    }

    public void isEqualMaxPosition(ArrayList<Car> carList, int maxPositionIdx) {
        int maxPosition = carList.get(maxPositionIdx).getPosition();

        for (int i = maxPositionIdx + 1; i < carList.size(); i++) {
            if (maxPosition == carList.get(i).getPosition()) {
                addWinner(carList, winner, i);
            }
        }
    }

    public ArrayList<String> addWinner(ArrayList<Car> carList, ArrayList<String> winner, int maxPositionIdx) {
        winner.add(carList.get(maxPositionIdx).getName());

        return winner;
    }

    public void printRaceWinner(ArrayList<String> winner) {
        for (int i = 0; i < winner.size(); i++) {
            System.out.println(winner.get(i));
        }

    }

}