package top.chenqwwq.leetcode.contest.weekly._289._1;

/**
 * @author chenqwwq
 * @date 2022/4/17
 **/
public class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = 0; j < k && i + j < s.length(); j++) {
                    sum += s.charAt(j + i) - '0';
                }
                next.append(String.valueOf(sum));
            }
            s = next.toString();
        }
        return s;
    }
}