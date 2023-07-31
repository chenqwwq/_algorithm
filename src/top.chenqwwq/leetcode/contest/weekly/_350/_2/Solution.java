package top.chenqwwq.leetcode.contest.weekly._350._2;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/6/18
 **/
public class Solution {
    public int findValueOfPartition(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            ans = Math.min(ans,nums[i+1] - nums[i]);
        }
        return ans;
    }
}