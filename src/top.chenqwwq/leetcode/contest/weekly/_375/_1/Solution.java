package top.chenqwwq.leetcode.contest.weekly._375._1;

/**
 * @author chenqwwq
 * @date 2023/12/10
 **/
public class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0, diff = 0;
        for (int i : batteryPercentages) {
            if (i - diff > 0) {
                ans++;
                diff++;
            }
        }
        return ans;
    }
}