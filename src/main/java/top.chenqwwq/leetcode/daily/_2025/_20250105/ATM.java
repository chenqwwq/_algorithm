package top.chenqwwq.leetcode.daily._2025._20250105;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2025/1/5
 **/
public class ATM {

    private PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

    int[] count = new int[]{20, 50, 100, 200, 500};
    final int[] cs = new int[5];

    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cs[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] cnt = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (cs[i] <= 0) continue;
            // 最多换几张
            final int c = Math.min(amount / count[i], cs[i]);
            amount -= c * count[i];
            cnt[i] += c;
        }
        if (amount == 0) {
            for (int i = 0; i < 5; i++) {
                cs[i] -= cnt[i];
            }
            return cnt;
        }
        return new int[]{-1};
    }
}