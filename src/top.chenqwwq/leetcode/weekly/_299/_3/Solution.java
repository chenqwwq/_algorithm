package top.chenqwwq.leetcode.weekly._299._3;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    public int maximumsSplicedArray(int[] n1, int[] n2) {
        final int n = n1.length;
        int[] diff = new int[n];
        int s1 = 0,s2 = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = n1[i] - n2[i];
            s1 += n1[i];
            s2 += n2[i];
        }
        int[] d1 = new int[n], d2 = new int[n];
        d1[0] = diff[0];
        d2[0] = diff[0];
        int a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            d1[i] = Math.min(diff[i], d1[i - 1] + diff[i]);
            a = Math.min(a, d1[i]);
            d2[i] = Math.max(diff[i], d2[i - 1] + diff[i]);
            b = Math.max(b, d2[i]);
        }
        return Math.max(s1 + Math.abs(a),s2 + b);
    }
}