package top.chenqwwq.leetcode.daily._20200516;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 每日一题还是困难的，妈的 费时间了
 * 因为说是常数的额外空间，所以先尝试在链表自身上翻转
 *
 * @author chen
 * @date 2020/5/16 下午3:35
 */
public class Solution {

    int count = 0;

    boolean flag = true;

    ListNode nextHead;


    /**
     * 打算从递归形式的单链表翻转改
     * <p>
     * 分组翻转要改变:
     * 1. count计数达到k的时候就需要返回
     * 2. head.next不一定指向null，如果是中途返回还需要继续递归
     * 3. 如果组长度不够，需要标示跳过翻转
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 节点计数
        if (head != null) {
            count++;
        }

        // 边界处理
        if (head == null || head.next == null) {
            if (count != k) {
                flag = false;
            }
            return head;
        }

        // 如果足够一组的数目,直接返回,本轮递归结束
        if (count % k == 0) {
            count--;
            nextHead = head.next;
            return head;
        }
        // 递归调用,返回的是本组节点的头节点
        ListNode newHead = reverseKGroup(head.next, k);
        // 到最后不够组的时候不需要翻转，快速撤销
        if (!flag) {
            return head;
        }
        // 如果不够一组则不需要翻转
        // 将后一个节点指向前一个节点
        head.next.next = head;
        // count--在处理后继节点的时候会调用，如果为空或者够一组数目不需要处理后继结点，所以也需要调用
        // 需要在处理当前组第一个节点的时候判断是否开启下一轮递归
        // 1,2,3 如果此时count == 0，说明当前在处理值为1的节点的后继节点
        if (--count == 0 && nextHead != null) {
            final ListNode tNode = nextHead;
            nextHead = null;
            head.next = reverseKGroup(tNode, k);
        } else {
            head.next = null;
        }

        return newHead;
    }

    public void clean() {
        count = 0;
        flag = true;
        nextHead = null;
    }
}


