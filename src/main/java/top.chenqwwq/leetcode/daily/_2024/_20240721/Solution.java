package top.chenqwwq.leetcode.daily._2024._20240721;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public int maximumSum(int[] arr) {
        final int n = arr.length;
        if(n == 1) return arr[0];
        int[] right = new int[n], left = new int[n];
        right[0] = arr[0];
        left[n - 1] = arr[n - 1];
        int sum = arr[0]+arr[n-1];
        for (int i = 1; i < n-1; i++) {
            right[i] = max(arr[i], right[i - 1] + arr[i]);
            left[n - i - 1] = max(arr[n - i - 1], left[n - i] + arr[n - i - 1]);
            sum += arr[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i > 0 ? right[i - 1] : 0, r = i < n - 1 ? left[i + 1] : 0;
            // 选两边的情况
            ans = max(ans, l + r);
            // 选单边的情况
            if (i > 0) ans = max(ans, l);       // 仅选择左边
            if (i < n - 1) ans = max(ans, r);   // 仅选择右边
        }
        return max(ans, sum);
    }

    public int max(int... nums) {
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, num);
        }
        return ans;
    }
}