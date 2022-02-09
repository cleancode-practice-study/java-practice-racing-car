package racingCar;

public class Car {
	public static int CAN_DRIVE = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move(int randomNum) {
		if (randomNum >= CAN_DRIVE) {
			this.position++;
		}
	}

	// 현재 포지션 만큼 결과 출력
	public String getResult() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name + " : ");
		if (position > 0) {
			stringBuilder.append(printProgress(position));
		}

		return stringBuilder.toString();
	}

	public String printProgress(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0 ; i < position ; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}

}
