package top.chenqwwq.leetcode.daily._2022._20220511;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2022/5/11
 **/
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        Deque<TreeNode> ns = new LinkedList<>();
        ns.addLast(root);
        while (!ns.isEmpty()) {
            TreeNode pop = ns.removeFirst();
            if (pop == null) {
                ret.append("#").append('E');
            } else {
                ret.append("#").append(pop.val);
                ns.addLast(pop.left);
                ns.addLast(pop.right);
            }
        }
        return ret.substring(1);
    }


    public TreeNode deserialize(String data) {
        String[] split = data.split("#");
        if (split.length <= 0 || Objects.equals(split[0], "E")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        Deque<TreeNode> ns = new LinkedList<>();
        ns.push(root);
        int n = 1;
        while (!ns.isEmpty() && n < split.length) {
            TreeNode pop = ns.removeFirst();
            if (!Objects.equals(split[n], "E")) {
                pop.left = new TreeNode(Integer.valueOf(split[n]));
                ns.addLast(pop.left);
            }
            n++;
            if (!Objects.equals(split[n], "E")) {
                pop.right = new TreeNode(Integer.valueOf(split[n]));
                ns.addLast(pop.right);
            }
            n++;
        }
        return root;
    }
}