package top.chenqwwq.leetcode.contest.weekly._367._3;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

/**
 * @author chenqwwq
 * @date 2023/10/15
 **/
public class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // 考虑极限情况就好,分别保存最大和最小
        final int n = nums.length;
        int min = 0,max = 0;
        for(int i = indexDifference;i < n;i++){
            int j = i - indexDifference;
            if(nums[j] < nums[min]) min = j;
            if(nums[j] > nums[max]) max = j;

            if(nums[max] - nums[i] >= valueDifference) return new int[]{max,i};
            if(nums[i] - nums[min] >= valueDifference) return new int[]{i,min};
        }
        return new int[]{-1,-1};
    }
}