package top.chenqwwq.leetcode.daily._2023._20230629;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/6/29
 **/
public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        final int n = colsum.length;
        int[][] ans = new int[2][n];
        int total = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                ans[0][i] = ans[1][i] = 1;
                cnt++;
            }
            total += colsum[i];
        }
        if (total != lower + upper || upper < cnt || lower < cnt) return new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colsum[i] != 1) continue;
            if (upper-- > cnt) ans[0][i] = 1;
            else if (lower-- > cnt) ans[1][i] = 1;
            else break;
        }

        return Arrays.stream(ans)
                .map(a -> Arrays.stream(a).boxed()
                        .toList()).toList();
    }
}