package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        List<Car> cars = createCars();
        int repeatNum = getTryNumber();

        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            raceGame(cars);
        }
        System.out.print("최종 우승자: ");
        getWinner(cars);
    }

    private List<String> getCarName(){
        List<String> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String carNames = scanner.nextLine();
        String[] names = splitCarNames(carNames);

        for(String eachName : names){
            cars.add(eachName);
        }

        return cars;
    }

    private int getTryNumber(){
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
        List<String> carNames = getCarName();
        List<Car> cars = new ArrayList<>();

        for (String eachName : carNames) {
            Car car = new Car(eachName);
            cars.add(car);
        }
        return cars;
    }

    private void raceGame(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).oneTimeRace();
        }
        System.out.println();
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (int i = 0; i < cars.size(); i++) {
            if (maxPosition <= cars.get(i).getPosition()) {
                maxPosition = cars.get(i).getPosition();
            }
        }
        return maxPosition;
    }

    private void getWinner(List<Car> cars) {
        int winnerPosition = getMaxPosition(cars);
        int winnerCount = 0;

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == winnerPosition) {
                winnerPrint(cars.get(i).getName(), winnerCount);
                winnerCount++;
            }
        }
    }

    private void winnerPrint(String winnerName, int winnerCount){
        if(winnerCount != 0){
            System.out.print(", ");
        }
        System.out.print(winnerName);
    }
}
