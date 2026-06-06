package top.chenqwwq.leetcode.contest.weekly._380._1;

/**
 * @author chenqwwq
 * @date 2024/1/14
 **/
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        final int[] max = new int[101], hash = new int[101];
        for (int num : nums) hash[num]++;
        for(int cnt : hash) max[cnt]++;
        for(int i = 100;i >= 0;i--) if(max[i] > 0) return i * max[i];
        return 0;
    }
}