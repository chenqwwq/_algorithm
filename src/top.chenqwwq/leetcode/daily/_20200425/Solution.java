package top.chenqwwq.leetcode.daily._20200425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author chen
 * @date 2020/4/25 下午6:44
 */
public class Solution {
    /**
     * result
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 边界判定
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            final List<Integer> ts = Arrays.asList(nums[0]);
            return new ArrayList<List<Integer>>() {{
                add(ts);
            }};
        }

        dfs(getList(nums), new ArrayList<>());

        return res;
    }

    public void dfs(List<Integer> list, List<Integer> s) {
        if (list.isEmpty()) {
            res.add(new ArrayList<>(s));
        }

        for (int i = 0; i < list.size(); i++) {
            final Integer e = list.get(i);
            s.add(e);
            list.remove(i);
            dfs(list, s);
            s.remove(e);
            list.add(i, e);
        }

    }

    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }
}
