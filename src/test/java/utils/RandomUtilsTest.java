package utils;

import org.junit.jupiter.api.Test;

public class RandomUtilsTest {
    @Test
    void 범위가_0부터_9까지인_경우(){
        //given
        int startInclusive = 0;
        int endInclusive = 9;

        //when
        RandomUtils.nextInt(startInclusive, endInclusive);
    }
}
