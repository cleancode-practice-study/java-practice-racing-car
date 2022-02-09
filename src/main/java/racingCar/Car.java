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

}
