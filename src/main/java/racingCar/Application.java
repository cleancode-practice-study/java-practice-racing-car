package racingCar;

import utils.RandomUtils;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String carsName = scanner.nextLine();
		String[] carsNameList = carsName.split(",");
		Car[] cars = new Car[carsNameList.length];

		for(int i = 0 ; i < carsNameList.length ; i++) {
			String name = carsNameList[i];
			cars[i] = new Car(name);
		}

		for(int i = 0; i < carsNameList.length ; i++) {
			System.out.println(cars[i].getName());
		}

		System.out.println("시도할 회수는 몇회인가요?");
		System.out.println("hello");

		int playNum = scanner.nextInt();
		int count = 0;

		//RandomUtils randomUtils = new RandomUtils();

		while(count > playNum) {
			for(int i = 0; i < carsNameList.length; i++) {

			}
		}




	}
}
