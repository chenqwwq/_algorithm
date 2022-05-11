package top.chenqwwq.leetcode.daily._20220509;

/**
 * @author chenqwwq
 * @date 2022/5/9
 **/
public class Solution {
    public int[] diStringMatch(String s) {
        final int n = s.length();
        final int[] ans = new int[n + 1];
        int l = 0, r = n;
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? l++ : r--;
        }
        ans[n] = s.charAt(n - 1) == 'I' ? r : l;
        return ans;
    }
}