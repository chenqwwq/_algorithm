package top.chenqwwq.leetcode.daily._2024._20241006;

/**
 * @author chenqwwq
 * @date 2024/10/6
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}