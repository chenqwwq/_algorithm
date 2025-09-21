package top.chenqwwq.leetcode.daily._2025._20250209;

/**
 * @author chenqwwq
 * @date 2025/2/9
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        final int n = nums.length;
        if (n <= 2) return 0;
        int i = 2, j = 2;
        while (j < n) {
            if (nums[i - 2] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}