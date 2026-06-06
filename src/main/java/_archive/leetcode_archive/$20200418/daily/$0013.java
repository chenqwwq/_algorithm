package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author chen
 * @date 2020/3/13 上午11:38
 */
public class $0013 {
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return -1;
            }
            int curr = 0, num = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[curr]) {
                    num++;
                } else {
                    if (num == 0) {
                        num++;
                        curr = i;
                    } else {
                        num--;
                    }
                }
            }

            return nums[curr];
        }
    }
}
