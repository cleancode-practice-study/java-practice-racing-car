package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public void start() {
        List<Car> cars = createCars();
        int repeatNum = getTryNumber();

        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            raceGame(cars);
        }

        printWinner(getWinner(cars));
    }

    private List<String> getCarNames(){
        final Scanner scanner = new Scanner(System.in);
        List<String> carNames = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String cars = scanner.nextLine();
        String[] names = splitCarNames(cars);

        for(String name : names){
            carNames.add(name);
        }

        return carNames;
    }

    private int getTryNumber(){
        final Scanner scanner = new Scanner(System.in);
        int tryNumber;

        System.out.println("시도할 회수는 몇회인가요?");
        tryNumber = scanner.nextInt();
        System.out.println();

        return tryNumber;
    }

    private String[] splitCarNames(String names){
        String[] carNames = names.split(",");

        return carNames;
    }

    private List<Car> createCars() {
        List<String> carNames = getCarNames();
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    private void raceGame(List<Car> cars) {
        for (Car car : cars) {
            car.raceResult();
        }
        System.out.println();
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (maxPosition <= car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }

    private List<String> getWinner(List<Car> cars) {
        int winnerPosition = getMaxPosition(cars);
        List<String> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

    private void printWinner(List<String> winner) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winner));
    }
}
