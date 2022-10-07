package top.chenqwwq.leetcode.daily._20220927;

/**
 * @author chenqwwq
 * @date 2022/9/27
 **/
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int n = s1.length(), m = s2.length(), tot = 0;
        if (n != m) return false;
        int[] cnts = new int[256];
        for (int i = 0; i < n; i++) {
            if (++cnts[s1.charAt(i)] == 1) tot++;
            if (--cnts[s2.charAt(i)] == 0) tot--;
        }
        return tot == 0;
    }
}
