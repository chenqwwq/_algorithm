package top.chenqwwq.leetcode.contest.weekly._375._2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/12/10
 **/
public class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        final int n = variables.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            final int val = BigDecimal.valueOf(a).pow(b).divideAndRemainder(BigDecimal.valueOf(10))[1].pow(c).divideAndRemainder(BigDecimal.valueOf(m))[1].intValue();
            if (val == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().getGoodIndices(new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}},2);
    }
}