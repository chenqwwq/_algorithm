package top.chenqwwq.leetcode.contest.biweek._110._1;

/**
 * @author chenqwwq
 * @date 2023/8/8
 **/
public class Solution {
    public int accountBalanceAfterPurchase(int p) {
        int a = p / 10, b = p % 10;
        if(b >= 5) return 100 - a * 10 - 10;
        else return 100 - a * 10;
    }
}