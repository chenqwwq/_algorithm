package top.chenqwwq.leetcode.daily._2022._20220701;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/7/1
 **/
public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() <= 0) {
            return new ArrayList<>();
        }
        return dfs(expression, 0, expression.length() - 1);
    }

    public List<Integer> dfs(String e, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            final char c = e.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            }
            List<Integer> l1 = dfs(e, l, i - 1), l2 = dfs(e, i + 1, r);
            for (int a : l1) {
                for (int b : l2) {
                    ans.add(handle(a, b, c));
                }
            }
            return ans;
        }
        ans.add(Integer.valueOf(e.substring(l, r + 1)));
        return ans;
    }

    public int handle(int n1, int n2, char c) {
        switch (c) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }
}