package racingCar;

import utils.RandomUtils;

public class Car {
	private final String name;
	private static final int START_VALUE = 0;
	private static final int END_VALUE = 9;
	private static final int MOVING_STANDARD = 4;

	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int getNumber(){
		return RandomUtils.nextInt(START_VALUE, END_VALUE);
	}

	public void race(){
		int number = getNumber();

		if(number >= MOVING_STANDARD)
			this.position++;

		for(int i = 0; i < position; i++) {
			System.out.print("-");
		}

		System.out.println("");
	}
}