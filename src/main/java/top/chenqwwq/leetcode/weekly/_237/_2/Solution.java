package top.chenqwwq.leetcode.weekly._237._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/4/18
 **/
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if ((coins -= cost) < 0) {
                break;
            }
            ans++;
        }
        return ans;
    }
}
