package _20200925

/**
  @user: chenqwwq
  @date: 2020/9/25
*/

/**
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 || len(postorder) == 0 {
		return nil
	}

	var rec func(is, id, ps, pd int) *TreeNode

	rec = func(is, id, ps, pd int) *TreeNode {
		for i := is; i <= id; i++ {
			// 中间节点
			if inorder[i] == postorder[pd] {
				return &TreeNode{postorder[pd], rec(is, i-1, ps, pd-id+i-1), rec(i+1, id, pd-id+i, pd-1)}
			}
		}

		return nil
	}

	return rec(0, len(inorder)-1, 0, len(postorder)-1)
}
