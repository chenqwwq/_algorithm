package top.chenqwwq.leetcode.topic.array._349;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author chen
 * @date 2020/4/25 下午3:10
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        // hash求并集
        Map<Integer, Integer> hash = new HashMap<>(nums1.length + nums2.length);

        // 对num1做Hash
        for (int i : nums1) {
            hash.put(i, 1);
        }
        // 遍历nums2,将结果放在Set中
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums2) {
            if (hash.getOrDefault(i, 0) == 1) {
                set.add(i);
            }
        }
        int[] res = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            res[idx++] = i;
        }

        return res;
    }
}