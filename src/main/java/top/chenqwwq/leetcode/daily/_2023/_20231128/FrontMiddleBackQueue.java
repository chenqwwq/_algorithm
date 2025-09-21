package top.chenqwwq.leetcode.daily._2023._20231128;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2023/11/28
 **/
public class FrontMiddleBackQueue {

    private final Deque<Integer> front, back;

    public static void main(String[] args) {
        final FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushMiddle(5422);
        queue.pushMiddle(532228);
        System.out.println(queue.popBack());
        queue.pushMiddle(206486);
        queue.pushBack(351927);
        System.out.println(queue.popFront());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popBack());
        System.out.println(queue.popFront());
    }

    public FrontMiddleBackQueue() {
        front = new LinkedList<>();
        back = new LinkedList<>();
    }

    public void pushFront(int val) {
        front.addFirst(val);
        arrange();
    }

    public void arrange() {
        while (front.size() > back.size()) {
            back.addFirst(front.pollLast());
        }

        while (front.size() < back.size()-1) {
            front.addLast(back.pollFirst());
        }
    }

    public void pushMiddle(int val) {
        front.addLast(val);
        arrange();
    }

    public void pushBack(int val) {
        back.addLast(val);
        arrange();
    }

    public int popFront() {
        if (front.isEmpty() && back.isEmpty()) return -1;
        int ret = -1;
        if (front.isEmpty()) ret = back.pollFirst();
        else ret = front.pollFirst();
        arrange();
        return ret;
    }

    public int popMiddle() {
        if (front.isEmpty() && back.isEmpty()) return -1;
        int ret = -1;
        if (front.size() == back.size()) ret = front.pollLast();
        else ret = back.pollFirst();
        arrange();
        return ret;
    }

    public int popBack() {
        if (back.isEmpty() && front.isEmpty()) return -1;
        int ret = -1;
        if (back.isEmpty()) ret = front.pollLast();
        else ret = back.pollLast();
        arrange();
        return ret;
    }
}