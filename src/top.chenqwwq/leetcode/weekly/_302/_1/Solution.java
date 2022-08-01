package top.chenqwwq.leetcode.weekly._302._1;

/**
 * @author chenqwwq
 * @date 2022/7/17
 **/
public class Solution {
    public int[] numberOfPairs(int[] nums) {
        int cnt = 0;
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
            cnt++;
        }
        int ans = 0;
        for (int h : hash) {
            ans += (h / 2);
        }
        return new int[]{ans,cnt - ans * 2};
    }
}