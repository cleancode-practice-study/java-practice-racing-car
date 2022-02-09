package racingCar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 경주할 자동차 이름 입력 받는 기능
// 자동차 이름 유효한 지 확인 하는 기능ㅇ
// 자동차 객체 생성 하는 기능 ㅇ
// 경주 횟수 마다 자동차 위치 정보 업데이트하는 기능 ㅇ
// 경주 횟수마다 결과 출력하는 기능
// 누가 우승을 했는지 알아내는 기능
// 우승자를 출력하는 기능

public class Application {
	public static int CAR_NAME_LIMIT = 5;
	public static int START_RANDOM_NUMBER = 0;
	public static int END_RANDOM_NUMBER = 9;

	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Application application = new Application();

		// 자동차 이름을 입력 받는다.
		ArrayList<String> carNames = application.getCarNames();

		// 입력받은 이름으로 자동차 객체를 생성한다.
		ArrayList<Car> cars = application.createCars(carNames);

		// 입력 받은 경주 횟수 만큼 자동차 위치 정보를 업데이트 한다.
		application.driveCars(cars);

	}

	private ArrayList<String> getCarNames() {
		boolean isInvalid;

		ArrayList<String> carNames;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String names = scanner.nextLine();
			carNames = splitCarNames(names);
			isInvalid = checkValidName(carNames);
		} while (isInvalid);

		return carNames;
	}

	private ArrayList<String> splitCarNames(String cars) {
		String[] names = cars.split(",");
		return new ArrayList<>(Arrays.asList(names));
	}

	private boolean checkValidName(ArrayList<String> names) {
		for (String name : names) {
			checkNameLength(name.length());
		}
		return true;
	}

	private boolean checkNameLength(int length) {
		if (length > CAR_NAME_LIMIT) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			return false;
		}
		return true;
	}

	private ArrayList<Car> createCars(ArrayList<String> names) {
		ArrayList<Car> cars = new ArrayList<>();
		for(String name : names) {
			Car car = new Car(name);
			cars.add(car);
		}
		return cars;
	}

	private void driveCars(ArrayList<Car> cars) {
		int racingCount = getRacingCount();
		int count = 0;
		while(count < racingCount) {
			driveCarsOnce(cars);
			count++;
		}
	}

	private int getRacingCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Integer.parseInt(scanner.nextLine());
	}

	private void driveCarsOnce(ArrayList<Car> cars) {
		for (Car car : cars) {
			int number = RandomUtils.nextInt(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
			car.move(number);
		}
	}


}
