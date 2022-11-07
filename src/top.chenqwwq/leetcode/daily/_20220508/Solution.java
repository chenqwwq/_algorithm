package top.chenqwwq.leetcode.daily._20220508;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/8
 **/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        final int n = nums.length;
        int i = 0;
        while (i < n) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            i++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}