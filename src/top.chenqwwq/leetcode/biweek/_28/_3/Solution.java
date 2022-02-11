package top.chenqwwq.leetcode.biweek._28._3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 5423. 找两个和为目标值且不重叠的子数组 显示英文描述
 * <p>
 * 给你一个整数数组 arr 和一个整数值 target 。
 * <p>
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 * <p>
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 *
 * @author chen
 * @date 2020/6/13 下午10:53
 */
public class Solution {

    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 尝试用双指针解

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, sum = arr[0];
        while (right < arr.length) {
            if (sum == target) {
                res.add(right - left + 1);
                if (++right < arr.length) {
                    sum = arr[right];
                    left = right;
                    continue;
                }
                break;
            } else if (sum > target) {
                sum -= arr[left++];
            } else {
                if (++right < arr.length) {
                    sum += arr[right];
                }
            }
        }

        if (res.size() < 2) {
            return -1;
        }

        res.sort(Comparator.naturalOrder());
        return res.get(0) + res.get(1);
    }
}
