package racingCar;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		RacingGame racingGame = new RacingGame();

		racingGame.start();
	}
}
