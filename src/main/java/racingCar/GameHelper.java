package racingCar;

import java.util.Scanner;

public class GameHelper {
    final Scanner scanner = new Scanner(System.in);

    public String[] getNames() {//자동차 이름 받아서 쉼표 기준으로 잘라, 문자열 배열에 저장.
        String[] carsNameList;
        String carsName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        carsName = scanner.nextLine();
        carsNameList = carsName.split(",");

        return carsNameList;//문자열 배열 리턴

    }

//    public String[] checkInvalidName(String[] carsNameList) {
//        for(int i = 0 ; i < carsNameList.length ; i++) {
//            if(carsNameList[i].length() >= 5) {
//                System.out.println("[ERROR] 차의 이름은 5자 이하만 가능합니다. 다시 입력해주세요.");
//                return getNames();
//            }
//        }
//        return carsNameList;
//    }

    public Car[] makeCars(String[] carlist) {//문자열 배열 받아서 car 배열에 각각의 car 객체 생성
        Car[] cars = new Car[carlist.length];

        for (int i = 0; i < carlist.length; i++) {
            String name = carlist[i];
            cars[i] = new Car(name);
        }

        return cars;
    }

    public int setGameCount() {//게임 시도 횟수 리턴하는 함수
        int playNum;

        System.out.println("시도할 회수는 몇회인가요?");
        playNum = scanner.nextInt();

        return playNum;
    }

//    public int checkInvalidNum(int playNum) {
//        if(playNum != )
//    }

    public Car[] driveCars(Car[] cars) {//횟 수 한번 당 car의 position 변화 주기
        for (int i = 0; i < cars.length; i++) {
            cars[i].driveCheck();
        }
        return cars;
    }

    public void printGame(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].printAdvance();
        }
    }

    public void racingStart(Car[] cars, int playNum) {
        int count = 0;
        System.out.println();
        System.out.println("실행 결과");
        while (count < playNum) {
            driveCars(cars);
            printGame(cars);
            System.out.println();
            count++;
        }
    }

    public int getMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() > maxPosition) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }

    public String[] getWinner(Car[] cars, int maxPosition) {
        String[] winnerNames = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            if (maxPosition == cars[i].getPosition()) {
                winnerNames[i] = cars[i].getName();
            }
        }
        return winnerNames;
    }

    public void pritnWinner(String[] winnerNames) {
        System.out.print("최종우승자: ");
        for (int i = 0; i < winnerNames.length; i++) {
            if (winnerNames[i] != null) {
                System.out.print(winnerNames[i] + ", ");
            }
        }
        System.out.println();
    }

    public void gameStart() {
        String[] carNames = getNames();
        Car[] cars = makeCars(carNames);
        int playNum = setGameCount();
        racingStart(cars, playNum);
        int maxPosition = getMaxPosition(cars);
        String[] winnerNames = getWinner(cars, maxPosition);
        pritnWinner(winnerNames);
    }

}
