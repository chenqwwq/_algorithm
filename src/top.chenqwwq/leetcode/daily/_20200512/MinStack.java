package top.chenqwwq.leetcode.daily._20200512;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author chen
 * @date 2020-05-12
 **/
public class MinStack {

    Stack<Integer> stack;

    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
    }

    public void pop() {
        if (min == stack.pop()) {
            if (!stack.isEmpty()) {
                int i = Integer.MAX_VALUE;
                for (Integer next : stack) {
                    if (i > next) {
                        i = next;
                    }
                }
                min = i;
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
