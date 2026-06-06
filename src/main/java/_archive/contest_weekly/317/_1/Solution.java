package top.chenqwwq.leetcode.contest.weekly._317._1;

/**
 * @author chenqwwq
 * @date 2022/10/30
 **/
public class Solution {
    public int averageValue(int[] nums) {
        int cnt = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                cnt++;
                sum += num;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}