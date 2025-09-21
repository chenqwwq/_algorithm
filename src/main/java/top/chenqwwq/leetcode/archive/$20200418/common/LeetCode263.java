package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description 求丑数，质因数只有2,3,5的数
 * @email chenbxxx@gmail.con
 * @date 2019/1/18 15:11
 */
@Slf4j
public class LeetCode263 {
    public static void main(String[] args) {
        log.info(new Solution().isUgly(14) + "");
    }

    static class Solution {
        private final int[] A = {2, 3, 5};

        public boolean isUgly(int num) {
            if (num < 1) {
                return false;
            }
            for (int i : A) {
                while (num % i == 0) {
                    num /= i;
                }
            }

            return num == 1;
        }
    }
}
