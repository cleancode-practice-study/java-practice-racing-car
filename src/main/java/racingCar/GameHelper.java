package racingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {
    final Scanner scanner = new Scanner(System.in);

    public String[] splitNames(){
        String carsName = scanner.nextLine();
        String[] eachCarsName = carsName.split(",");

        return eachCarsName;
    }

    public ArrayList<String> getNames() {
        ArrayList<String> carsNameList = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] eachCarsName = splitNames();

        for(int i = 0 ; i < eachCarsName.length ; i++) {
            carsNameList.add(eachCarsName[i]);
        }

        return carsNameList;
    }

    public ArrayList<Car> makeCars() {
        ArrayList<String> carsNameList = getNames();

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsNameList.size(); i++) {
            Car car = new Car(carsNameList.get(i));
            cars.add(car);
        }

        return cars;
    }

    public int setGameCount() {//게임 시도 횟수 리턴하는 함수
        int playNum;

        System.out.println("시도할 회수는 몇회인가요?");
        playNum = scanner.nextInt();

        return playNum;
    }

    public void driveCars(ArrayList<Car> cars) {//횟 수 한번 당 car의 position 변화 주기
        for (Car car : cars) {
            car.driveCheck();
        }
    }

    public void printGame(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.printAdvance();
        }
    }

    public void racingStart(ArrayList<Car> cars) {
        int playNum = setGameCount();
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

    public int getMaxPosition(ArrayList<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public ArrayList<String> getWinner(ArrayList<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        ArrayList<String> winnerNames = new ArrayList<String>();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    public void pritnWinner(ArrayList<String> winnerNames) {
        System.out.print("최종우승자: ");

        System.out.print(String.join(", ", winnerNames));

        System.out.println();
    }

    public void gameStart() {
        ArrayList<Car> cars = makeCars();
        racingStart(cars);
        ArrayList<String> winnerNames = getWinner(cars);
        pritnWinner(winnerNames);
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

    //    public int checkInvalidNum(int playNum) {
//        if(playNum != )
//    }

}
