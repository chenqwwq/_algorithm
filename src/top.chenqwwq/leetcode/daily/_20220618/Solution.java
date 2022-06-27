package top.chenqwwq.leetcode.daily._20220618;

import top.chenqwwq.leetcode.common.Node;

/**
 * @author chenqwwq
 * @date 2022/6/18
 **/
public class Solution {
    Node node;

    public Node insert(Node head, int insertVal) {
        if (node == null) {
            node = head;
        }
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        } else if (head.next == null) {
            head.next = new Node(insertVal, head);
            // 1. 单个节点的情况
            // 2. 插入为最小值的情况
            // 3. 插入为最大值的情况
        } else if (head.next == node ||
        head.next == head || (head.val > head.next.val && ((insertVal > head.val || insertVal < head.next.val))) || (head.val <= insertVal && head.next.val >= insertVal)) {
            Node next = head.next;
            head.next = new Node(insertVal, next);
        } else {
            insert(head.next, insertVal);
        }
        return head;
    }

    public static void main(String[] args) {
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n1 = new Node(1);
        n3.next = n4;
        n4.next = n1;
        n1.next = n3;
        new Solution().insert(n3, 2);
    }
}