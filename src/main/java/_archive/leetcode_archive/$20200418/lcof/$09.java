package top.chenqwwq.leetcode.archive.$20200418.lcof;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author chen
 * @date 2020/3/6 下午3:17
 */
public class $09 {
    class CQueue {

        /**
         * 将两个栈包装为队列
         * Stack为FILO,Queue为FIFO
         * <p>
         * 声明两个栈,dataStack,migrateStack
         * 数据保存在dataStack,
         * migrateStack用于顺序倒转
         */
        Stack<Integer> dataStack;
        Stack<Integer> migrateStack;

        public CQueue() {
            dataStack = new Stack<>();
            migrateStack = new Stack<>();
        }

        public void appendTail(int value) {
            dataStack.push(value);
        }

        public int deleteHead() {

            if (dataStack.isEmpty()) {
                return -1;
            }

            while (dataStack.size() > 1) {
                migrateStack.push(dataStack.pop());
            }

            final Integer pop = dataStack.pop();

            while (!migrateStack.isEmpty()) {
                dataStack.push(migrateStack.pop());
            }

            return pop;
        }
    }
}
