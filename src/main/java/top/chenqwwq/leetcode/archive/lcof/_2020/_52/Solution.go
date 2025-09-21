package _52

/**
 * @author chen
 * @date: 2020/7/19 下午4:29
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}

	nodeA, nodeB := headA, headB

	lenA, lenB := getLen(nodeA), getLen(nodeB)

	for lenA > lenB {
		headA = headA.Next
		lenA--
	}

	for lenB > lenA {
		headB = headB.Next
		lenB--
	}

	for headA != nil {
		if headB == headA {
			return headA
		}

		headA, headB = headA.Next, headB.Next
	}

	return nil
}

func getLen(node *ListNode) int {
	i := 0
	for node != nil {
		i++
		node = node.Next
	}

	return i
}
