package racingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 경주할 자동차 이름 입력 받는 기능
// 자동차 이름 유효한 지 확인 하는 기능
// 자동차 객체 생성 하는 기능
// 경주할 횟수 입력 받는 기능
// 경주 횟수 만큼 랜덤하게 수 생성하는 기능
// 경주 횟수 마다 자동차 위치 정보 변경하는 기능 3 이하면 정지, 4 이상이면 전진
// 경주 횟수마다 결과 출력하는 기능
// 누가 우승을 했는지 알아내는 기능
// 우승자를 출력하는 기능

public class Application {
	public static int CAR_NAME_LIMIT = 5;

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		Application application = new Application();

		ArrayList<String> carNames = application.getCarNames(scanner);

		ArrayList<Car> cars = application.createCars(carNames);

	}

	private ArrayList<String> getCarNames(Scanner scanner) {
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
}
