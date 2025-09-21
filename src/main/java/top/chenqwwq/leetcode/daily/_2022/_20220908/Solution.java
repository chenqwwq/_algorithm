package top.chenqwwq.leetcode.daily._2022._20220908;

/**
 * @author chenqwwq
 * @date 2022/9/8
 **/
public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int num = 1,m = n;
        for (int i = 0; i < n - k; i++) ans[i] = num++;
        for (int i = n - k + 1; i < n; i += 2) ans[i] = num++;
        for (int i = n - k; i < n; i += 2) ans[i] = m--;
        return ans;
    }
}