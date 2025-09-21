package top.chenqwwq.leetcode.contest.weekly._317._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/10/30
 **/
public class Solution {
    public long makeIntegerBeautiful(long num, int target) {
        int sum = 0;
        List<Integer> nums = new ArrayList<>();
        while (num != 0) {
            int d = (int) (num % 10);
            nums.add(d);
            sum += d;
            num /= 10;
        }
        if (sum <= target) return 0;
        final int n = nums.size();
        long ans = 0;
        int p = 0, k = 0;
        while (sum > target && p <= n) {
            int cur = (p < n ? nums.get(p) : 0) + k;
            sum = sum - nums.get(p) + 1 - k;
            if (cur != 10) {
                ans += (10 - cur) * Math.pow(10, p);
            }
            p++;
            k = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().makeIntegerBeautiful(74722, 6);
        // 14674
        //   326
    }
}