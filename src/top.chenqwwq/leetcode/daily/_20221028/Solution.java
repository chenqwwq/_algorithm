package top.chenqwwq.leetcode.daily._20221028;

/**
 * @author chenqwwq
 * @date 2022/10/28
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        final int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = Math.max(i - 1, 0), r = Math.min(i+1, n - 1);
            while (l >= 0 && arr[i] < arr[l]) l--;
            while (r < n && arr[r] > arr[i]) r++;
            ans = (ans + (long) (r - l) * arr[i]) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4});
    }
}