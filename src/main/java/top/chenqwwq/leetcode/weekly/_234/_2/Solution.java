package top.chenqwwq.leetcode.weekly._234._2;

/**
 * @author chen
 * @date 2021/3/28
 **/
public class Solution {
    public int reinitializePermutation(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] init = new int[n];
        for (int i = 0; i < n; i++) {
            init[i] = i;
        }


        int cnt = 0;
        do {
            cnt++;
            int[] curr = new int[n];
            System.arraycopy(init, 0, curr, 0, n);
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    init[i] = curr[i / 2];
                } else {
                    init[i] = curr[n / 2 + (i - 1) / 2];
                }
            }
        } while (init[1] != 1);
        return cnt;
    }
}
