package top.chenqwwq.leetcode.daily._2024._20240224;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/2/24
 **/
public class Solution {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        final List<Integer> nums = new ArrayList<>();
        flat(root, nums);

        final int n = nums.size();
        final List<List<Integer>> ans = new ArrayList<>(queries.size());
        for (int val : queries) {
            // 找到小于 val 的最大值
            final int idx = floor(nums, val);
            if (idx >= n) {
                ans.add(List.of(nums.get(nums.size() - 1), -1));
                continue;
            }
            if(idx < 0){
                ans.add(List.of(-1,nums.get(0)));
                continue;
            }
            if (nums.get(idx) == val) ans.add(List.of(nums.get(idx), nums.get(idx)));
            else ans.add(List.of(nums.get(idx), idx + 1 < n ? nums.get(idx + 1) : -1));
        }
        return ans;
    }

    // 找到小于 val 的最大值

    /**
     * 找到第一个小雨或者等于的数字
     */
    public int floor(List<Integer> nums, int target) {
        final int n = nums.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            final int mid = (l + r) >> 1;
            if (nums.get(mid) > target) r = mid - 1;
            else l = mid + 1;
        }
        return r;
    }


    private void flat(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        flat(root.left, nums);
        nums.add(root.val);
        flat(root.right, nums);
    }
//    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//        final int n = queries.size();
//        List<List<Integer>> ans = new ArrayList<>(n);
//        for (Integer query : queries) {
//            ans.add(find(root, query, List.of(-1, -1)));
//        }
//        return ans;
//    }
//
//    public List<Integer> find(TreeNode root, Integer val,List<Integer> list) {
//        if(root == null) return list;
//        if(root.val == val) return List.of(val,val);
//        else if(root.val < val) return find(root.right,val,List.of(root.val,list.get(1)));
//        else return find(root.left,val,List.of(list.get(0),root.val));
//    }
}