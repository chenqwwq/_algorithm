package top.chenqwwq.leetcode.lccup._2022.group._1;

/**
 * @author chenqwwq
 * @date 2022/4/25
 **/
public class Solution {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0], num = fruit[1];
            ans += time[type] * (num / limit + (num % limit == 0 ? 0 : 1));
        }
        return ans;
    }
}