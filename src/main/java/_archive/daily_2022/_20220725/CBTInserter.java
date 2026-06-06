package top.chenqwwq.leetcode.daily._2022._20220725;

import org.w3c.dom.Node;
import top.chenqwwq.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenqwwq
 * @date 2022/7/25
 **/
public class CBTInserter {
    private static final int N = (int) 1e4 + 1;

    TreeNode root;
    TreeNode[] nodes = new TreeNode[N];
    int idx = 0;

    public CBTInserter(TreeNode root) {
        this.root = root;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            TreeNode pop = dq.pollFirst();
            nodes[idx++] = pop;
            if (pop.left != null) {
                dq.addLast(pop.left);
            }
            if (pop.right != null) {
                dq.addLast(pop.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        int pos = idx++;
        nodes[pos] = newNode;
        int parent = (pos - 1) >> 1;
        if((pos & 1) == 1){
            nodes[parent].left = newNode;
        }else{
            nodes[parent].right = newNode;
        }
        return nodes[parent].val;
    }

    public TreeNode get_root() {
        return root;
    }
}