package top.chenqwwq.leetcode.daily._20200711;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * @author chen
 * @date 2020/7/11 下午9:59
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // 按照惯例，不会的先暴力
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    num++;
                }
            }
            res.add(num);
        }

        return res;
    }
}
