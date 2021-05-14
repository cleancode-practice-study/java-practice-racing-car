package racingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameHelper {
    final Scanner scanner = new Scanner(System.in);

    public void gameStart() {
        List<Car> cars = create();
        racingStart(cars);
        List<String> winnerNames = getWinner(cars);
        printWinner(winnerNames);
    }

    private List<Car> create() {
        List<String> carNames = getNamesByUserInput();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }

        return cars;
    }

    private List<String> getNamesByUserInput() {
        String[] eachCarNames;
        boolean found = false;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

            String userInputNames = scanner.nextLine();
            eachCarNames = splitNames(userInputNames);
            found = checkInvalidName(eachCarNames);

        } while (found);

        List<String> carNames = new ArrayList<String>();
        carNames.addAll(Arrays.asList(eachCarNames));

        return carNames;
    }

    private String[] splitNames(String carsName) {
        String[] eachCarNames = carsName.split(",");

        return eachCarNames;
    }

    private boolean checkInvalidName(String[] eachCarNames) {

        for (String name : eachCarNames) {
            if (name.length() > 5) {
                System.out.println("[ERROR] 차의 이름은 5자 이하만 가능합니다. 다시 입력해주세요.");
                return true;
            }
        }
        return false;
    }

    private void racingStart(List<Car> cars) {
        int tryNum = getTryNum();
        int count = 0;
        System.out.println();
        System.out.println("실행 결과");
        while (count < tryNum) {
            changeCarPosition(cars);
            printRacingResult(cars);
            System.out.println();
            count++;
        }
    }

    private int getTryNum() {//게임 시도 횟수 리턴하는 함수
        int playNum;

        System.out.println("시도할 회수는 몇회인가요?");
        playNum = scanner.nextInt();

        return playNum;
    }

    private void changeCarPosition(List<Car> cars) {//횟 수 한번 당 car의 position 변화 주기
        for (Car car : cars) {
            car.canDrive();
        }
    }

    private void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            car.showResult();
        }
    }

    private List<String> getWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winnerNames = new ArrayList<String>();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void printWinner(List<String> winnerNames) {
        System.out.print("최종우승자: ");

        System.out.print(String.join(", ", winnerNames));

        System.out.println();
    }

}
