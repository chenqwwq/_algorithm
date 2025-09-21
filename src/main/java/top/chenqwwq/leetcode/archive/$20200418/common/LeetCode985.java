package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 985. Sum of Even numbers after queries
 *
 * @author chen
 * @date 19-6-10
 */
public class LeetCode985 {
    public static void main(String[] args) {
        new Solution().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
    }

    static class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            // 刚看题目有点莫名其妙
            if (queries == null || queries.length == 0) {
                return null;
            }
            int[] ans = new int[queries.length];

            // 算出全部的偶数和
            int sum = 0;
            for (int a : A) {
                if ((a & 1) == 0) {
                    sum += a;
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int var = queries[i][0];
                int index = queries[i][1];
                boolean a = (var & 1) == 1;
                boolean b = (A[index] & 1) == 1;
                if (a && b) {
                    // a,b 都为奇数
                    sum += A[index];
                    sum += var;
                } else if (a) {
                    // 新为奇数,旧为偶数,减去旧偶数
                    sum -= A[index];
                } else if (!b) {
                    // 新旧都为偶数,加上新数
                    sum += var;
                }
                A[index] += var;
                ans[i] = sum;
            }

            return ans;
        }
    }
}
