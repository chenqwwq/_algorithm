package top.chenqwwq.leetcode.daily._20200526;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * @author chen
 * @date 2020-05-26
 **/
public class Solution {
    public int findDuplicate(int[] nums) {
        // 说明中的几点内容:
        // 1. 不能更改原数组，不能使用元素交换
        // 2. O(1)的空间复杂度，常数级复杂度 不能开辟n大小的数组

        // 评论提示将数组看成链表
        if (nums == null || nums.length == 0) {
            return -1;
        }


        return 1;
    }
}