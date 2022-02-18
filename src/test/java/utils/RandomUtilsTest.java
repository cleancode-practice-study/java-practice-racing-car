package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomUtilsTest {

    @Test
    void 랜덤_값이_0부터_9사이인_경우(){
        //given
        int startInclusive = 0;
        int endInclusive = 9;

        //when
        int result = RandomUtils.nextInt(startInclusive, endInclusive);

        // then
        assertThat(result).isBetween(startInclusive, endInclusive);
    }

    @Test
    void 시작값이_종료값보다_큰_경우() throws IllegalArgumentException{
        //given
        int startInclusive = 5;
        int endInclusive = 2;

        //when
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

    @Test
    void 시작값이_음수인_경우() {
        //given
        int startInclusive = -2;
        int endInclusive = 9;

        //when
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

    @Test
    void 시작값과_종료값이_동일한_경우(){
        //given
        int startInclusive = 5;
        int endInclusive = 5;

        //when
        int result = RandomUtils.nextInt(startInclusive, endInclusive);

        // then
        assertThat(result).isEqualTo(startInclusive);
    }
}
