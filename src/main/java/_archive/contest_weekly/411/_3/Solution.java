package top.chenqwwq.leetcode.contest.weekly._411._3;

/**
 * @author chenqwwq
 * @date 2024/8/20
 **/
public class Solution {


    public String largestPalindrome(int n, int k) {
        if (k == 1) return getNum(n);
        return "";
    }

    private String getNum(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) ans.append("9");
        return ans.toString();
    }
}