package top.chenqwwq.leetcode.contest.weekly._415._1;

/**
 * @author chenqwwq
 * @date 2024/9/21
 **/
public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        final boolean[] hash = new boolean[101];
        final int[] ans = new int[2];
        int i = 0;
        for(int k : nums){
            if(hash[k]) ans[i++] = k;
            hash[k] = true;
        }
        return ans;
    }
}