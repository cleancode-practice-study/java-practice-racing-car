package racingCar;

import org.junit.jupiter.api.Test;

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
        assertThat(names).containsExactly("하림", "진희", "도원");
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
    }


    @Test
    void 시도횟수_숫자인경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        int tryNumber = 4;

        //when
        boolean check = game.isNumber(tryNumber);

        //then
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 자동차_이름_길이가_5자_이하일경우(){
        //given
        RacingCarGame game = new RacingCarGame();
        String[] names = {"하림", "진희" , "도원"};

        //when
        boolean check = game.checkNameLength(names);

        //then
        assertThat(check).isEqualTo(true);

    }
}
