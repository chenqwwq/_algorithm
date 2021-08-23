package _20200914

/**
 * @author chen
 * @date: 2020/9/14 上午9:45
 * @description:
 *
 */

/**
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var ans []int
	var recursion func(node *TreeNode)

	recursion = func(node *TreeNode) {
		if node == nil {
			return
		}

		recursion(node.Left)
		ans = append(ans, node.Val)
		recursion(node.Right)
	}

	recursion(root)

	return ans
}
