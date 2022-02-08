package racingCar;
import java.util.Scanner;

public class RacingCarGame {
    final Scanner scanner = new Scanner(System.in);

    public void gamePlay(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = createCar();
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryNumber = getTryNumber();
        System.out.println("실행 결과");
        for(int i = 0; i < tryNumber; i++){
            carRace(carNames);
        }

        System.out.println("최종 우승자: ");
        getWinner();
    }

    public int getTryNumber(){
        int attempts = scanner.nextInt();

        return attempts;
    }

    public String[] createCar(){
        String carNames = scanner.next();
        String[] carName = carNames.split(",");

        return carName;
    }

    public void carRace(String[] carNames){
        for (String carName : carNames) {
            Car car = new Car(carName);
            System.out.print(carName + ":");
            car.race();
        }
        System.out.println("");
    }

    public void getWinner(){

    }

}