package top.chenqwwq.leetcode.weekly._221._2;

/**
 * @author chen
 * @date 2020/12/27
 **/
public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        if (apples.length == 0) {
            return 0;
        }
        int ans = 0, curr = 0, day = 0;
        while (day < apples.length || (curr < apples.length && apples[curr] != 0)) {
            while (curr < day && curr < apples.length && (day - curr >= days[curr] || apples[curr] == 0)) {
                curr++;
            }
            if (curr < apples.length && apples[curr] > 0) {
                apples[curr]--;
                ans++;
            }
            day++;
        }
        return ans;
    }
}
