package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    void moveTest(){
        //given
        Car car = new Car("halim");
        int number = 8;

        //when
        car.moveOrStop(number);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stopTest() {
        //given
        Car car = new Car("halim");
        int number = 3;

        //when
        car.moveOrStop(number);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
