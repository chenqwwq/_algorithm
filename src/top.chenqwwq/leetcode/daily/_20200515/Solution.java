package top.chenqwwq.leetcode.daily._20200515;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author chen
 * @date 2020-05-15
 **/
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 此题不适合滑动窗口解，因为元素有正有负，没办法保证窗口的扩展和收缩具有单调性。
        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
