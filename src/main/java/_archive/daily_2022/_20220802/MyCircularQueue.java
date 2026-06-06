package top.chenqwwq.leetcode.daily._2022._20220802;

/**
 * @author chenqwwq
 * @date 2022/8/2
 **/
public class MyCircularQueue {

    int cap;
    int size;
    int head;
    int last;
    int[] nums;

    public MyCircularQueue(int k) {
        nums = new int[k];
        cap = k;
        head = last = size = 0;
    }

    public boolean enQueue(int value) {
        if (size >= cap) {
            return false;
        }
        nums[last] = value;
        last = (last + 1) % cap;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        head = (head + 1) % cap;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }

        return nums[head];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        int pos = (last + cap - 1) % cap;
        return nums[pos];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}