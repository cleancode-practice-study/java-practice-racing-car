package racingCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingCarGame {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final int NOT_A_NUMBER = -1;
    final Scanner scanner = new Scanner(System.in);
    ArrayList<String> winner = new ArrayList<String>();

    public void play() {
        String[] carNames = inputCarNames();
        ArrayList<Car> carList = createCars(carNames);
        int tryNumber = inputTryNumber();
        boolean isNum = isNumber(tryNumber);
        if (!isNum)
            System.exit(0);

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++)
            printRaceResult(carList);

        System.out.print("최종 우승자: ");
        printWinner(carList);
    }

    public int inputTryNumber() {
        int tryNumber = 0;

        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            tryNumber = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            tryNumber = -1;
        }

        return tryNumber;
    }

    public boolean isNumber(int tryNumber) {
        if (tryNumber == NOT_A_NUMBER)
            return false;
        return true;
    }

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.next();
        String[] carName = carNames.split(",");

        for (String name : carName) {
            if (name.length() > NAME_LENGTH_STANDARD) {
                System.out.println("5자 이하의 이름으로 입력해주세요.");
                carNames = scanner.next();
                carName = carNames.split(",");
            }
        }
        return carName;
    }

    public ArrayList<Car> createCars(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    public void raceResult(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.race();
            System.out.println("");
        }
    }

    public void printRaceResult(ArrayList<Car> carList) {
        raceResult(carList);
        System.out.println("");
    }

    public int getMaxPositionIdx(ArrayList<Car> carList) {
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

    public ArrayList<Integer> getCoWinnerIdx(ArrayList<Car> carList, int maxPositionIdx) {
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

    public ArrayList<String> addWinner(ArrayList<Car> carList, int maxPositionIdx) {
        Car car = carList.get(maxPositionIdx);
        String winnerName = car.getName();
        winner.add(winnerName);

        return winner;
    }

    public void findWinner(ArrayList<Car> carList) {
        int maxPositionIdx = getMaxPositionIdx(carList);
        addWinner(carList, maxPositionIdx);

        ArrayList<Integer> coWinnerIndex = getCoWinnerIdx(carList, maxPositionIdx);
        for (int coWinnerIdx : coWinnerIndex)
            addWinner(carList, coWinnerIdx);
    }

    public void printWinner(ArrayList<Car> carList) {
        findWinner(carList);
        String winners = String.join(", ", winner);
        System.out.println(winners);
    }

}