package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author CheNbXxx
 * @description 垃圾题目, 真是莫名其妙
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 10:23
 */
public class LeetCode944 {
    static class Solution {
        public int minDeletionSize(String[] A) {
            if (A.length < 1) {
                return 0;
            }
            int result = 0;
            // 每个字符串的长度
            for (int i = 0; i < A[0].length(); i++) {
                for (int k = 0; k < A.length - 1; k++) {
                    if (A[k].charAt(i) > A[k + 1].charAt(i)) {
                        result++;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
