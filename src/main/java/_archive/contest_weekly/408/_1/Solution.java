package top.chenqwwq.leetcode.contest.weekly._408._1;

/**
 * @author chenqwwq
 * @date 2024/7/28
 **/
public class Solution {
    public boolean canAliceWin(int[] nums) {
        int a = 0,b = 0;
        for(int num : nums){
            if(num < 10) a += num;
            else b += num;
        }
        return a != b;
    }
}