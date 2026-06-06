package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description 超级丑数 计划采用dp问题 每个丑数都由前面的丑数乘以丑基数,类似[2,3,5],此题可以自己设置
 * 具体细节可以看264的nth丑数
 * @email chenbxxx@gmail.con
 * @date 2019/1/18 14:39
 */
@Slf4j
public class LeetCode313 {
    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        log.info(new Solution().nthSuperUglyNumber(12, primes) + "");
    }

    static class Solution {
        /**
         * 保存计算过的丑数,只需要记录n个
         **/
        int[] res;
        /**
         * 存放所有丑数基最小值在res的下标
         */
        int[] dpSign;

        public <n> int nthSuperUglyNumber(int n, int[] primes) {
            if (n == 0 || n == 1) {
                return n;
            }
            dpSign = new int[primes.length];
            res = new int[n];
            res[0] = 1;
            int i = 1;
            while (i < n) {
                minAndIndex(i++, primes);
            }
            return res[n - 1];
        }

        public void minAndIndex(int i, int[] primes) {
            int length = primes.length;
            int[] resultTemp = new int[length];

            for (int j = 0; j < length; j++) {
                resultTemp[j] = primes[j] * res[dpSign[j]];
            }
            // 遍历并找到最小值
            int min = resultTemp[0];
            for (int r : resultTemp) {
                if (min > r) {
                    min = r;
                }
            }
            // 修改对应的结果集合
            res[i] = min;
            // 遍历并增加所有和最小值一致的丑基数下标
            for (int r = 0; r < length; r++) {
                if (min == resultTemp[r]) {
                    dpSign[r]++;
                }
            }
        }
    }
}
