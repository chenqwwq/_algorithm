package top.chenqwwq.leetcode.weekly._304._1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/7/31
 **/
public class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                ans++;
            }
        }
        return nums[0] == 0 ? ans - 1 : ans;
    }
}