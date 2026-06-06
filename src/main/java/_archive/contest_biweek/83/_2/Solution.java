package top.chenqwwq.leetcode.contest.biweek._83._2;

/**
 * @author chenqwwq
 * @date 2022/7/23
 **/
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int cur = 0;
        for (int num : nums) {
            if(num != 0){
                cur = 0;
            }else{
                ans += (++cur);
            }
        }
        return ans;
    }
}