package top.chenqwwq.leetcode.daily._20200612;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author chen
 * @date 2020-06-12
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 从数组中找出所有的集合，和为0
        // 排序之后使用双指针遍历

        // 结果
        List<List<Integer>> res = new ArrayList<>();

        // 异常输入
        if (nums == null || nums.length < 3) {
            return res;
        }

        // 排序
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int target = -nums[i];
            if (set.contains(target)) {
                continue;
            }
            set.add(target);
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    while (nums[left++] == nums[left] && left < right) {
                    }
                } else if (sum > target) {
                    while (nums[right--] == nums[right] && left < right) {
                    }
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left++] == nums[left] && left < right) {
                    }
                }

            }
        }

        return res;
    }
}