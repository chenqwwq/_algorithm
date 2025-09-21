package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author CheNbXxx
 * @description 对排序完之后的数组进行头尾遍历
 * @email chenbxxx@gmail.con
 * @date 2019/1/24 13:48
 */
@Slf4j
public class LeetCode581 {
    public static void main(String[] args) {
        int[] i = new int[]{2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = new Solution().findUnsortedSubarray(i);
        log.info(unsortedSubarray + "");
    }

    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // 取一个拷贝数组排列
            int length = nums.length;
            int[] sortedNums = new int[length];
            System.arraycopy(nums, 0, sortedNums, 0, length);
            Arrays.sort(sortedNums);

            // 前后遍历
            int res = 0, i = 0, j = nums.length - 1;

            for (; i < nums.length; i++) {
                if (sortedNums[i] == nums[i]) {
                    res++;
                    continue;
                }
                break;
            }
            for (; j > i; j--) {
                if (sortedNums[j] == nums[j]) {
                    res++;
                    continue;
                }
                break;
            }
            return length - res;
        }
    }
}
