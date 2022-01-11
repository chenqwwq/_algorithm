package top.chenqwwq.leetcode.weekly._189._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;
import top.chenqwwq.leetcode.utils.ListUtils;

/**
 * @author chen
 * @date 2020/5/17 上午11:48
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void peopleIndexes() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{0, 1, 4}, solution.peopleIndexes(ListUtils.getList(new String[][]{{"leetcode", "google", "facebook"}, {"google", "microsoft"}, {"google", "facebook"}, {"google"}, {"amazon"}})).stream().mapToInt(Integer::valueOf).toArray()));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{0, 1}, solution.peopleIndexes(ListUtils.getList(new String[][]{{"leetcode", "google", "facebook"}, {"leetcode", "amazon"}, {"facebook", "google"}})).stream().mapToInt(Integer::valueOf).toArray()));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{0, 1, 2, 3}, solution.peopleIndexes(ListUtils.getList(new String[][]{{"leetcode"}, {"google"}, {"facebook"}, {"amazon"}})).stream().mapToInt(Integer::valueOf).toArray()));
    }
}