package top.chenqwwq.leetcode.daily._20201110;


/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author chen
 * @date 2020-11-10
 **/
public class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前第一个降序的相邻点
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            swapRange(nums, 0, nums.length - 1);
            return;
        }

        // 从后往前找第一个比i大的数
        int j = nums.length - 1;
        for (; j >= i; j--) {
            if (nums[i] < nums[j]) {
                break;
            }
        }

        swapIndex(nums, i, j);
        swapRange(nums, i + 1, nums.length - 1);
    }

    private void swapIndex(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void swapRange(int[] arr, int l, int r) {
        while (r > l && r < arr.length && l >= 0) {
            swapIndex(arr, l, r);
            r--;
            l++;
        }
    }
}