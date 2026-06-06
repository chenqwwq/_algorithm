package top.chenqwwq.leetcode.contest.weekly._492._1;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/
public class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] < itemSize) continue;
            if (capacity[i] - itemSize < dif) {
                ans = i;
                dif = capacity[i] - itemSize;
            }
        }
        return ans;
    }
}