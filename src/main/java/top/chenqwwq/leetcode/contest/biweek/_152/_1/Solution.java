package top.chenqwwq.leetcode.contest.biweek._152._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2025/3/15
 **/
public class Solution {
    public int totalNumbers(int[] digits) {
        final int n = digits.length;
        Set<Integer> exist = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if ((digits[i] & 1) == 1) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] == 0) continue;
                    exist.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        return exist.size();
    }

}