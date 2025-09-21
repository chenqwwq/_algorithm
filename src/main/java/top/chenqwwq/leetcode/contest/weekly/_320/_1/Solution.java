package top.chenqwwq.leetcode.contest.weekly._320._1;

/**
 * @author chenqwwq
 * @date 2022/11/20
 **/
public class Solution {
    public int unequalTriplets(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) ans++;
                }
            }
        }
        return ans;
    }
}