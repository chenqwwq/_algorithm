package top.chenqwwq.leetcode.topic.stack._224;


import java.util.*;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * @author chen
 * @date 2021/5/25
 **/
public class Solution {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int ans = 0, sign = 1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int num = s.charAt(i) - '0';
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = 10 * num + s.charAt(i) - '0';
					i++;
				}
				if (stack.isEmpty()) {
					stack.push(num);
					continue;
				}
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					final int op = stack.pop();
					final int pop = stack.pop();
					if (op == '*') {
						num *= pop;
					} else {
						num = pop / num;
					}
				}
				if (!stack.isEmpty() && stack.peek() == '-') {
					stack.pop();
					stack.push(-num);
				} else {
					stack.push(num);
				}
			} else if (s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '(') {
				stack.push((int) s.charAt(i));
			} else if (s.charAt(i) == ')') {
				int num = 0;
				while (!stack.isEmpty() && stack.peek() != '(') {
					num += stack.pop();
				}
				stack.pop();
				if (!stack.isEmpty() && stack.peek() == '-') {
					stack.pop();
					stack.push(-num);
				} else {
					stack.push(num);
				}
			}
		}
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}
}