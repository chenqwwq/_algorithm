package top.chenqwwq.leetcode.contest.biweek._169._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/11/10
 **/
public class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        final int n = nums.length;
        final List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                arr.add(i);
            }
        }

        long ans = arr.size();       // 长度为 1 的
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                long cnt = j - i + 1;
                long len = arr.get(j) - arr.get(i) + 1;
                if (cnt * 2 <= len) break;

//                ans++;      // 两边什么都不加

                // 左右还有几个数字可以算进来
                long left = arr.get(i) - (i > 0 ? arr.get(i - 1) + 1 : 0);
                long right = (j < arr.size() - 1 ? arr.get(j + 1) - 1 : n - 1) - arr.get(j);

                // cnt = 2,len = 2
                // left = 1,right = 1
                final long max = Math.min(left + right, cnt * 2 - len - 1);      // 最多两边还能加这么多
                ans += get(left, right, max);
            }
        }

        return ans;
    }

    private long get(long l, long r, long max) {
        if (max < 0) return 0;

        long cnt = 0;
        long n = Math.min(l, max);

        for (int i = 0; i <= n; i++) {
            cnt += Math.min(r, max - i) + 1;
        }
        return cnt;
    }
}