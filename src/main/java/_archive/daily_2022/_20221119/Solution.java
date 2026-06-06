package top.chenqwwq.leetcode.daily._2022._20221119;

/**
 * @author chenqwwq
 * @date 2022/11/19
 **/
public class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0, ans = 0;
        for (int g : gain) ans = Math.max(cur += g, ans);
        return ans;
    }
}