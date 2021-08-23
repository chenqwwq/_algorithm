package _20200802

/**
  @user: chenqwwq
  @date: 2020/8/2
*/

/**
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	var getEnd func(root *TreeNode) *TreeNode

	getEnd = func(root *TreeNode) *TreeNode {
		// 叶子节点直接返回
		if root.Left == nil && root.Right == nil {
			return root
		}

		var end *TreeNode
		right := root.Right

		if root.Left != nil {
			end = getEnd(root.Left)
			root.Right = root.Left
			end.Right = right
			root.Left = nil
		}

		if right == nil {
			return end
		}

		return getEnd(right)
	}

	getEnd(root)

}
