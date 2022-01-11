package top.chenqwwq.leetcode.weekly._197._1;

/**
 * 好数对的数目
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author chen
 * @date 2020/7/12 上午10:27
 */
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] hash = new int[101];
        for (int i : nums) {
            hash[i]++;
        }

        int res = 0;
        for (int i : nums) {
            if (hash[i] >= 2) {
                res += --hash[i];
            }
        }

        return res;
    }
}