package top.chenqwwq.leetcode.archive.$20200418.by_topics.queue;

/**
 * 622. Design Circular Queue
 * Medium
 * <p>
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 *
 * @author chen
 * @date 2019/10/24 下午10:43
 */
public class $622_DesignCircularQueue {
    class MyCircularQueue {

        private int[] data;

        private int cap;

        private int size = 0, top = 0, end = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            data = new int[k];
            cap = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (size == cap) {
                return false;
            }
            // 赋值到end
            if (size == 0) {
                data[end] = value;
            } else {
                data[(end = incr(end))] = value;
            }
            size++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            if (size > 1) {
                top = incr(top);
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (size == 0) {
                return -1;
            }

            return data[top];
        }


        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (size == 0) {
                return -1;
            }

            return data[end];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == cap;
        }

        private int incr(int i) {
            if (i == cap - 1) {
                return 0;
            }
            return ++i;
        }
    }
}

