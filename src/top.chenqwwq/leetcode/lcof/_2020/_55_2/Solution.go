package _55_2

/**
  @user: chenqwwq
  @date: 2020/7/23
*/

/**
剑指 Offer 55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

限制：
1 <= 树的结点个数 <= 10000
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return dfs(root) >= 0
}

// 深搜
// 返回当前节点高度
func dfs(root *TreeNode) int {
	// 为空直接返回高度为0
	if root == nil {
		return 0
	}

	// 计算左右节点高度
	ld := dfs(root.Left)
	if ld < 0 {
		return -1
	}

	rd := dfs(root.Right)
	if rd < 0 || abs(ld-rd) > 1 {
		return -1
	}
	return max(ld, rd) + 1
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
