package racingCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingCarGame {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final int NOT_A_NUMBER = -1;
    final Scanner scanner = new Scanner(System.in);

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

    private String[] splitCarNames(String name) {
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

    private ArrayList<Car> createCars(String[] names) {
        ArrayList<Car> cars = new ArrayList<Car>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }

    private void raceResult(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.race();
            System.out.println("");
        }
    }

    private void printRaceResult(ArrayList<Car> cars) {
        raceResult(cars);
        System.out.println("");
    }

    private int getMaxPositionIdx(ArrayList<Car> cars) {
        int maxPositionIdx = 0;
        Car car = cars.get(0);
        int maxPosition = car.getPosition();

        for (int i = 0; i < cars.size(); i++) {
            car = cars.get(i);
            int position = car.getPosition();

            if (maxPosition < position) {
                maxPosition = position;
                maxPositionIdx = i;
            }
        }

        return maxPositionIdx;
    }

    private ArrayList<Integer> getCoWinnerIdx(ArrayList<Car> cars, int maxPositionIdx) {
        ArrayList<Integer> coWinnerIdx = new ArrayList<Integer>();
        Car car = cars.get(maxPositionIdx);
        int maxPosition = car.getPosition();

        for (int i = maxPositionIdx + 1; i < cars.size(); i++) {
            car = cars.get(i);
            if (maxPosition == car.getPosition()) {
                coWinnerIdx.add(i);
            }
        }

        return coWinnerIdx;
    }

    private void addWinner(ArrayList<Car> cars, int maxPositionIdx,  ArrayList<String> winners) {
        Car car = cars.get(maxPositionIdx);
        String winnerName = car.getName();
        winners.add(winnerName);
    }

    private ArrayList<String> findWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<>();
        int maxPositionIdx = getMaxPositionIdx(cars);
        addWinner(cars, maxPositionIdx , winners);

        ArrayList<Integer> coWinnerIndex = getCoWinnerIdx(cars, maxPositionIdx);
        for (int coWinnerIdx : coWinnerIndex)
            addWinner(cars, coWinnerIdx, winners);

        return winners;
    }

    private void printWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = findWinner(cars);
        String winner = String.join(", ", winners);
        System.out.println(winner);
    }

}