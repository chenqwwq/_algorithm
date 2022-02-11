package top.chenqwwq.leetcode.biweek._38._1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 5539. 按照频率将数组升序排序 显示英文描述
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author chen
 * @date 2020/10/31
 **/
public class Solution {
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            if (hash.get(o1) > hash.get(o2)) {
                return 1;
            } else if (hash.get(o1) < hash.get(o2)) {
                return -1;
            } else {
                return o2.compareTo(o1);
            }
        }).mapToInt(Integer::valueOf).toArray();
    }
}