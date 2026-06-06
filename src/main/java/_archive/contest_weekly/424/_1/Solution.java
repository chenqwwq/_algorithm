package top.chenqwwq.leetcode.contest.weekly._424._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/11/17
 **/
public class Solution {
    public int countValidSelections(int[] nums) {
        int cnt = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                final int[] ns = Arrays.copyOf(nums, nums.length);
                if(isValid(ns,i+1,1)) cnt++;
                final int[] ns2 = Arrays.copyOf(nums, nums.length);
                if(isValid(ns2,i-1,-1)) cnt++;
            }
        }
        return cnt;
    }

    public boolean isValid(int[] nums, int cur, int f) {
        if (cur >= nums.length || cur < 0) {
            return checkAll(nums);
        }

        if (nums[cur] == 0) {
            return isValid(nums, cur + f, f);
        }

        nums[cur]--;
        return isValid(nums, cur - f, -f);

    }

    public boolean checkAll(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}