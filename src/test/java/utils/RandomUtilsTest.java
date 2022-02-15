package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {
    @Test
    public void 일반적인_경우() {
        // given
        int startInclusive = 1;
        int endInclusive = 9;

        // when
        int result = RandomUtils.nextInt(startInclusive, endInclusive);

        // then
        assertThat(result).isBetween(startInclusive, endInclusive);
    }

    @Test
    public void 시작값이_종료값보다_큰_경우() {
        // given
        int startInclusive = 9;
        int endInclusive = 1;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

    @Test
    public void 시작값과_종료값이_같은_경우() {
        // given
        int startInclusive = 2;
        int endInclusive = 2;

        // when
        int result = RandomUtils.nextInt(startInclusive, endInclusive);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 시작값이_음수인_경우() {
        // given
        int startInclusive = -1;
        int endInclusive = 9;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(startInclusive, endInclusive));
    }

}


