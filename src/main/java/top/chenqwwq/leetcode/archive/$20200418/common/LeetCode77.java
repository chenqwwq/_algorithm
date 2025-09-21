package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @email chenbxxx@gmail.con
 * @date 2019/2/28 16:46
 */
public class LeetCode77 {
    public static void main(String[] args) {
        new LeetCode77().new Solution().combine(4, 2);
    }

    class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            handle(new ArrayList<>(), 1, n, k);
            return res;
        }

        private void handle(List<Integer> temp, int pos, int n, int k) {
            // 添加到res
            if (temp.size() == k) {
                // 注意直接add(temp)的话会被后续的temp修改影响
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = pos; i <= n; i++) {
                temp.add(i);
                // 此处刚开始用pos+1,导致了2,2|3,3|4,4等重复数据
                handle(temp, i + 1, n, k);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
