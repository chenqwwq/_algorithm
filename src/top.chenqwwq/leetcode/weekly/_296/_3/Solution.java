package top.chenqwwq.leetcode.weekly._296._3;

/**
 * @author chenqwwq
 * @date 2022/6/5
 **/
public class Solution {
    int maxn = (int) 1e6 + 1;
    int[] hash = new int[maxn];


    public int[] arrayChange(int[] nums, int[][] operations) {
        for (int i = operations.length - 1; i >= 0; i--) {
            int[] op = operations[i];
            hash[op[0]] = hash[op[1]] == 0 ? op[1] : hash[op[1]];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = hash[nums[i]] == 0 ? nums[i] : hash[nums[i]];
        }
        return nums;
    }
}