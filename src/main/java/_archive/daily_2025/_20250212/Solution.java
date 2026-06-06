package top.chenqwwq.leetcode.daily._2025._20250212;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenqwwq
 * @date 2025/2/12
 **/
@Slf4j
public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        final int n = nums.length;
        int l = 1, r = (int) 1e9;


        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, maxOperations)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().minimumSize(new int[]{9}, 2);
    }

    private boolean check(int[] nums, int k, int m) {
        // 拆分m次是否可以让所有数字小于k的时候
        int cnt = 0;
        for (int num : nums) {
            if (num <= k) continue;
            cnt += num / k + (num % k == 0 ? -1 : 0);
        }
        return cnt <= m;
    }
}