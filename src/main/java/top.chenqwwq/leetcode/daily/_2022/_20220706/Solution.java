package top.chenqwwq.leetcode.daily._2022._20220706;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 沽酒
 * @since 2022/07/06
 */
public class Solution {
    private final static String LET = "let", ADD = "add", MULT = "mult";

    String exp;

    public static void main(String[] args) {
        System.out.println(new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
    }

    public int evaluate(String expression) {
        this.exp = expression;
        return dfs(1, expression.length() - 2, new HashMap<>());
    }

    private int dfs(int l, int r, Map<String, Integer> params) {
        String cmd = getKey(l, r);
        l += cmd.length() + 1;
        switch (cmd) {
            case LET:
                int mid = getFinalExp(l, r);
                Map<String, Integer> inner = new HashMap<>(params);
                String param;
                while (l < mid) {
                    if (exp.charAt(l) == '(') break;
                    param = getKey(l, mid);
                    l += param.length() + 1;
                    if (exp.charAt(l) == '(') {
                        inner.put(param, dfs(l + 1, getRight(l, mid) - 1, params));
                    } else {
                        String val = getKey(l, mid);
                        inner.put(param, Integer.parseInt(val));
                        l += val.length() + 1;
                    }
                }
                return handle(mid, r, exp.substring(mid + 1, r + 1), inner);
            case ADD: {
                String p1 = getKey(l, r);
                int i1 = handle(l, r, p1, params);
                l += p1.length() + 1;
                String p2 = getKey(l, r);
                int i2 = handle(l, r, p2, params);
                return i1 + i2;
            }
            case MULT: {
                String p1 = getKey(l, r);
                int i1 = handle(l, r, p1, params);
                l += p1.length() + 1;
                String p2 = getKey(l, r);
                int i2 = handle(l, r, p2, params);
                return i1 * i2;
            }
            default:
                break;
        }
        return 1;
    }

    public int handle(int l, int r, String str, Map<String, Integer> params) {
        final char c = exp.charAt(l);
        if (c == '(') {
            return dfs(l + 1, r - 1, params);
        } else if (Character.isDigit(c)) {
            return Integer.parseInt(str);
        } else {
            return params.get(str);
        }
    }

    public int getFinalExp(int l, int r) {
        if (exp.charAt(r) == ')') {
            while (l < r) {
                if (exp.charAt(r) == '(') {
                    return r;
                }
                r--;
            }
        } else {
            --r;
            while (l < r) {
                if (exp.charAt(r) == ' ') {
                    return r;
                }
                --r;
            }
        }
        return -1;
    }

    public int getRight(int l, int r) {
        while (l < r) {
            if (exp.charAt(l) == ')') {
                return l;
            }
            l++;
        }
        return -1;
    }

    public String getKey(int l, int r) {
        StringBuilder key = new StringBuilder();
        while (l <= r && exp.charAt(l) != ' ' && exp.charAt(l) != ')') {
            key.append(exp.charAt(l++));
        }
        return key.toString();
    }
}