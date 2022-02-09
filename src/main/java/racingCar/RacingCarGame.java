package racingCar;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingCarGame {
    final Scanner scanner = new Scanner(System.in);

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

        System.out.println("최종 우승자: ");
        getWinner();
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

    public void printOneRaceResult(ArrayList<Car> carList){
        raceResult(carList);
        System.out.println("");
    }

    public void getWinner() {

    }

}