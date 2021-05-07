package racingCar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameHelper gp = new GameHelper();

        gp.gameStart();
    }
}
