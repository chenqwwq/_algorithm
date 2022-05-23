package top.chenqwwq.leetcode.weekly._293._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/15
 **/
public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int n = special.length;
        if (top - bottom + 1 == n) {
            return 0;
        }
        Arrays.sort(special);
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(special[i + 1] - special[i] - 1,ans);
        }
        return ans;
    }
}