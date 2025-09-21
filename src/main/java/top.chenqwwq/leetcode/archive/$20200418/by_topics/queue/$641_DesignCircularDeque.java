package top.chenqwwq.leetcode.archive.$20200418.by_topics.queue;

/**
 * 641. Design Circular Deque
 * Medium
 * <p>
 * Design your implementation of the circular double-ended queue (deque).
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 2
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 * <p>
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 *
 * @author chen
 * @date 2019/10/24 下午11:02
 */
public class $641_DesignCircularDeque {
    class MyCircularDeque {

        private int[] data;

        private int cap;

        private int size = 0;

        private int head = 0, tail = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {

            this.cap = k;

            data = new int[k];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            // 插入时考虑元素个数为0的情况
            if (size == 0) {
                data[head] = value;
            } else {
                data[head = des(head)] = value;
            }
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            if (size == 0) {
                data[tail] = value;
            } else {
                data[tail = incr(tail)] = value;
            }
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            if (size > 1) {
                head = incr(head);
            }
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            if (size > 1) {
                tail = des(tail);
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            return data[head];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return data[tail];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
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

        private int des(int i) {
            if (i == 0) {
                return cap - 1;
            }
            return --i;
        }
    }
}
