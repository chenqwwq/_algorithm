package top.chenqwwq.leetcode.daily._20200612;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author chen
 * @date 2020-06-12
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void threeSum() {
        List<List<Integer>> l1 = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(-1, 0, 1));
            add(Arrays.asList(-1, -1, 2));
        }};
        assertTrue(ListUtils.compare2D(l1, solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        assertTrue(ListUtils.compare2D(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(0, 0, 0));
        }}, solution.threeSum(new int[]{0, 0, 0, 0})));
    }
}