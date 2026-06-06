package top.chenqwwq.leetcode.contest.weekly._188._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020/5/10 上午10:53
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void buildArray() {
        Assertions.assertIterableEquals(Arrays.asList("Push", "Push", "Pop", "Push"), solution.buildArray(new int[]{1, 3}, 3));
        Assertions.assertIterableEquals(Arrays.asList("Push", "Push", "Push"), solution.buildArray(new int[]{1, 2, 3}, 3));
        Assertions.assertIterableEquals(Arrays.asList("Push", "Push"), solution.buildArray(new int[]{1, 2}, 4));
        Assertions.assertIterableEquals(Arrays.asList("Push", "Pop", "Push", "Push", "Push"), solution.buildArray(new int[]{2, 3, 4}, 4));
    }
}