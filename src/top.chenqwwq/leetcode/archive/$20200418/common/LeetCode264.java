package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description 求解第n个丑数, 采用动态规划，记录求解过的值
 * 丑数都等于前面的丑数 * 2,3,5.
 * <p>
 * 动态规划在我的理解就是将一个大问题划分成小问题,并在迭代或者别的计算中保留小问题的结果
 * @email chenbxxx@gmail.con
 * @date 2019/1/18 16:47
 */
@Slf4j
public class LeetCode264 {
    public static void main(String[] args) {
        log.info(new Solution().nthUglyNumber(10) + "");
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            // 记录结果
            int[] result = new int[n];

            // 1是最初的丑数
            result[0] = 1;

            int resultIndex = 1;
            // 记录2,3,5增长的丑数的最大值下标
            int ugly2 = 0, ugly3 = 0, ugly5 = 0, min;

            while (resultIndex < n) {
                int ugly22 = result[ugly2] * 2;
                int ugly33 = result[ugly3] * 3;
                int ugly55 = result[ugly5] * 5;
                min = Math.min(ugly22, Math.min(ugly33, ugly55));
                if (min == ugly22) {
                    ugly2++;
                }
                if (min == ugly33) {
                    ugly3++;
                }
                if (min == ugly55) {
                    ugly5++;
                }
                result[resultIndex++] = min;
            }
            return result[n - 1];
        }
    }
}
