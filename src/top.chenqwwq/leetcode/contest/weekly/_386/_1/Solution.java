package top.chenqwwq.leetcode.contest.weekly._386._1;

/**
 * @author chenqwwq
 * @date 2024/2/25
 **/
public class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] hash = new int[101];
        for(int num : nums) hash[num]++;
        for(int cnt : hash) if(cnt > 2) return false;
        return true;
    }
}