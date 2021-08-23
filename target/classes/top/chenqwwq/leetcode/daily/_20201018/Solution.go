package _20201018

/**
 * @author chen
 * @date: 2020/10/18 下午3:03
 * @description:
 *
 */

/**
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。

进阶：
你能尝试使用一趟扫描实现吗？
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	// 删除倒数第n个节点 语义上相当于将倒数第n+1个节点的Next指向n-1个节点
	// 注意要删除的节点在链表开头或者结尾的情况

	// 题意中确保初始化步骤有效
	// fast节点比slow提前n步
	fake := &ListNode{-1, head}
	fast, slow := head, fake
	for n > 0 {
		fast = fast.Next
		n--
	}

	for fast != nil {
		fast, slow = fast.Next, slow.Next
	}

	slow.Next = slow.Next.Next
	return fake.Next
}
