package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/22 13:52
 */
@Slf4j
public class LeetCode672 {
    public static void main(String[] args) {
        log.info(Integer.toBinaryString(~1));
    }

    static class Solution {
        public int flipLights(int n, int m) {
            return 0;
        }

        /**
         * 所以灯泡状态取反
         *
         * @param a
         * @return
         */
        private int opera1(int a) {
            return ~a;
        }
    }
}
