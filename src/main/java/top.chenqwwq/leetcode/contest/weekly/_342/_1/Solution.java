package top.chenqwwq.leetcode.contest.weekly._342._1;

/**
 * @author chenqwwq
 * @date 2023/4/23
 **/
public class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}