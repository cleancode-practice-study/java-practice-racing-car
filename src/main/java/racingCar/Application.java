package racingCar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 경주할 자동차 이름 입력 받는 기능
// 자동차 이름 유효한 지 확인 하는 기능ㅇ
// 자동차 객체 생성 하는 기능 ㅇ
// 경주 횟수 마다 자동차 위치 정보 업데이트하는 기능 ㅇ
// 경주 횟수마다 결과 출력하는 기능 ㅇ
// 우승자 출력 기능 ㅇ

// 자동차 이름 유효 검증 로직 수정
// 경주 횟수 검증 로직 추가
// 출력 로직 수정
// 인터페이스 참조하도록 수정

// indent 1로 줄이기 위해 stream 사용
// getPosition 사용 바꿔보기
// main에서 호출하지 않는 메서드는 static으로 선언하지 않도록 구현해보자.
// 공백 라인 잘 나누기
// 필요 없는 변수 초기화 줄이기

public class Application {
	public static int CAR_NAME_LIMIT = 5;
	public static int START_RANDOM_NUMBER = 0;
	public static int END_RANDOM_NUMBER = 9;

	static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// 자동차 이름을 입력 받는다.
		List<String> carNames = getCarNames();

		// 입력받은 이름으로 자동차 객체를 생성한다.
		List<Car> cars = createCars(carNames);

		// 입력 받은 경주 횟수 만큼 자동차 위치 정보를 업데이트 하고, 결과를 출력한다.
		driveCars(cars);

		// 우승자 리스트를 받는다.
		List<String> winners = getWinners(cars);

		// 우승자를 출력한다.
		printWinners(winners);
	}


	private static List<String> getCarNames() {
		boolean isInvalid;
		List<String> carNames;

		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String names = scanner.nextLine();
			carNames = splitCarNames(names);
			isInvalid = checkValidNames(carNames);
		} while (isInvalid);

		return carNames;
	}

	private static List<String> splitCarNames(String cars) {
		String[] names = cars.split(",");
		return new ArrayList<>(Arrays.asList(names));
	}

	private static boolean checkValidNames(List<String> names){
		boolean isInvalid =
				names.stream().anyMatch(name -> name.length() > CAR_NAME_LIMIT);

		if (isInvalid = false) {
			System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
		}

		return isInvalid;
	}

	private static List<Car> createCars(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for(String name : names) {
			Car car = new Car(name);
			cars.add(car);
		}
		return cars;
	}

	private static void driveCars(List<Car> cars) {
		int racingCount = getRacingCount();
		int count = 0;

		System.out.println();
		System.out.println("실행 결과");

		while(count < racingCount) {
			driveCarsOnce(cars);
			printResult(cars);
			count++;
		}
	}

	private static int getRacingCount() {
		String input;
		int racingCount;
		boolean isValid;

		do {
			System.out.println("시도할 회수는 몇회인가요?");
			input = scanner.nextLine();
			isValid = checkValidRacingCount(input);
		} while (!isValid);

		racingCount = Integer.parseInt(input);

		return racingCount;
	}

	private static boolean checkValidRacingCount(String input) {
		boolean isValid = true;

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			isValid = false;
		}

		return isValid;
	}


	private static void driveCarsOnce(List<Car> cars) {
		for (Car car : cars) {
			int number = RandomUtils.nextInt(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
			car.move(number);
		}
	}

	private static void printResult(List<Car> cars) {
		for (Car car : cars) {
			String result = car.getResult();
			System.out.println(result);
		}
		System.out.println();
	}

	private static List<String> getWinners(List<Car> cars) {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			winners = car.getWinners(cars);
		}
		return winners;
	}

	private static void printWinners(List<String> winners) {
		System.out.print("최종 우승자: ");
		System.out.print(String.join(", ", winners));
		System.out.println();
	}

}
