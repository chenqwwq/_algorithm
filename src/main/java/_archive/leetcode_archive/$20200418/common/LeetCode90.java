package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.*;

/**
 * 子集2：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 和`78题子集`相比,nums数组中可能会重复
 *
 * @author bingxin.chen
 * @date 2019/3/15 11:57
 */
public class LeetCode90 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("10", "20");
        map.put("11", "22");
        System.out.println(map);
    }

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }
            // 先排序 使重复的数字聚集在一块
            Arrays.sort(nums);
            dfs(new ArrayList<>(), nums, 0);
            return res;
        }

        private void dfs(List<Integer> currPath, int[] nums, int index) {
            if (index <= nums.length) {
                res.add(new ArrayList<>(currPath));
            }
            for (int i = index; i < nums.length; i++) {
                currPath.add(nums[i]);
                dfs(currPath, nums, index + 1);
                do {
                    if (currPath.size() > 0) {
                        currPath.remove(currPath.size() - 1);
                        ++i;
                    }
                } while (currPath.size() > 0 && i < nums.length && currPath.get(currPath.size() - 1).equals(nums[i]));
            }
        }
    }

}
