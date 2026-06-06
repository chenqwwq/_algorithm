package top.chenqwwq.leetcode.contest.weekly._356._1;

/**
 * @author chenqwwq
 * @date 2023/7/30
 **/
public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for(int hour : hours){
            if(hour >= target) cnt++;
        }
        return cnt;
    }
}