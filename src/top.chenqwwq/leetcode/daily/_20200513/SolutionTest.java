package top.chenqwwq.leetcode.daily._20200513;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen
 * @date 2020-05-13
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void levelOrder() {
        Assertions.assertEquals(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(3));
            add(Arrays.asList(9, 20));
            add(Arrays.asList(15, 7));
        }}, solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7})));

        Assertions.assertEquals(new ArrayList<>(), solution.levelOrder(null));

        Assertions.assertEquals(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1));
            add(Arrays.asList(2, 3));
            add(Arrays.asList(4, 5));
        }}, solution.levelOrder(TreeUtils.getTreeByArray(new Integer[]{1, 2, 3, 4, 5})));
    }
}