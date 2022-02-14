package racingCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 움직일_경우() {
        Car myCar = new Car("jinhee");
        int initPosition = 0;

        myCar.move(5);
        assertThat(myCar.getPosition()).isEqualTo(initPosition + 1);
    }

    @Test
    public void 안움직일_경우() {
        Car myCar = new Car("ponyo");
        int initPosition = 0;

        myCar.move(2);
        assertThat(myCar.getPosition()).isEqualTo(initPosition);
    }

    @Test
    public void 혼자_우승일_경우() {
        Car carOne = new Car("one");
        Car carTwo = new Car("two");
        Car carThree = new Car("three");

        carOne.move(5);
        carTwo.move(0);
        carThree.move(2);

        List<Car> cars = new ArrayList<>();

        cars.add(carOne);
        cars.add(carTwo);
        cars.add(carThree);

        List<String> winner = carOne.getWinners(cars);

        assertThat(winner.get(0)).isEqualTo("one");
    }

    @Test
    public void 공동_우승일_경우() {
        Car carOne = new Car("one");
        Car carTwo = new Car("two");
        Car carThree = new Car("three");

        carOne.move(5);
        carTwo.move(5);
        carThree.move(2);

        List<Car> cars = new ArrayList<>();

        cars.add(carOne);
        cars.add(carTwo);
        cars.add(carThree);

        List<String> winner = carOne.getWinners(cars);

        assertThat(winner.toString()).isEqualTo("[one, two]");
    }
}
