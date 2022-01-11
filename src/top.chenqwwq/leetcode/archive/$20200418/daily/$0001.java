package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author chen
 * @date 2020/3/6 下午3:48
 */
public class $0001 {
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
}
