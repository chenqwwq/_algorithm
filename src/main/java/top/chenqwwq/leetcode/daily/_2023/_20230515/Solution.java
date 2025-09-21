package top.chenqwwq.leetcode.daily._2023._20230515;


import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.function.BiFunction;

/**
 * @author 沽酒
 * @since 2023/05/15
 */
public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> attr2Cnt = new HashMap<>();
        for (int[] ma : matrix) {
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            for (int n : ma) {
                sb1.append(n);
                sb2.append(1 ^ n);
            }
            attr2Cnt.merge(sb1.toString(), 1, Integer::sum);
            attr2Cnt.merge(sb2.toString(), 1, Integer::sum);
        }

        int ans = 0;
        for(Integer val : attr2Cnt.values()){
            ans = Math.max(ans,val);
        }
        return ans;
    }
}