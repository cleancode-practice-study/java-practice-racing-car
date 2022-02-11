package racingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGame {
    final Scanner scanner = new Scanner(System.in);
    ArrayList<String> winner = new ArrayList<String>();

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = inputCarNames(); // 자동차 이름은 5자 이하만 가능,
        ArrayList<Car> carList = createCars(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        int tryNumber = inputTryNumber();

        System.out.println("실행 결과");
        while (tryNumber > 0) {
            printRaceResult(carList);
            tryNumber--;
        }

        System.out.print("최종 우승자: ");
        printWinner(carList);
    }

    public int inputTryNumber() {
        int tryNumber = scanner.nextInt();

        return tryNumber;
    }

    public String[] inputCarNames() {
        String carNames = scanner.next();
        String[] carName = carNames.split(",");

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

    public void raceResult(ArrayList<Car> carLists) {
        for (int i = 0; i < carLists.size(); i++) {
            carLists.get(i).race(); // 한줄에 점 하나만
            System.out.println("");
        }
    }

    public void printRaceResult(ArrayList<Car> carList) {
        raceResult(carList);
        System.out.println("");
    }

    public int getMaxPositionIdx(ArrayList<Car> carList) {
        int maxPositionIdx = 0;
        int maxPosition = carList.get(0).getPosition();

        for (int i = 0; i < carList.size(); i++) {
            int position = carList.get(i).getPosition(); // 한줄에 점 하나만

            if (maxPosition < position) {
                maxPosition = position;
                maxPositionIdx = i;
            }
        }

        return maxPositionIdx;
    }

    public ArrayList<Integer> getCoWinnerIdx(ArrayList<Car> carList, int maxPositionIdx) {
        int maxPosition = carList.get(maxPositionIdx).getPosition(); // 한줄에 점 하나만
        ArrayList<Integer> coWinnerIdx = new ArrayList<Integer>();

        for (int i = maxPositionIdx + 1; i < carList.size(); i++) {
            if (maxPosition == carList.get(i).getPosition()) {
                coWinnerIdx.add(i);
            }
        }

        return coWinnerIdx;
    }

    public ArrayList<String> addWinner(ArrayList<Car> carList, ArrayList<String> winner, int maxPositionIdx) {
        winner.add(carList.get(maxPositionIdx).getName());

        return winner;
    }

    public void findWinner(ArrayList<Car> carList) {
        int maxPositionIdx = getMaxPositionIdx(carList);
        addWinner(carList, winner, maxPositionIdx);

        ArrayList<Integer> coWinnerIndex = getCoWinnerIdx(carList, maxPositionIdx);
        for (int coWinnerIdx : coWinnerIndex) {
            addWinner(carList, winner, coWinnerIdx);
        }
    }

    public void printWinner(ArrayList<Car> carList) {
        findWinner(carList);
        String winners = String.join(", ", winner);
        System.out.println(winners);
    }

}