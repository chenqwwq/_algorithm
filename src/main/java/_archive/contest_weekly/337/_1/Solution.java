package top.chenqwwq.leetcode.contest.weekly._337._1;

/**
 * @author chenqwwq
 * @date 2023/3/19
 **/
public class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        boolean flag = true;
        while (n != 0) {
            if (flag) even += (n & 1);
            else odd += (n & 1);
            flag = !flag;
            n >>= 1;
        }
        return new int[]{even, odd};
    }
}