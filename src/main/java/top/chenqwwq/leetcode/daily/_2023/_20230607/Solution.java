package top.chenqwwq.leetcode.daily._2023._20230607;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 沽酒
 * @since 2023/06/07
 */
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        final int n = reward1.length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0],o1[0]));
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{reward1[i] - reward2[i], reward2[i]});
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            final int[] reward = queue.poll();
            if(k-- > 0) ans += reward[0] + reward[1];
            else ans += reward[1];
        }
        return ans;
    }
}