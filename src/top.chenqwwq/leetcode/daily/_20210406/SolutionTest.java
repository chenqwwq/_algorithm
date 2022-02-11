package top.chenqwwq.leetcode.daily._20210406;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-04-09
 **/
class SolutionTest {

    /**
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3]
     * Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.
     * Example 2:
     * <p>
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3]
     * Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
     */

    Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        int[] i1 = new int[]{1, 1, 1, 2, 2, 3};
        Assertions.assertEquals(5, solution.removeDuplicates(i1));
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3}, i1);

        int[] i2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assertions.assertEquals(7, solution.removeDuplicates(i2));
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 3, 3, 3, 3}, i2);

        int[] i3 = new int[]{0, 0, 0, 0, 0, 0, 0};
        Assertions.assertEquals(2, solution.removeDuplicates(i3));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, i3);
    }
}