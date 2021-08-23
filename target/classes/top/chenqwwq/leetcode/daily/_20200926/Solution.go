package _20200926

/**
 * @author chen
 * @date: 2020/9/26 下午9:19
 * @description:
 *
 */

/**
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	// 尝试回溯
	var ans [][]int

	var dfs func(curr int, path []int, node *TreeNode)

	dfs = func(curr int, path []int, node *TreeNode) {
		if node == nil {
			return
		}

		curr += node.Val
		path = append(path, node.Val)
		if curr == sum {
			if node.Right == nil && node.Left == nil {
				ans = append(ans, append([]int{}, path...))
			}
		}

		// 小于的情况
		dfs(curr, path, node.Left)
		dfs(curr, path, node.Right)
		path = path[:len(path)-1]
	}

	dfs(0, []int{}, root)

	return ans
}
