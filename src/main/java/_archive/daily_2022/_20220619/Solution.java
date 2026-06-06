package top.chenqwwq.leetcode.daily._2022._20220619;

import top.chenqwwq.leetcode.common.TreeNode;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author chenqwwq
 * @date 2022/6/19
 **/
public class Solution {
    Map<Integer, Integer> mmap = new HashMap<>();
    int mmax = -1;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : mmap.entrySet()){
            if(entry.getValue() == mmax){
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ret = root.val + dfs(root.left) + dfs(root.right);
        int cnt = mmap.getOrDefault(ret, 0) + 1;
        mmap.put(ret, cnt);
        mmax = Math.max(mmax,cnt);
        return ret;
    }
}