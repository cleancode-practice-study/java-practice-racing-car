package racingCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingCarGame {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final int NOT_A_NUMBER = -1;
    final Scanner scanner = new Scanner(System.in);

    ArrayList<String> winners = new ArrayList<String>();

    public void play() {
        String[] carNames = inputCarNames();
        ArrayList<Car> cars = createCars(carNames);
        int tryNumber = inputTryNumber();

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++)
            printRaceResult(cars);

        System.out.print("최종 우승자: ");
        printWinner(cars);
    }

    private int inputTryNumber() {
        int tryNumber = -1;

        while (!isNumber(tryNumber)) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                tryNumber = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
                tryNumber = -1;
                scanner.next();
        }
        }
        return tryNumber;
    }

    private boolean isNumber(int tryNumber) {
        return tryNumber != NOT_A_NUMBER;
    }

    private String[] splitCarNames(String name){
        String[] names = name.split(",");

        return names;
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String name = scanner.next();
        String[] names = splitCarNames(name);

        for (String carName : names) {
            if (carName.length() > NAME_LENGTH_STANDARD) {
                System.out.println("5자 이하의 이름으로 입력해주세요.");
                name = scanner.next();
                names = splitCarNames(name);
            }
        }
        return names;
    }

    private ArrayList<Car> createCars(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    private void raceResult(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.race();
            System.out.println("");
        }
    }

    private void printRaceResult(ArrayList<Car> carList) {
        raceResult(carList);
        System.out.println("");
    }

    private int getMaxPositionIdx(ArrayList<Car> carList) {
        int maxPositionIdx = 0;
        Car car = carList.get(0);
        int maxPosition = car.getPosition();

        for (int i = 0; i < carList.size(); i++) {
            car = carList.get(i);
            int position = car.getPosition();

            if (maxPosition < position) {
                maxPosition = position;
                maxPositionIdx = i;
            }
        }

        return maxPositionIdx;
    }

    private ArrayList<Integer> getCoWinnerIdx(ArrayList<Car> carList, int maxPositionIdx) {
        ArrayList<Integer> coWinnerIdx = new ArrayList<Integer>();
        Car car = carList.get(maxPositionIdx);
        int maxPosition = car.getPosition();

        for (int i = maxPositionIdx + 1; i < carList.size(); i++) {
            car = carList.get(i);
            if (maxPosition == car.getPosition()) {
                coWinnerIdx.add(i);
            }
        }

        return coWinnerIdx;
    }

    private ArrayList<String> addWinner(ArrayList<Car> carList, int maxPositionIdx) {
        Car car = carList.get(maxPositionIdx);
        String winnerName = car.getName();
        winners.add(winnerName);

        return winners;
    }

    private void findWinner(ArrayList<Car> carList) {
        int maxPositionIdx = getMaxPositionIdx(carList);
        addWinner(carList, maxPositionIdx);

        ArrayList<Integer> coWinnerIndex = getCoWinnerIdx(carList, maxPositionIdx);
        for (int coWinnerIdx : coWinnerIndex)
            addWinner(carList, coWinnerIdx);
    }

    private void printWinner(ArrayList<Car> carList) {
        findWinner(carList);
        String winner = String.join(", ", winners);
        System.out.println(winner);
    }

}