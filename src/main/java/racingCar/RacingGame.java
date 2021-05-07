package racingCar;

import java.util.Scanner;

public class RacingGame {
    final Scanner scanner = new Scanner(System.in);
    private String[] carList;
    private Car[] cars;

    public void start() {
        setupData();
        setCars();

        int repeatNum = askTryTimes();

        System.out.println("실행 결과");
        for (int i = 0; i < repeatNum; i++) {
            raceGame();
        }
        winnerName();
    }

    private String[] askCarName(){
        String carName;
        String[] cars;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
        carName = scanner.nextLine();

        cars = splitString(carName);

        return cars;
    }

    private int askTryTimes(){
        int repeatNum;

        System.out.println("시도할 회수는 몇회인가요?");
        repeatNum = scanner.nextInt();

        System.out.println();
        return repeatNum;
    }

    private void setupData() {
        askCarName();
        askTryTimes();
    }

    private String[] splitString(String name){
        this.carList = name.split(",");
        return carList;
    }

    private void setCars() {
        cars = new Car[carList.length];

        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i]);
        }
    }

    private void raceGame() {
        for (int i = 0; i < carList.length; i++) {
            cars[i].race();
        }
        System.out.println();
    }

    private int getMacPosition() {
        int maxPosition = 0;

        for (int i = 0; i < carList.length; i++) {
            if (maxPosition <= cars[i].getPosition()) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }

    private void winnerName(){
        int winnerPosition = getMacPosition();
        int winnerCount = 0;

        System.out.print("최종 우승자: ");

        for(int i = 0; i<carList.length; i++){
            if(cars[i].getPosition() == winnerPosition){
                if(winnerCount != 0){
                    System.out.print(", ");
                }
                System.out.print(carList[i]);
                winnerCount++;
            }
        }
    }
}
