package top.chenqwwq.leetcode.weekly._233._2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/3/21
 **/
public class Solution {
    private static final int MOD = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        if (orders == null || orders.length == 0) {
            return 0;
        }

        PriorityQueue<Integer[]> sell = new PriorityQueue<>(Comparator.comparing(o -> o[0]));
        PriorityQueue<Integer[]> buy = new PriorityQueue<>((o1, o2) -> o2[0].compareTo(o1[0]));
        outer:
        for (int[] o : orders) {
            Integer[] order = Arrays.stream(o).boxed().toArray(Integer[]::new);
            final int price = order[0];
            int amount = order[1];
            final int type = order[2];
            if (type == 0) {
                // 采购订单
                while (!sell.isEmpty() && sell.peek()[0] <= price) {
                    Integer[] old = sell.poll();

                    // 对比数量
                    // 购入的数量大则先减去
                    if (amount >= old[1]) {
                        amount -= old[1];
                        continue;
                    }

                    // 购入的数量小
                    old[1] -= amount;
                    sell.offer(old);
                    continue outer;
                }
                if (amount != 0) {
                    order[1] = amount;
                    buy.offer(order);
                }
            } else {
                // 销售订单
                while (!buy.isEmpty() && buy.peek()[0] >= price) {
                    Integer[] old = buy.poll();

                    // 对比数量
                    // 购入的数量大则先减去
                    if (amount >= old[1]) {
                        amount -= old[1];
                        continue;
                    }

                    // 购入的数量小
                    old[1] -= amount;
                    buy.offer(old);
                    continue outer;
                }
                if (amount != 0) {
                    order[1] = amount;
                    sell.offer(order);
                }
            }
        }

        Long cnt = 0L;
        while (!sell.isEmpty()) {
            cnt += sell.poll()[1];
        }

        while (!buy.isEmpty()) {
            cnt += buy.poll()[1];
        }


        return (int) (cnt % MOD);
    }
}