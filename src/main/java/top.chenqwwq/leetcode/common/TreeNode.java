package top.chenqwwq.leetcode.common;

public class TreeNode {

    public static final TreeNode DEFAULT = new TreeNode(-1);

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        this.val = x;
    }

    public TreeNode(Integer x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
