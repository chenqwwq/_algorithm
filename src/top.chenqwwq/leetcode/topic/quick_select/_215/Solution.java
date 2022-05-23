package top.chenqwwq.leetcode.topic.quick_select._215;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    public int quickSelect(int[] nums, int k, int ll, int rr) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.printf("\n %d %d %d\n", ll, rr, k);
        if (ll == rr) {
            return nums[ll];
        }
        int pivot = nums[ll], l = ll, r = rr + 1;
        while (l < r) {
            while (--r > l && nums[r] >= pivot) {}
            while (++l < r && nums[l] <= pivot) {}
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, ll, r);
        // 按照下标r区分，左边小于nums[r]，右边大于nums[r]
        // 左边长度为 rr - r(不包含r
        int cnt = rr - r;
        if (cnt < k) {
            return quickSelect(nums, k - cnt, ll, r);
        } else {
            return quickSelect(nums, k, r + 1, rr);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }
}