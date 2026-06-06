package top.chenqwwq.leetcode.topic.array._26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-04-09
 **/
class SolutionTest {


    Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        /**
         *
         * Input: nums = [1,1,2]
         * Output: 2, nums = [1,2]
         * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
         * Example 2:
         * <p>
         * Input: nums = [0,0,1,1,1,2,2,3,3,4]
         * Output: 5, nums = [0,1,2,3,4]
         * Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
         */
        int[] i1 = new int[]{1, 1, 2};
        Assertions.assertEquals(2, solution.removeDuplicates(i1));
        Assertions.assertArrayEquals(new int[]{1, 2, 2}, i1);

        int[] i2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assertions.assertEquals(5, solution.removeDuplicates(i2));
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4}, i2);

        int[] i3 = new int[]{0, 0};
        Assertions.assertEquals(1, solution.removeDuplicates(i3));
        Assertions.assertArrayEquals(new int[]{0, 0}, i3);
    }
}