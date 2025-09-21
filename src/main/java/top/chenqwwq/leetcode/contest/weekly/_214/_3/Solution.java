package top.chenqwwq.leetcode.contest.weekly._214._3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 5563. 销售价值减少的颜色球
 * 你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
 * <p>
 * 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，那么顾客买第一个黄球的时候该黄球的价值为 6 。这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的）
 * <p>
 * 给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示顾客总共想买的球数目。你可以按照 任意顺序 卖球。
 * <p>
 * 请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 109 + 7 取余数 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：inventory = [2,5], orders = 4
 * 输出：14
 * 解释：卖 1 个第一种颜色的球（价值为 2 )，卖 3 个第二种颜色的球（价值为 5 + 4 + 3）。
 * 最大总和为 2 + 5 + 4 + 3 = 14 。
 * 示例 2：
 * <p>
 * 输入：inventory = [3,5], orders = 6
 * 输出：19
 * 解释：卖 2 个第一种颜色的球（价值为 3 + 2），卖 4 个第二种颜色的球（价值为 5 + 4 + 3 + 2）。
 * 最大总和为 3 + 2 + 5 + 4 + 3 + 2 = 19 。
 * 示例 3：
 * <p>
 * 输入：inventory = [2,8,4,10,6], orders = 20
 * 输出：110
 * 示例 4：
 * <p>
 * 输入：inventory = [1000000000], orders = 1000000000
 * 输出：21
 * 解释：卖 1000000000 次第一种颜色的球，总价值为 500000000500000000 。 500000000500000000 对 109 + 7 取余为 21 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= inventory.length <= 105
 * 1 <= inventory[i] <= 109
 * 1 <= orders <= min(sum(inventory[i]), 109)
 *
 * @author chen
 * @date 2020/11/8
 **/
public class Solution {
    public int maxProfit(int[] inventory, int orders) {
        // 每次获取当前总数最大的球
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : inventory) {
            queue.offer(i);
        }

        int ans = 0;
        while (orders > 0) {
            Integer p1 = queue.poll();
            if (p1 == null) {
                break;
            }
            Integer p2 = queue.poll();
            if (p2 == null) {
                ans += ((2 * p1 - orders + 1) * (orders >> 1));
                break;
            } else if (p1.equals(p2)) {
                ans += p1;
                queue.offer(--p1);
                orders--;
            } else {

            }
        }
        return ans;
    }
}