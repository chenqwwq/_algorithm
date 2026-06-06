package top.chenqwwq.leetcode.daily._2024._20240303;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2024/3/3
 **/
public class MyStack {
    // 栈是先入后出 队列是先进先出

    Queue<Integer> q1, q2,t;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        final MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.top());
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        t = q2;
        q2 = q1;
        q1 = t;
        // 1 2 3
    }

    public int pop() {
        if(q1.isEmpty())return -1;
        return q1.poll();
    }

    public int top() {
        if(q1.isEmpty())return -1;
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}