package top.chenqwwq.leetcode.contest.weekly._291._1;

/**
 * @author chenqwwq
 * @date 2022/5/1
 **/
public class Solution {
    public String removeDigit(String number, char digit) {
        // 3123
        // 3453
        // 3435
        int idx = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                idx = i;
            }
            if (number.charAt(i) == digit && i + 1 < number.length() && number.charAt(i + 1) > digit) {
                return number.substring(0, i) + number.substring(i+1);
            }
        }
        return number.substring(0,idx) + number.substring(idx+1);

    }
}