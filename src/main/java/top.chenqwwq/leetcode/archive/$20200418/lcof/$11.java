package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author chen
 * @date 2020/3/6 下午3:18
 */
public class $11 {
    class Solution {
        public int minArray(int[] numbers) {

            int start = 0, end = numbers.length - 1;

            while (start < end) {
                // 取中
                int mid = (start + end) >> 1;

                if (numbers[mid] > numbers[end]) {
                    start = mid + 1;
                } else if (numbers[mid] < numbers[end]) {
                    end = mid;
                } else {
                    end--;
                }
            }

            return numbers[end];

        }
    }
}
