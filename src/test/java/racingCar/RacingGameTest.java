package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 이름을_올바로_입력했을_경우() {
        RacingGame game = new RacingGame();

        List<String> cars = game.splitCarNames("genie,win,race");
        boolean result = game.checkValidNames(cars);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 이름을_잘못_입력했을_경우() {
        RacingGame game = new RacingGame();

        List<String> cars = game.splitCarNames("Egenie,win,race");
        boolean result = game.checkValidNames(cars);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 자동차_객체_생성() {
        RacingGame game = new RacingGame();

        List<String> carNames = game.splitCarNames("genie,win,race");
        List<Car> cars = game.createCars(carNames);

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    public void 게임_횟수_숫자가_아닌_다른_문자_입력했을_경우() {
        RacingGame game = new RacingGame();

        boolean result = game.checkValidRacingCount("@#다");

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 게임_횟수_올바르게_입력했을_경우() {
        RacingGame game = new RacingGame();

        boolean result = game.checkValidRacingCount("12");

        assertThat(result).isEqualTo(true);
    }

}
