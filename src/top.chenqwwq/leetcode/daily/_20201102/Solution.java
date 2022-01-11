package top.chenqwwq.leetcode.daily._20201102;

import java.util.ArrayList;
import java.util.List;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author chen
 * @date 2020-11-02
 **/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] hash = new boolean[1000];
        List<Integer> ans = new ArrayList<>();
        for (int i : nums1) {
            hash[i] = true;
        }
        for (int j : nums2) {
            if (hash[j]) {
                hash[j] = false;
                ans.add(j);
            }
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}