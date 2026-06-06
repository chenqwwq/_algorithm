package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * @author CheNbXxx
 * @description 这个题目不怎么样
 * @email chenbxxx@gmail.con
 * @date 2019/1/29 13:48
 */
public class LeetCode575 {
    static class Solution {
        public int distributeCandies(int[] candies) {
            return Math.min((int) Arrays.stream(candies).distinct().count(), candies.length / 2);
        }
    }
}
