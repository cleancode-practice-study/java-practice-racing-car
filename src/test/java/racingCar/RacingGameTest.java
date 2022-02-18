package racingCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {
    @Test
    void 쉼표_기준으로_이름이_쪼개지는_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        String name = "하림,진희,도원";

        //when
        String[] names = game.splitNames(name);

        //then
        assertThat(names.length).isEqualTo(3);
        assertThat(names[0]).isEqualTo("하림");
        assertThat(names[1]).isEqualTo("진희");
        assertThat(names[2]).isEqualTo("도원");
    }

    @Test
    void 자동차_객체가_생성되는_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        String[] names = {"하림", "진희" , "도원"};

        //when
        List<Car> car = game.createCars(names);

        //then
        assertThat(car.size()).isEqualTo(3);
        assertThat(car.get(0).getName()).isEqualTo("하림");
        assertThat(car.get(1).getName()).isEqualTo("진희");
        assertThat(car.get(2).getName()).isEqualTo("도원");
    }

    @Test
    void 시도횟수가_숫자인_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        int tryNumber = 4;

        //when
        boolean check = game.isNumber(tryNumber);

        //then
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 시도횟수가_숫자가_아닌_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        int tryNumber = -1;

        //when
        boolean check = game.isNumber(tryNumber);

        //then
        assertThat(check).isEqualTo(false);
    }

    @Test
    void 이름의_길이가_5자_이하일_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        String[] names = {"하림", "진희" , "도원"};

        //when
        boolean check = game.checkNameLength(names);

        //then
        assertThat(check).isEqualTo(true);

    }

    @Test
    void 이름의_길이가_5자_이상일_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        String[] names = {"Margaret", "halim" , "Elizabethe"};

        //when
        boolean check = game.checkNameLength(names);

        //then
        assertThat(check).isEqualTo(false);
    }

    @Test
    void 우승자를_쉼표를_포함해_출력하는_꼉경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        List<String> winners = new ArrayList<>();
        winners.add("하림");
        winners.add("진희");

        //when
        String winner = game.printWinner(winners);

        //then
        assertThat(winner).isEqualTo("하림, 진희");
    }

    @Test
    void 가장_큰_포지션의_인덱스를_구하는_경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("하림");
        Car car2 = new Car("진희");
        Car car3 = new Car("도원");
        car1.moveOrStop(1);
        car2.moveOrStop(8);
        car3.moveOrStop(2);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        //when
        int maxPosition = game.getMaxPositionIdx(cars, car1, car1.getPosition());

        //then
        assertThat(maxPosition).isEqualTo(1);
    }
}
