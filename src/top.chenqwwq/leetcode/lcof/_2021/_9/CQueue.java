package top.chenqwwq.leetcode.lcof._2021._9;

import java.util.Stack;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class CQueue {
	Stack<Integer> real, buff;

	public CQueue() {
		real = new Stack<>();
		buff = new Stack<>();
	}

	public void appendTail(int value) {
		while (!real.isEmpty()) {
			buff.push(real.pop());
		}
		buff.push(value);
		while (!buff.isEmpty()) {
			real.push(buff.pop());
		}
	}

	public int deleteHead() {
		if (real.isEmpty()) {
			return -1;
		}
		return real.pop();
	}
}