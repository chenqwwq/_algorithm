package top.chenqwwq.leetcode.weekly._308._1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/8/28
 **/
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        final int n = nums.length,m = queries.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        int[] ans = new int[m];
        outer:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] > queries[i]) {
                    ans[i] = j;
                    continue outer;
                }
            }
            ans[i] = n;
        }
        return ans;
    }
}