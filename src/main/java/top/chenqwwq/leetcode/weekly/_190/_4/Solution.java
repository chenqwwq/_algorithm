package top.chenqwwq.leetcode.weekly._190._4;

/**
 * 5419. 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 *
 * @author chen
 * @date 2020/5/24 上午11:10
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        final int lenDiff = nums1.length - nums2.length;
        int[] shorter, longer;
        if (lenDiff >= 0) {
            shorter = nums2;
            longer = nums1;
        } else {
            shorter = nums1;
            longer = nums2;
        }

        int max = 0;

        for (int i = 0; i < Math.abs(lenDiff); i++) {
            max = Math.max(max, getMax(shorter, longer, i));
        }

        return max;
    }


    private int getMax(int[] shorter, int[] longer, int start) {
        return 0;
    }
}
