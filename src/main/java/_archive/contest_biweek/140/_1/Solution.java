package top.chenqwwq.leetcode.contest.biweek._140._1;

/**
 * @author chenqwwq
 * @date 2024/10/2
 **/
public class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int num : nums){
            ans = Math.min(ans,get(num));
        }
        return ans;
    }

    private int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += (num % 10);
            num /= 10;
        }
        return ans;
    }
}