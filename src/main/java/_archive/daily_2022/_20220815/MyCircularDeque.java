package top.chenqwwq.leetcode.daily._2022._20220815;

/**
 * @author chenqwwq
 * @date 2022/8/15
 **/
public class MyCircularDeque {
    int[] num;
    int cap;
    int size;
    int head;

    public MyCircularDeque(int k) {
        num = new int[k];
        cap = k;
        size = 0;
        head = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        num[head] = value;
        head = ((head - 1) + cap) % cap;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        int idx = (head + ++size + cap) % cap;
        num[idx] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = ((head + 1) + cap) % cap;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        int idx = ((head + 1) + cap) % cap;
        return num[idx];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int idx = (head + size + cap) % cap;
        return num[idx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}