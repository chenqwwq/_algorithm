package top.chenqwwq.leetcode.daily._2023._20230720;

import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/7/20
 **/
public class Solution {

    private static final int INF = 0x3f3f3f3f;

    public int maxSubarraySumCircular(int[] nums) {
        final int n = nums.length;
        int[] min = new int[n], max = new int[n];
        int sum = nums[0], mmin, ans;
        Arrays.fill(min, INF);
        Arrays.fill(min, -INF);
        ans = mmin = max[0] = min[0] = nums[0];

        for (int i = 1; i < n; i++) {
            sum += nums[i];
            max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
            min[i] = Math.min(min[i - 1] + nums[i], nums[i]);

            ans = Math.max(max[i], ans);
            mmin = Math.min(mmin, min[i]);
        }

        return ans < 0 ? ans : Math.max(ans, sum - mmin);
    }
}