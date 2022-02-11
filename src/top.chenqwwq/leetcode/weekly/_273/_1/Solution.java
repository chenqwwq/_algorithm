package top.chenqwwq.leetcode.weekly._273._1;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
public class Solution {
    public boolean isSameAfterReversals(int num) {
        return reversal(reversal(num)) == num;
    }

    public int reversal(int num) {
        int base = 1;
        int ans = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            ans += (c-'0') * base;
            base *= 10;
        }
        return ans;
    }
}