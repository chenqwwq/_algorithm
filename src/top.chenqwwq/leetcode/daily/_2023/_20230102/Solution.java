package top.chenqwwq.leetcode.daily._2023._20230102;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2023/1/2
 **/
public class Solution {

    int mod = (int) 1e9 + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> buys = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));

        for (int[] order : orders) {
            if (order[2] == 0) {
                // 采购订单
                while (order[1] > 0 && !sells.isEmpty() && sells.peek()[0] <= order[0]) {
                    final int[] poll = sells.poll();
                    if (order[1] >= poll[1]) order[1] -= poll[1];
                    else {
                        poll[1] -= order[1];
                        sells.add(poll);
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) buys.add(order);
            } else {
                // 销售订单
                while (order[1] > 0 && !buys.isEmpty() && buys.peek()[0] >= order[0]) {
                    final int[] poll = buys.poll();
                    if (order[1] >= poll[1]) order[1] -= poll[1];
                    else {
                        poll[1] -= order[1];
                        buys.add(poll);
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) sells.add(order);
            }
        }

        int ans = 0;
        for (int[] order : sells) ans = (ans + order[1]) % mod;
        for (int[] order : buys) ans = (ans + order[1]) % mod;
        return ans;
    }
}