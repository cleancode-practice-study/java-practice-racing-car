package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    final Scanner scanner = new Scanner(System.in);

    public void start() {
        List<Car> cars = setCars();
        int repeatNum = askTryTimes();

        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            raceGame(cars);
        }
        winnerName(cars);
    }

    private List<String> askCarName(){
        List<String> cars = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        String carNames = scanner.nextLine();
        String[] carNameList = splitCarNames(carNames);

        for(int i = 0; i < carNameList.length; i++){
            cars.add(carNameList[i]);
        }
        return cars;
    }

    private int askTryTimes(){
        int repeatNum;

        System.out.println("시도할 회수는 몇회인가요?");
        repeatNum = scanner.nextInt();
        System.out.println();

        return repeatNum;
    }

    private String[] splitCarNames(String names){
        String[] carNames = names.split(",");
        return carNames;
    }

    private List<Car> setCars() {
        List<String> carNames = askCarName();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
        return cars;
    }

    private void raceGame(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).race();
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

    private void winnerName(List<Car> cars){
        int winnerPosition = getMaxPosition(cars);
        int winnerCount = 0;

        System.out.print("최종 우승자: ");

        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPosition() == winnerPosition){
                if(winnerCount != 0){
                    System.out.print(", ");
                }
                System.out.print(cars.get(i).getName());
                winnerCount++;
            }
        }
    }
}
