package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 868. Binary Gap
 *
 * @author chen
 * @date 19-5-18
 */
public class LeetCode868 {
    public static void main(String[] args) {
        // 101
        System.out.println(new LeetCode868().new Solution().binaryGap(5));
//        System.out.println(Integer.lowestOneBit(5));
//        System.out.println(Math.log(Integer.lowestOneBit(5)) / Math.log((double) 2));
    }

    class Solution {
        private final Double LOG2 = Math.log(2);

        public int binaryGap(int N) {
            int max = 0, i, j;

            j = (int) (Math.log(Integer.lowestOneBit(N)) / LOG2);
            N = (N - 1) & N;
            if (N == 0) {
                return 0;
            }
            while (N != 0) {
                i = (int) (Math.log(Integer.lowestOneBit(N)) / LOG2);
                max = Math.max(i - j, max);
                j = i;
                N = (N - 1) & N;
            }
            return max;
        }
    }
}
