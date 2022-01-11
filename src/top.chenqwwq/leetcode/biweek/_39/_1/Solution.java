package top.chenqwwq.leetcode.biweek._39._1;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020/11/14
 **/
public class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int len = code.length * 2;
        int[] sum = new int[len];
        sum[0] = code[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + code[i % code.length];
        }

        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = sum[i + k] - sum[i];
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                code[i] = sum[i + code.length] - sum[i + code.length + k];
            }
        }

        return code;
    }
}