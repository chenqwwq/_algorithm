package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.stream.IntStream;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/22 13:34
 */
public class LeetCode977 {
    static class Solution {
        public int[] sortedSquares(int[] A) {
            return IntStream.of(A).map(a -> (int) Math.pow(a, 2)).sorted().toArray();
        }
    }
}
