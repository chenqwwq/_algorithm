package top.chenqwwq.leetcode.topic.union_find._959;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/7/13 下午11:09
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void regionsBySlashes() {
        Assertions.assertEquals(4, solution.regionsBySlashes(new String[]{" /\\", " \\/", "\\  "}));
        Assertions.assertEquals(2, solution.regionsBySlashes(new String[]{" /",
                "/ "}));
        Assertions.assertEquals(4, solution.regionsBySlashes(new String[]{"\\/",
                "/\\"}));
        Assertions.assertEquals(1, solution.regionsBySlashes(new String[]{" /",
                "  "}));
        Assertions.assertEquals(5, solution.regionsBySlashes(new String[]{"/\\",
                "\\/"}));
        Assertions.assertEquals(3, solution.regionsBySlashes(new String[]{"//",
                "/ "}));
    }
}