package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    void 랜덤_값이_4보다_큰_경우(){
        //given
        Car car = new Car("halim");
        int number = 8;

        //when
        car.moveOrStop(number);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값이_4보다_작은_경우() {
        //given
        Car car = new Car("halim");
        int number = 3;

        //when
        car.moveOrStop(number);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 경주_결과를_출력하는_경우(){
        //given
        Car car = new Car("halim");
        int moveCount = 4;

        //when
        String move = car.printMove(moveCount);

        //then
        assertThat(move).isEqualTo("----");
    }
}
