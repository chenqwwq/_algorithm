package top.chenqwwq.leetcode.archive.$20200418.by_topics.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Easy
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @author chen
 * @date 2020/3/1 下午12:16
 */
public class $225_ImplementStackUsingQueues {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    class MyStack {

        /**
         * 两个队列实现栈
         * <p>
         * dataQueue 为具体的存放数据的queue
         * migrateQueue 为转移queue
         */
        Queue<Integer> dataQueue;
        Queue<Integer> migrateQueue;

        /**
         * 保存top值
         */
        int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            dataQueue = new LinkedList<>();
            migrateQueue = new LinkedList<>();

            top = -1;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            top = x;
            dataQueue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (empty()) {
                return -1;
            }

            if (dataQueue.size() == 1) {
                top = -1;
                return dataQueue.poll();
            }

            // 将dataQueue的数据导入migrateQueue
            while (dataQueue.size() > 1) {
                if (dataQueue.size() == 2) {
                    top = dataQueue.peek();
                }
                migrateQueue.add(dataQueue.poll());
            }
            final Integer poll = dataQueue.poll();

            Queue<Integer> tempQueue = migrateQueue;
            migrateQueue = dataQueue;
            dataQueue = tempQueue;

            return poll;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return empty() ? -1 : top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return dataQueue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
