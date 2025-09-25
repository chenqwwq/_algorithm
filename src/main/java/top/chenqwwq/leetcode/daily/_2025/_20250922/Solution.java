package top.chenqwwq.leetcode.daily._2025._20250922;

/**
 * @author chenqwwq
 * @date 2025/9/22
 **/
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];
        for(int num : nums){
            hash[num]++;
        }

        int[] h2 = new int[101];
        for(int n : hash){
            h2[n] += n;
        }

        for(int i = 100;i >= 0;i--){
            if(h2[i] > 0) return h2[i];
        }

        return -1;
    }
}