package top.chenqwwq.leetcode.contest.weekly._391._1;

/**
 * @author chenqwwq
 * @date 2024/3/31
 **/
public class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = 0, y = x;
        while (x != 0) {
            num += x % 10;
            x /= 10;
        }
        return y % num == 0 ? num : -1;
    }
}