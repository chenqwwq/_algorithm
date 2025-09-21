package top.chenqwwq.leetcode.daily._2022._20220925;

/**
 * @author chenqwwq
 * @date 2022/9/28
 **/
public class Solution {
    boolean[] ok = new boolean[10];

    {
        ok[0] = true;
        ok[1] = true;
        ok[8] = true;
        ok[5] = true;
        ok[2] = true;
        ok[6] = true;
        ok[9] = true;
    }

    public int rotatedDigits(int n) {
        int cnt = 0;
        outer:
        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean good = false;
            while (num != 0) {
                int t = num % 10;
                if (!ok[t]) continue outer;
                good = good || (t == 2 || t == 5 || t == 6 || t == 9);
                num /= 10;
            }
            if (good) cnt++;
        }
        return cnt;
    }
}