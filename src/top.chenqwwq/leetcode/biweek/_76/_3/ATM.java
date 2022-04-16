package top.chenqwwq.leetcode.biweek._76._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/4/16
 **/
public class ATM {
    long[] m = new long[5];

    public ATM() {
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            m[i] += banknotesCount[i];
        }
    }

    int[] size = new int[]{20, 50, 100, 200, 500};

    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for (int i = 4; i >= 0; i--) {
            ans[i] = (int) Math.min(amount / size[i], m[i]);
            m[i] -= ans[i];
            amount -= ans[i] * size[i];
        }
        if (amount != 0) {
            for (int i = 0; i < 5; i++) {
                m[i] += ans[i];
            }
            return new int[]{-1};
        }
        return ans;
    }
}
