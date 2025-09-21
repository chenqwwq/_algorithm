package top.chenqwwq.leetcode.daily._2024._20240219;

import top.chenqwwq.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/2/19
 **/
public class Solution {
    public List<Integer> postorder(Node root) {
        final List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        for(Node node : root.children){
            ans.addAll(postorder(node));
        }
        ans.add(root.val);
        return ans;
    }
}