package top.chenqwwq.leetcode.daily._20200714;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * @author chen
 * @date 2020-07-14
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minimumTotal() {
        List<List<Integer>> param = new ArrayList<>();
        param.add(Arrays.asList(2));
        param.add(Arrays.asList(3, 4));
        param.add(Arrays.asList(6, 5, 7));
        param.add(Arrays.asList(4, 1, 8, 3));

        Assertions.assertEquals(11, solution.minimumTotal(param));
    }
}