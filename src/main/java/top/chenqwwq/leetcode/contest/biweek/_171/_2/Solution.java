package top.chenqwwq.leetcode.contest.biweek._171._2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/12/13
 **/
public class Solution {
    private static final List<Integer> palindromes = new ArrayList<>();
    private static boolean initialized = false;

    // 这样写比 static block 快
    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        final int MX = 5000;
        final int BASE = 2;

        // 哨兵，0 也是回文数
        palindromes.add(0);

        for (int pw = 1; ; pw *= BASE) {
            // 生成奇数长度回文数
            for (int i = pw; i < pw * BASE; i++) {
                int x = i;
                for (int t = i / BASE; t > 0; t /= BASE) {
                    x = x * BASE + t % BASE;
                }
                if (x > MX) {
                    // 哨兵，5049 是大于 5000 的第一个二进制回文数
                    palindromes.add(5049);
                    return;
                }
                palindromes.add(x);
            }

            // 生成偶数长度回文数
            for (int i = pw; i < pw * BASE; i++) {
                int x = i;
                for (int t = i; t > 0; t /= BASE) {
                    x = x * BASE + t % BASE;
                }
                if (x > MX) {
                    palindromes.add(5049);
                    return;
                }
                palindromes.add(x);
            }
        }
    }

    public int[] minOperations(int[] nums) {
        init();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int j = Collections.binarySearch(palindromes, x);
            if (j < 0) j = ~j;
            // 变成 >= x 的二进制回文数，或者变成 < x 的二进制回文数
            nums[i] = Math.min(palindromes.get(j) - x, x - palindromes.get(j - 1));
        }
        return nums;
    }
}