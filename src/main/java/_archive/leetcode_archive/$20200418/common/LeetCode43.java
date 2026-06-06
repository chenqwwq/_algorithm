package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;


/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/17 9:45
 */
@Slf4j
public class LeetCode43 {
    public static void main(String[] args) {
        log.info(new Solution().multiply("111111", "1222"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] pos = new int[m + n];

            // 从高位开始遍历
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    // p2位置负责保存进位
                    int p1 = i + j, p2 = i + j + 1;
                    int sum = mul + pos[p2];

                    pos[p1] += sum / 10;
                    pos[p2] = (sum) % 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int p : pos) {
                if (!(sb.length() == 0 && p == 0)) {
                    sb.append(p);
                }
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
