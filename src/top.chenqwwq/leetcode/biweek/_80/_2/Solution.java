package top.chenqwwq.leetcode.biweek._80._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/6/11
 **/
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int a = spells[i];
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if ((long) a * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = m - r - 1;
        }
        return ans;
    }
}
