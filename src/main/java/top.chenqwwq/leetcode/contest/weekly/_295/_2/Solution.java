package top.chenqwwq.leetcode.contest.weekly._295._2;

import java.text.DecimalFormat;

/**
 * @author chenqwwq
 * @date 2022/5/29
 **/
public class Solution {
    public String discountPrices(String sentence, int discount) {
        DecimalFormat df = new DecimalFormat("0.00");

        String[] ss = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String s : ss) {
            long num;
            if (s.startsWith("$") && s.length() > 1 && s.charAt(1) != '0' && (num = getNumber(s.substring(1))) != -1) {
                double fin = 1d * num * (100 - discount) / 100;
                ans.append("$").append(df.format(fin)).append(" ");
            } else {
                ans.append(s).append(" ");
            }
        }
        return ans.substring(0, ans.length() - 1);
    }

    private long getNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return -1;
            }
        }
        return Long.parseLong(s);
    }
}