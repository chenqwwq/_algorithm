package top.chenqwwq.leetcode.archive.lcof2._37;

/**
 * @author chenbingxin
 * @date 2022/1/1
 **/
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        final int n = asteroids.length;
        final int[] stack = new int[n];
        int top = 0;
        outer:
        for (int asteroid : asteroids) {
            if (top == 0 || stack[top - 1] < 0 || asteroid > 0) {
                stack[top++] = asteroid;
            } else {
                while (top != 0 && stack[top - 1] > 0 && stack[top - 1] <= -asteroid) {
                    if (stack[--top] == -asteroid) {
                        continue outer;
                    }
                }
                if (top == 0 || stack[top - 1] * asteroid > 0 || stack[top-1] < 0) {
                    stack[top++] = asteroid;
                }
            }
        }

        int[] ans = new int[top];
        for (int i = 0; i < top; i++) {
            ans[i] = stack[i];
        }
        return ans;
    }
}
