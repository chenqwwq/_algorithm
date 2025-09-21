package top.chenqwwq.leetcode.contest.weekly._307._2;

/**
 * @author chenqwwq
 * @date 2022/8/21
 **/
public class Solution {
    public String largestPalindromic(String num) {
        final int n = num.length();
        int[] hash = new int[10];
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            hash[c - '0']++;
        }

        int max = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (hash[i] == 0) {
                continue;
            }
            if (hash[i] > 1) {
                if (!(i == 0 && sb.length() == 0)) {
                    for (int j = 0; j < hash[i] >> 1; j++) {
                        sb.append(i);
                    }
                    hash[i] &= 1;
                }
            }
            if (hash[i] > 0 && max == -1) {
                max = i;
            }
        }
        if (max != -1) {
            sb.append(max);
            int m = sb.length();
            for (int i = m - 2; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
        } else {
            int m = sb.length();
            for (int i = m - 1; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().largestPalindromic("1111");
    }
}