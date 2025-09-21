package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列的全排列
 * 1. 照常考虑穷举递归
 *
 * @author chen
 * @date 19-3-16
 */
public class LeetCode46 {

    public static void main(String[] args) {
        System.out.println(new LeetCode46().new Solution().permute(new int[]{1, 2, 3}));
    }

    class Solution {

        List<List<Integer>> res;

        int length;

        int max;

        public List<List<Integer>> permute(int[] nums) {
            return bitHandle(nums);
        }

        private List<List<Integer>> bitHandle(int[] nums) {
            res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }

            length = nums.length;
            // 用数字中的每一位表示是否已经使用
            max = (int) Math.pow(2, length) - 1;
            bitMe(0, new ArrayList<>(), nums);

            return res;
        }

        private void bitMe(int curr, List<Integer> currPath, int[] nums) {
            if (curr == max) {
                res.add(currPath);
                return;
            }
            // 遍历数组中所有的0,将其变为1并递归
            for (int i = 0; i < length; i++) {
                if ((curr >> i & 1) == 0) {
                    List<Integer> list = new ArrayList<>(currPath);
                    list.add(nums[i]);
                    bitMe(curr | (1 << i), list, nums);
                }
            }
        }

    }
}
