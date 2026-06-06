package top.chenqwwq.leetcode.contest.weekly._482._2;

/**
 * @author chenqwwq
 * @date 2025/12/28
 **/
public class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (costBoth >= cost1 + cost2) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        }
        int min = Math.min(need1, need2);
        long ans = (long) min * costBoth;
        return ans + Math.min((long) cost1 * (need1 - min) + (long) cost2 * (need2 - min), (long) costBoth * (need1 + need2 - 2L * min));
    }

    public static void main(String[] args) {
        new Solution().minimumCost(388168, 988887, 336014, 50411, 252237);
    }
}