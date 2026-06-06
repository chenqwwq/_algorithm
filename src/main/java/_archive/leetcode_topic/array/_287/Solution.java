package top.chenqwwq.leetcode.topic.array._287;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 *
 * @author chen
 * @date 2020/6/27 下午10:11
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        // 这里注意是不能更改原数组, 不能原地置换元素
        // 且空间复杂度为O(1)，不能使用额外数组

        // 看了题解，了解个大概就先来看看二分查找

        int left = 1, right = nums.length - 1;

        while (left < right) {
            // 取中
            int mid = (left + right) >>> 1;
            // 计算小于mid的值
            int count = 0;
            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}