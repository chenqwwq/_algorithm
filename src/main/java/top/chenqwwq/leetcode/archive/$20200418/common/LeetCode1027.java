package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1027.Longest Arithmetic Sequence
 *
 * @author chen
 * @date 19-6-21 上午7:46
 */
public class LeetCode1027 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1027().new Solution().longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

    class Solution {
        public int longestArithSeqLength(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }

            // 求最长的等差数列
            // 尝试用DP解决
            // mapList保存每个数字中的差值(key)和最大长度(value)
            List<Map<Integer, Integer>> mapList = new ArrayList<>(A.length);
            mapList.add(new HashMap<>());
            int max = 0;
            for (int i = 1; i < A.length; i++) {
                Map<Integer, Integer> map = new HashMap<>(i);
                for (int j = 0; j < i; j++) {
                    Integer orDefault = mapList.get(j).getOrDefault(A[i] - A[j], 0);
                    max = Math.max(orDefault + 1, max);
                    map.put(A[i] - A[j], orDefault + 1);
                }
                mapList.add(map);
            }

            return max + 1;
        }
    }
}
