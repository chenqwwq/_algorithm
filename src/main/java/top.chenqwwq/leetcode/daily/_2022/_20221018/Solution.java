package top.chenqwwq.leetcode.daily._2022._20221018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/10/18
 **/
public class Solution {
    int[] nums;
    int m;

    public int dp(int max) {
        // 将 max 拆成位
        List<Integer> list = new ArrayList<>();
        while (max != 0) {
            list.add(max % 10);
            max /= 10;
        }
        // max 总位数
        int n = list.size(), ans = 0;
        // 从最高位开始,求位数相同的数字的个数
        for (int i = n - 1, p = 1; i >= 0; i--, p++) {
            int cur = list.get(i);
            int l = 0, r = m - 1;
            // 二分找到第一个小小于或者等于当前值的数
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (nums[mid] <= cur) l = mid;
                else r = mid - 1;
            }
            if (nums[r] > cur) break;
            if (nums[r] == cur) {
                ans += r * (int) Math.pow(m, n - p);
                if (i == 0) ans++;
            } else if (nums[r] < cur) {
                ans += (r + 1) * (int) Math.pow(m, n - p);
                break;
            }
        }
        // 位数比n 小
        for (int i = 1, last = 1; i < n; i++) {
            int cur = last * m;
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        m = digits.length;
        nums = new int[m];
        // digits 已经排序
        for (int i = 0; i < m; i++) nums[i] = Integer.parseInt(digits[i]);

        return dp(n);
    }
}