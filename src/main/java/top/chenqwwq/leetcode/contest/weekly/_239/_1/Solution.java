package top.chenqwwq.leetcode.contest.weekly._239._1;

/**
 * @author chen
 * @date 2021/5/2
 **/
public class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i = 0;
        while (start + i < nums.length || start - i >= 0) {
            if ((start + i < nums.length && nums[start + i] == target) || (start - i >= 0 && nums[start - i] == target)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
