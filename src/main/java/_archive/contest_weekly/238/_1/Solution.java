package top.chenqwwq.leetcode.contest.weekly._238._1;

/**
 * @author chen
 * @date 2021-04-25
 **/
public class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n != 0) {
            sum += (n % k);
            n /= k;
        }
        return sum;
    }
}
