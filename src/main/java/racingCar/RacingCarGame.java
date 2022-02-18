package racingCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class RacingCarGame {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final int NOT_A_NUMBER = -1;
    final Scanner scanner = new Scanner(System.in);

    public void play() {
        String[] names = inputNames();
        int tryNumber = inputTryNumber();
        List<Car> cars = createCars(names);

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++)
            printRaceResult(cars);

        System.out.print("최종 우승자: ");
        List<String> winners = findWinner(cars);
        printWinner(winners);
    }

    public int inputTryNumber() {
        int tryNumber = NOT_A_NUMBER;

        while (!isNumber(tryNumber)) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                tryNumber = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
                tryNumber = NOT_A_NUMBER;
                scanner.next();
            }
        }
        return tryNumber;
    }

    public boolean isNumber(int tryNumber) {
        return tryNumber != NOT_A_NUMBER;
    }

    public String[] splitNames(String name) {
        return name.split(",");
    }

    public boolean checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_LENGTH_STANDARD) {
                System.out.println("[ERROR] 5자 이하의 이름으로 입력하세요.");
                return false;
            }
        }
        return true;
    }

    private String[] inputNames() {
        boolean check;
        String[] names;

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        do {
            String name = scanner.next();
            names = splitNames(name);
            check = checkNameLength(names);
        } while (!check);

        return names;
    }

    public List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    private void printRaceResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int count = car.getMoveCount();
            car.printMove(count);
            System.out.println("");
        }
        System.out.println("");
    }

    public int getMaxPositionIdx(List<Car> cars, Car car, int maxPosition) {
        int maxPositionIdx = 0;

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

    public List<Integer> getCoWinnerIdx(List<Car> cars, int maxPositionIdx) {
        List<Integer> coWinnerIdx = new ArrayList<Integer>();
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

    private void addWinner(List<Car> cars, List<String> winners, int maxPositionIdx) {
        Car car = cars.get(maxPositionIdx);
        String winnerName = car.getName();
        winners.add(winnerName);
    }

    private List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        Car initialCar = cars.get(0);
        int initialPosition = initialCar.getPosition();
        int maxPositionIdx = getMaxPositionIdx(cars, initialCar, initialPosition);
        addWinner(cars, winners, maxPositionIdx);

        List<Integer> coWinnerIndex = getCoWinnerIdx(cars, maxPositionIdx);
        for (int coWinnerIdx : coWinnerIndex)
            addWinner(cars, winners, coWinnerIdx);

        return winners;
    }

    public String printWinner(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(winner);
        return winner;
    }
}
