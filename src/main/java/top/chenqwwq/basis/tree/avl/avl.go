package main

import (
	"strconv"
)

/**
 * @author chen
 * @date: 2021/10/2 11:17 下午
 * @description:
 * AVL 树就是可以自平衡的二叉查找树，查找和平衡的时间复杂度都为O(logN)
 * AVL 需要平衡的情况分为 LL，RR，LR，RL 四种，
 * LL 情况如下：
 *  [5]        [5]					[4]
 *   /   ===>  /    == rotate =>    / \
 * [4]       [4]				  [3] [5]
 *          /
 *        [3]
 * 文字表述上就是失衡节点(5)下挂到左子节点(4)的右节点上，并且将其右节点改为自己的右节点，RR 可以类推。
 * <p>
 * 如果是 LR 就是先 LL 转化为 RR 的形态，在进行 RR 的操作，RL 可以类推
 * <p>
 * 旋转注意节点高度的变化
 */
// node AVL 树节点
type node struct {
	left, right *node
	val         int
	height      int
}

// AVLTree 接口
type AVLTree interface {
	Add(val int) *node
	Del(avl int) *node
	IsBalance() bool
	Max() *node
	Min() *node
	Find(target int) *node
	Contains(target int) *node
}

// AVL 树
type AVL struct {
	root          *node
	balanceFactor int // 平衡因子，能接受的左右子树的高度差
}

func (avl *AVL) Add(val int) *node {
	// create new node
	newNode := newNode(val)
	// add to root
	add(avl.root, newNode)
	return newNode
}

func (avl *AVL) Del(val int) *node {
	// TODO:
	return nil
}

func (avl *AVL) Contains(target int) *node {
}

func (avl *AVL) Find(target int) *node {
	return find(avl.root, target)
}

func (avl *AVL) Max() *node {
	return maxNode(avl.root)
}

func (avl *AVL) Min() *node {
	return minNode(avl.root)
}

func Constructor() *AVL {
	return &AVL{}
}

func (avl *AVL) String() string {
	return format(avl.root)
}

func (avl *AVL) IsBalance() bool {
	return isBalance(avl.root)
}

// 内部方法

func del(_node *node, target int) *node {
	if _node == nil {
		return nil
	}
	if _node.val == target {
		if _node.left != nil && _node.right != nil {

		} else if _node.left != nil {
			_node = _node.left
		} else if _node.right != nil {
			_node = _node.right
		} else {
			_node = nil
		}
	}
}

func find(_node *node, target int) *node {
	if _node == nil {
		return nil
	}

	if _node.val == target {
		return _node
	}
	if _node.val > target {
		return find(_node.left, target)
	}
	return find(_node.right, target)
}

func maxNode(_node *node) *node {
	if _node == nil || _node.right == nil {
		return _node
	}
	return maxNode(_node.right)
}

func minNode(_node *node) *node {
	if _node == nil || _node.left == nil {
		return _node
	}
	return minNode(_node.left)
}

func add(root, newNode *node) *node {
	if root == nil {
		root = newNode
		return root
	}
	if root.val == newNode.val {
		return root
	}
	ans := root
	if newNode.val < root.val {
		ans = add(root.left, newNode)
		if root.left.height-root.right.height > 1 {
			if newNode.val == root.left.left.val {
				rotateRR(root)
			} else if newNode.val == root.left.right.val {
				rotateRL(root)
			}
		}
	} else {
		ans = add(root.right, newNode)
		if root.right.height-root.left.height > 1 {
			if newNode.val == root.right.right.val {
				rotateLL(root)
			} else if newNode.val == root.right.left.val {
				rotateLR(root)
			}
		}
	}
	root.height = max(getHeight(root.right), getHeight(root.left)) + 1
	return ans
}

func format(n *node) string {
	if n == nil {
		return "#"
	}
	return strconv.Itoa(n.val) + format(n.left) + format(n.right)
}

func newNode(val int) *node {
	return &node{
		val:    val,
		height: 1,
	}
}

func isBalance(n *node) bool {
	if n == nil {
		return true
	}
	return abs(getHeight(n.left)-getHeight(n.right)) <= 1
}

func getHeight(n *node) int {
	if n == nil {
		return 0
	}
	return n.height
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// 旋转方法
// LL 和 RR 可能颠倒

// rotateRR 表示的是左左的失去平衡
// 理解中的需要左旋的情况
//       5
//      / \
//     4   t1              4
//    / \	  --右旋->	 /   \
//   3   t2		        3     5
//  / \                / \   / \
// t3  t4             t3 t4 t2  t1
func rotateRR(root *node) *node {
	// modify ptr
	left := root.left
	root.left = left.right
	left.right = root

	// update node's height
	// important: 个人在这里有一个误区
	// 高度表示的是当前节点下的子节点的层数，同个节点的左右节点的高度可能是不同的
	root.height = max(getHeight(root.left), getHeight(root.right)) + 1
	left.height = max(getHeight(left.left), getHeight(left.right)) + 1
	return left
}

// rotateLL
func rotateLL(root *node) *node {
	right := root.right
	root.right = right.left
	right.left = root
	root.height = max(getHeight(root.left), getHeight(root.right)) + 1
	right.height = max(getHeight(right.left), getHeight(right.right)) + 1
	return right
}

// rotateLR
func rotateLR(root *node) *node {
	root.left = rotateLL(root.left)
	return rotateRR(root)
}

// rotateRL
func rotateRL(root *node) *node {
	root.right = rotateRR(root.right)
	return rotateLL(root)
}
