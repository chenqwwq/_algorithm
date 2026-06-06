package top.chenqwwq.leetcode.utils;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chen
 * @date 2020/4/18 下午5:38
 */
public class ListUtils {

    /**
     * 二维数组转List
     */
    public static <E> List<List<E>> getList(E[][] arr) {
        ArrayList<List<E>> lists = new ArrayList<>();
        for (E[] ar : arr) {
            ArrayList<E> list = new ArrayList<>();
            Collections.addAll(list, ar);
            lists.add(list);
        }
        return lists;
    }

    public static <E> boolean compare2D(List<List<E>> l1, List<List<E>> l2) {
        outer:
        for (List<E> list : l1) {
            for (List<E> list1 : l2) {
                if (compare(list, list1)) {
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }

    public static <E> boolean compare(List<E> l1, List<E> l2) {
        assert l1 != null;
        assert l2 != null;
        if (l1.size() != l2.size()) {
            return false;
        }
        int i = 0;
        while (i < l1.size()) {
            if (!l2.contains(l1.get(i++))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 对比链表
     */
    public static boolean compareLinkedList(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        return h1 == null && h2 == null;
    }

    public static boolean compareLinkedList(ListNode list, int[] arr) {
        int i = 0;
        while (list != null && i < arr.length) {
            if (list.val != arr[i]) {
                return false;
            }
            i++;
            list = list.next;
        }

        return list == null && i == arr.length;
    }

    public static ListNode getList(int level) {
        ListNode head = new ListNode(1);
        ListNode tHead = head;
        for (int i = 2; i <= level; i++) {
            ListNode tempNode = new ListNode(i);
            tHead.next = tempNode;
            tHead = tempNode;
        }
        return head;
    }

}
