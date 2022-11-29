package top.chenqwwq.leetcode.daily._20221127;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public boolean check(int[] nums) {
        final int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i+1] < nums[i]){
                if(!flag) flag = true;
                else return false;
            }
        }
        return flag ? nums[0] > nums[n-1] : nums[0] < nums[n-1];
    }
}